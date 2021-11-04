package pruebaproyecto

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AreaDeTrabajoController {

    AreaDeTrabajoService areaDeTrabajoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond areaDeTrabajoService.list(params), model:[areaDeTrabajoCount: areaDeTrabajoService.count()]
    }

    def show(Long id) {
        respond areaDeTrabajoService.get(id)
    }

    def create() {
        respond new AreaDeTrabajo(params)
    }

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

    def edit(Long id) {
        respond areaDeTrabajoService.get(id)
    }

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
