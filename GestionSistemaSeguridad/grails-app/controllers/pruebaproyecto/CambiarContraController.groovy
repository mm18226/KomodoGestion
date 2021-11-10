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
        //obtener datos de logueado
        def principal = springSecurityService.principal
      String dui = principal.dui
      //intancia usuario de usuario logueado
      def usuario=Usuario.findByDui(dui)
      //verificar que contraseña y confirmar contraseña coinciden
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
