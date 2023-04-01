package cl.uchile.dcc
package gwent

class Jugador(val nombre: String) {
  
  
  
  
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Jugador]) {
      val foo = other.asInstanceOf[Jugador]
      nombre == foo.nombre
    } else {
      false
    }
  }
}
