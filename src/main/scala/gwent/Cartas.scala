package cl.uchile.dcc
package gwent

class Cartas(val tipo: String) {
  
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Cartas]) {
      val goo = other.asInstanceOf[Cartas]
      tipo == goo.tipo // && seccion == foo.seccion
    } else {
      false
    }
  }
}
