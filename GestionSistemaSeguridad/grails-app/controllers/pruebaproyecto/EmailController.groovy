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
         //obtener datos de logueado
         def principal = springSecurityService.principal
      String dui = principal.dui
      //intancia usuario de usuario logueado
      def usuario=Usuario.findByDui(dui)
      //capturar codigo ingresado de la vista 
      String cod=params.codigo
      //verficar que codigos son iguales
      if(cod.equals(usuario.codigoA2F)) {
          //Si el usuario es primera vez que ingresa al sistema
                    if(usuario.primeraV==true){
                        flash.message = "La contraseña debe tener entre 12 y 16 caracteres, al menos 1 digito, al menos 1 mayuscula, al menos una minuscula y un caracter especial"
                        redirect controller: "cambiarContra", action: "index" 

                    }else{
                        //Si NO es primera vez que ingresa al sistema
                   redirect controller: "empleado", action: "index" 
                    }
        } //Si el codigo ingresado no coincide
        else {
           flash.message = "El codigo no es correcto "
            redirect action: "index"
            return  
        }
     }
}
