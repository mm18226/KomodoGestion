package pruebaproyecto

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class AreaDeTrabajoController {

    AreaDeTrabajoService areaDeTrabajoService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured ('ROLE_ADMIN')
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond areaDeTrabajoService.list(params), model:[areaDeTrabajoCount: areaDeTrabajoService.count()]
    }

    @Secured ('ROLE_ADMIN')
    def show(Long id) {
        respond areaDeTrabajoService.get(id)
    }

    @Secured ('ROLE_ADMIN')
    def create() {
        respond new AreaDeTrabajo(params)
    }

    @Secured ('ROLE_ADMIN')
    def save(AreaDeTrabajo areaDeTrabajo) {
        if (areaDeTrabajo == null) {
            notFound()
            return
        }

        try {
            areaDeTrabajoService.save(areaDeTrabajo)
        } catch (ValidationException e) {
            respond areaDeTrabajo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'areaDeTrabajo.label', default: 'AreaDeTrabajo'), areaDeTrabajo.id])
                redirect areaDeTrabajo
            }
            '*' { respond areaDeTrabajo, [status: CREATED] }
        }
    }

    @Secured ('ROLE_ADMIN')
    def edit(Long id) {
        respond areaDeTrabajoService.get(id)
    }

    @Secured ('ROLE_ADMIN')
    def update(AreaDeTrabajo areaDeTrabajo) {
        if (areaDeTrabajo == null) {
            notFound()
            return
        }

        try {
            areaDeTrabajoService.save(areaDeTrabajo)
        } catch (ValidationException e) {
            respond areaDeTrabajo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'areaDeTrabajo.label', default: 'AreaDeTrabajo'), areaDeTrabajo.id])
                redirect areaDeTrabajo
            }
            '*'{ respond areaDeTrabajo, [status: OK] }
        }
    }

    @Secured ('ROLE_ADMIN')
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        areaDeTrabajoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'areaDeTrabajo.label', default: 'AreaDeTrabajo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'areaDeTrabajo.label', default: 'AreaDeTrabajo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
