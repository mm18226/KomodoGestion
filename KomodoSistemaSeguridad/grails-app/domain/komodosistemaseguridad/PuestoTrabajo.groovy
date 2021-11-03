package komodosistemaseguridad

class PuestoTrabajo {
    //atributos
    String nombre

    static constraints = {
    }
    /*static mapping={
        table 'puestotrabajo'
        version false
    }*/
    String toString(){
        "${nombre}"
    }
}
