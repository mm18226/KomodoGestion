package pruebaproyecto

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import pruebaproyecto.Usuario

class EmpleadoController {

    EmpleadoService empleadoService
    UsuarioService usuarioService
    UserRoleService userRoleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond empleadoService.list(params), model:[empleadoCount: empleadoService.count()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def show(Long id) {
        respond empleadoService.get(id)
    }

    @Secured('ROLE_ADMIN')
    def create() {
        respond new Empleado(params)
    }

    @Secured('ROLE_ADMIN')
    def save(Empleado empleado) {
        if (empleado == null) {
            notFound()
            return
        }

        try {
            empleadoService.save(empleado) 
            //aqui va 
            createUsuario(empleado)
        } catch (ValidationException e) {
            respond empleado.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'empleado.label', default: 'Empleado'), empleado.id])
                  
                redirect empleado
            }
            '*' { respond empleado, [status: CREATED] }
        }
    }
    
@Secured('ROLE_ADMIN')    
def createUsuario(Empleado empleado){
    
        //Creando los valores del usuario. 
        String nomUsuario

        nomUsuario = empleado.nombres.charAt(0)
        nomUsuario+=empleado.apellidos.charAt(0)
        nomUsuario+=empleado.dui.charAt(0)
        nomUsuario+=empleado.dui.charAt(1)
        nomUsuario+=empleado.dui.charAt(2)
        String contra

        contra=getPassword(MINUSCULAS+MAYUSCULAS+ESPECIALES,10)

        boolean bloq=false
        boolean accoExp=false
        boolean passExp=false
        boolean habilitado=true
        String nombre=empleado.nombres
        //Creando el usuario y guardandolo.
        Usuario usuario= new Usuario(username:nomUsuario,password:contra,fullname:nombre, enabled:false, dui:empleado.dui, correo:'JohnDoe@gmail.com', telefono:'12') 
            usuarioService.save(usuario)  
       
        UserRole userRole=new UserRole(user:usuario, role:empleado.role)
            userRoleService.save(userRole)  
             

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

    
    

    @Secured('ROLE_ADMIN')
    def edit(Long id) {
        respond empleadoService.get(id)
    }

    @Secured('ROLE_ADMIN')
    def update(Empleado empleado) {
        if (empleado == null) {
            notFound()
            return
        }

        try {
            empleadoService.save(empleado)
        } catch (ValidationException e) {
            respond empleado.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'empleado.label', default: 'Empleado'), empleado.id])
                redirect empleado
            }
            '*'{ respond empleado, [status: OK] }
        }
    }

    @Secured('ROLE_ADMIN')
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        empleadoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'empleado.label', default: 'Empleado'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'empleado.label', default: 'Empleado'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    
}
