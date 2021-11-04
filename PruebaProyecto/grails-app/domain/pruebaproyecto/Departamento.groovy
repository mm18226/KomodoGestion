package pruebaproyecto

class Departamento {

    //Atributos
    String nombre
    static hasMany = [municipios:Municipio]

    static constraints = {
    }

    static mapping={
        table 'Departamento'
        version false
    }

    String toString(){
        "${nombre}"
    }
}
