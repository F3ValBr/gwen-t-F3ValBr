package cl.uchile.dcc
package gwent

class Jugador(val nombre: String, val seccion: Int, var gemas: Int) {


  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Jugador]) {
      val foo = other.asInstanceOf[Jugador]
      nombre == foo.nombre && seccion == foo.seccion
    } else {
      false
    }
  }
}
