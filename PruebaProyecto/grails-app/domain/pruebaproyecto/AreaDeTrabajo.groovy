package pruebaproyecto

class AreaDeTrabajo {

    //Atributos
    String nombre
    static hasMany = [puestos:PuestoTrabajo]

    static constraints = {
    }

        static mapping={
        table 'AreaDeTrabajo'
        version false
    }

    String toString(){
        "${nombre}"
    }
}
