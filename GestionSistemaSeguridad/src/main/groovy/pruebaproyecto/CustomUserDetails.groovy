package pruebaproyecto

import grails.plugin.springsecurity.userdetails.GrailsUser
import org.springframework.security.core.GrantedAuthority

class CustomUserDetails extends GrailsUser {

   final String fullname
   final String dui
   final String codigoA2F
   final boolean primeraV

   CustomUserDetails(String username, String password, boolean enabled,
                 boolean accountNonExpired, boolean credentialsNonExpired,
                 boolean accountNonLocked,
                 Collection<GrantedAuthority> authorities,
                 long id, String fullname, String dui, String codigoA2F, boolean primeraV) {
      super(username, password, enabled, accountNonExpired,
            credentialsNonExpired, accountNonLocked, authorities, id)

      this.fullname = fullname
      this.dui=dui
      this.codigoA2F=codigoA2F
      this.primeraV=primeraV
   }
}