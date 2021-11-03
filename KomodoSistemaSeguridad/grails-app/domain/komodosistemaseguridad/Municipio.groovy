package komodosistemaseguridad

class Municipio {
    //atributos
    String nombre
    static belongTo=[departamento:Departamento]
    
   

    static constraints = {
    }
    
    /*static mapping={
        table 'municipio'
        version false
    }*/
    String toString(){
        "${nombre}"
    }
}
