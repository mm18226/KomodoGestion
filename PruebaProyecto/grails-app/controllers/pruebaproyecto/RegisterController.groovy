package pruebaproyecto

import grails.validation.ValidationException
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import pruebaproyecto.Usuario
import pruebaproyecto.Role



import grails.plugin.springsecurity.SpringSecurityService

@Transactional
@Secured('permitAll')
class RegisterController {

    static allowedMethods = [register: "POST"]
    def springSecurityService

    def index() { }
    String contra
    Usuario user

    def register() {
        

        contra=getPassword(MINUSCULAS+MAYUSCULAS+ESPECIALES,10)
        
        def usuario = Usuario.findByDui(params.dui)
        if(usuario.registrado==false){
            try {
        
            user=usuario
            usuario.enabled=true
            usuario.password=contra
            usuario.correo=params.email
            usuario.telefono=params.telefono
            usuario.registrado=true
            send()
        
                    UserRole.withSession {
                      it.flush()
                      it.clear()
                    }
        flash.message = "Su usuario a sido habilita y sus credenciales enviadas a su correo."
                    redirect controller: "login", action: "auth"
        
 

        } catch (ValidationException e) {
                flash.message = "Register fallo, su dui no existe"
                redirect action: "index"
                return
            }
        }else{
            flash.message = "El dui de este usuario ya a sido registrado"
            redirect action: "index"
            return
        }

       


       
       /*
        if(!params.password.equals(params.repassword)) {
            flash.message = "Password and Re-Password not match"
            redirect action: "index"
            return
        } else {
            try {
                def user = Usuario.findByUsername(params.username)?: new Usuario(username: params.username, password: params.password, fullname: params.fullname).save()
                def role = Role.get(params.role.id)
                if(user && role) {
                    UserRole.create user, role

                    UserRole.withSession {
                      it.flush()
                      it.clear()
                    }

                    flash.message = "You have registered successfully. Please login."
                    redirect controller: "login", action: "auth"
                } else {
                    flash.message = "Register failed"
                    render view: "index"
                    return
                }
            } catch (ValidationException e) {
                flash.message = "Register Failed"
                redirect action: "index"
                return
            }
        } */
        
    }

     //Generar contraseña aleatoria
    
     static String NUMEROS = "0123456789"
 
	 static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
 
	 static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz"
 
	 static String ESPECIALES = "ñÑ"

    def static String getPinNumber() {
		return getPassword(NUMEROS, 4)
	}

    def static String getPassword() {
		return getPassword(8)
	}

    def static String getPassword(int length) {
		return getPassword(NUMEROS + MAYUSCULAS)
    }

    def static String getPassword(String key, int length) {
		String pswd = "";
 
		for (int i = 0; i < length; i++) {
			pswd+=(key.charAt((int)(Math.random() * key.length())));
		}
 
		return pswd;
	} 

    //Enviar credenciales
    def send() {
    sendMail {
        to params.email
        subject 'Credenciales de inicio de sesión'
        text 'Tus datos de inicio de sesion son '+'\n'+'Usuario: '+user.username+'\n'+'Contraseña: '+ contra
    }

    flash.message = "Message sent at "+new Date()
    
}

//enviar A2F
  def emailRegister(){
      

    def principal = springSecurityService.principal
      String dui = principal.dui
      def usuario=Usuario.findByDui(dui)

 
      sendCodigo( usuario)

  }


  def sendCodigo(Usuario usuario) {
      String codigo=getPassword(MINUSCULAS+MAYUSCULAS+ESPECIALES,10)
      usuario.codigoA2F=codigo
    sendMail {
        to usuario.correo
        subject 'Codigo A2F Komodo'
        text 'Tu codigo A2F es: '+ codigo
    }

    flash.message = "Revise su correo"
    redirect controller: "email", action: "index"
    
}


}
