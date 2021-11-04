package pruebaproyecto

class PuestoTrabajo {
    //Atributos
    String nombre
    
    static belongsTo=[areaDeTrabajo:AreaDeTrabajo]

    static constraints = {
    }

    static mapping={
        table 'PuestoTrabajo'
        version false
    }

    String toString(){
        "${nombre}"
    }
}
