package pruebaproyecto

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class PuestoTrabajoController {

    PuestoTrabajoService puestoTrabajoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured ('ROLE_ADMIN')
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond puestoTrabajoService.list(params), model:[puestoTrabajoCount: puestoTrabajoService.count()]
    }

    @Secured ('ROLE_ADMIN')
    def show(Long id) {
        respond puestoTrabajoService.get(id)
    }

    @Secured ('ROLE_ADMIN')
    def create() {
        respond new PuestoTrabajo(params)
    }

    @Secured ('ROLE_ADMIN')
    def save(PuestoTrabajo puestoTrabajo) {
        if (puestoTrabajo == null) {
            notFound()
            return
        }

        try {
            puestoTrabajoService.save(puestoTrabajo)
        } catch (ValidationException e) {
            respond puestoTrabajo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'puestoTrabajo.label', default: 'PuestoTrabajo'), puestoTrabajo.id])
                redirect puestoTrabajo
            }
            '*' { respond puestoTrabajo, [status: CREATED] }
        }
    }

    @Secured ('ROLE_ADMIN')
    def edit(Long id) {
        respond puestoTrabajoService.get(id)
    }

    @Secured ('ROLE_ADMIN')
    def update(PuestoTrabajo puestoTrabajo) {
        if (puestoTrabajo == null) {
            notFound()
            return
        }

        try {
            puestoTrabajoService.save(puestoTrabajo)
        } catch (ValidationException e) {
            respond puestoTrabajo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'puestoTrabajo.label', default: 'PuestoTrabajo'), puestoTrabajo.id])
                redirect puestoTrabajo
            }
            '*'{ respond puestoTrabajo, [status: OK] }
        }
    }

    @Secured ('ROLE_ADMIN')
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        puestoTrabajoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'puestoTrabajo.label', default: 'PuestoTrabajo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'puestoTrabajo.label', default: 'PuestoTrabajo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
