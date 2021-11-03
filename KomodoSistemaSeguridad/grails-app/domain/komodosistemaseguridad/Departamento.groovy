package komodosistemaseguridad

class Departamento {
//Atributo
String nombre
static hasMany = [municipios:Municipio]

   
    static constraints = {
    }
    
    
  /*  static mapping={
        table 'departamento'
        version false
    }*/
    String toString(){
        "${nombre}"
    }
}
