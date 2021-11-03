package komodosistemaseguridad

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AreaTrabajoController {

    AreaTrabajoService areaTrabajoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond areaTrabajoService.list(params), model:[areaTrabajoCount: areaTrabajoService.count()]
    }

    def show(Long id) {
        respond areaTrabajoService.get(id)
    }

    def create() {
        respond new AreaTrabajo(params)
    }

    def save(AreaTrabajo areaTrabajo) {
        if (areaTrabajo == null) {
            notFound()
            return
        }

        try {
            areaTrabajoService.save(areaTrabajo)
        } catch (ValidationException e) {
            respond areaTrabajo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'areaTrabajo.label', default: 'AreaTrabajo'), areaTrabajo.id])
                redirect areaTrabajo
            }
            '*' { respond areaTrabajo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond areaTrabajoService.get(id)
    }

    def update(AreaTrabajo areaTrabajo) {
        if (areaTrabajo == null) {
            notFound()
            return
        }

        try {
            areaTrabajoService.save(areaTrabajo)
        } catch (ValidationException e) {
            respond areaTrabajo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'areaTrabajo.label', default: 'AreaTrabajo'), areaTrabajo.id])
                redirect areaTrabajo
            }
            '*'{ respond areaTrabajo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        areaTrabajoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'areaTrabajo.label', default: 'AreaTrabajo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'areaTrabajo.label', default: 'AreaTrabajo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
