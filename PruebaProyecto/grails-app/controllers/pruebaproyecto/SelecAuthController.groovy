package pruebaproyecto

import grails.validation.ValidationException
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional
@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class SelecAuthController {

    def index() { }
}
