package pruebaproyecto
import pruebaproyecto.Usuario
import pruebaproyecto.UserRole
import pruebaproyecto.Role

class BootStrap {

    def init = { servletContext ->
        new Role(authority: 'ROLE_ADMIN').save()
        new Role(authority: 'ROLE_USER').save()
    }
    def destroy = {
    }
}
