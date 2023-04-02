package cl.uchile.dcc
package gwent

class Cartas(val clasific: String, var fuerza: Int, val tipo: String, val clima_tipo: String, val habil: String) {


  // funcion para determinar si dos valores son iguales pese a tener ubicaciones de memoria distintas
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Cartas]) {
      val goo = other.asInstanceOf[Cartas]
      tipo == goo.tipo // && seccion == foo.seccion
    } else {
      false
    }
  }
}
