package pruebaproyecto
import grails.validation.ValidationException
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import pruebaproyecto.Usuario

import grails.plugin.springsecurity.SpringSecurityService


@Transactional
@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class CambiarContraController {
def springSecurityService
    def index() { 

    }
    def confirmarContraseña(){

        def principal = springSecurityService.principal
      String dui = principal.dui
      def usuario=Usuario.findByDui(dui)
        if(!params.password.equals(params.repassword)) {
            flash.message = "Las contraseñas no coinciden"
            redirect action: "index"
            return
        } else {
            usuario.primeraV=false
            usuario.password=params.password
            redirect controller: "empleado", action: "index" 
            
    }
}
}
