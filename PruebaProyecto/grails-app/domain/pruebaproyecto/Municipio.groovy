package pruebaproyecto

class Municipio {

    //Atributos
    String nombre
    static belongsTo=[departamento:Departamento]

    static constraints = {
    }

    static mapping={
        table 'Municipio'
        version false
    }

    String toString(){
        "${nombre}"
    }
}
