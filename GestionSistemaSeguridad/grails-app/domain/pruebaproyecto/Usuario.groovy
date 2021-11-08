package pruebaproyecto

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class Usuario implements Serializable {

    private static final long serialVersionUID = 1
    int id
    String username
    String password
    boolean enabled = true
    boolean registrado = false
    boolean accountExpired
    boolean accountLocked = false
    boolean passwordExpired

    boolean primeraV = true
    String fullname
    String correo 
    String telefono
    String dui
    String codigoA2F


    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        fullname nullable: false, blank: false
        dui unique:true, blank: true, nullable:true
        correo email:true, blank:true, nullable:true
        telefono  blank:true, nullable:true
        codigoA2F blank:true, nullable:true

    
    }

    static mapping = {
         
        version false
	    password column: '`password`'

    }

       

}
