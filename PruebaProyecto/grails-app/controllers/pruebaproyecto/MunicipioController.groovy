package pruebaproyecto

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MunicipioController {

    MunicipioService municipioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond municipioService.list(params), model:[municipioCount: municipioService.count()]
    }

    def show(Long id) {
        respond municipioService.get(id)
    }

    def create() {
        respond new Municipio(params)
    }

    def save(Municipio municipio) {
        if (municipio == null) {
            notFound()
            return
        }

        try {
            municipioService.save(municipio)
        } catch (ValidationException e) {
            respond municipio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'municipio.label', default: 'Municipio'), municipio.id])
                redirect municipio
            }
            '*' { respond municipio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond municipioService.get(id)
    }

    def update(Municipio municipio) {
        if (municipio == null) {
            notFound()
            return
        }

        try {
            municipioService.save(municipio)
        } catch (ValidationException e) {
            respond municipio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'municipio.label', default: 'Municipio'), municipio.id])
                redirect municipio
            }
            '*'{ respond municipio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        municipioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'municipio.label', default: 'Municipio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'municipio.label', default: 'Municipio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
