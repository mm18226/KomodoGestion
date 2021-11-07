package pruebaproyecto
import grails.validation.ValidationException
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import pruebaproyecto.Usuario

import grails.plugin.springsecurity.SpringSecurityService


@Transactional
@Secured(['ROLE_ADMIN', 'ROLE_USER'])

class EmailController {
def springSecurityService
//static allowedMethods = [email: "POST"]

    def index() { 
        

    }
     def email() {
         
         redirect controller: "register", action: "emailRegister"

     }
     def verificarCod(){
         
         def principal = springSecurityService.principal
      String dui = principal.dui
      def usuario=Usuario.findByDui(dui)
      String cod=params.codigo
      if(cod.equals(usuario.codigoA2F)) {
                   redirect controller: "empleado", action: "index" 
        } 
        else {
           flash.message = "El codigo no es correcto "
            redirect action: "index"
            return  
        }
     }
}