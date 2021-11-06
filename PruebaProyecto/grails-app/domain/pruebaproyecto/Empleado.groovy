package pruebaproyecto

class Empleado {

    //Atributos
    String nombres
    String apellidos
    Date fechaNacimiento
    double salario
    String direccion
    String genero
    String estadoCivil
    String dui
    String nup
    String isss

    Municipio municipio
    Departamento departamento
    PuestoTrabajo puestoTrabajo
    AreaDeTrabajo areaTrabajo
    Role role

    static constraints = {
        nombres blank:false,matches:"[a-zA-Z-' ']+"
        apellidos blank:false,matches:"[a-zA-Z-' ']+"
        fechaNacimiento blank:false 
        genero blank:false,matches:"[a-zA-Z-' ']+"
        estadoCivil blank:false,matches:"[a-zA-Z-' ']+"
        departamento blank:false
        municipio blank: false
        direccion blank: false
        salario blank:false, scale:2
        dui blank:false,matches:"[0-9]{9}", unique:true
        isss blank:false,matches:"[0-9]{9}"
        nup blank:false,matches:"[0-9]{13}"
        areaTrabajo  blank:false
        puestoTrabajo  blank:false
        role blank:false
    }

        static mapping={
        table 'Empleado'
        version false
    }
}
