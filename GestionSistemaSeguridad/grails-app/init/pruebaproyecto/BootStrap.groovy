package pruebaproyecto
import pruebaproyecto.Usuario
import pruebaproyecto.UserRole
import pruebaproyecto.Role

class BootStrap {
    UsuarioService usuarioService

    def init = { servletContext ->
        new Role(authority: 'ROLE_ADMIN').save()
        new Role(authority: 'ROLE_USER').save()

        /*Usuario usuario= 
        new Usuario(username:'david',password:'david',fullname:'david', correo:'ha@gmail.com', telefono:'72', dui:'987654321' )
        usuarioService.save(usuario)*/
    }
    def destroy = {
    }
}
