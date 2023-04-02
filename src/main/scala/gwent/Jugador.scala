package cl.uchile.dcc
package gwent

class Jugador(val nombre: String, val seccion: Int, var gemas: Int, var mazo: Int, var mano: Int) {
  def quitar_gema(): Unit = {
    if (gemas > 0){
      gemas -= 1
    }
  }

  def prim_toma(): Unit = {
    if (mazo == 25) {
      mazo -= 10
      mano += 10
    }
  }

  def tomar_cartas_mazo(cartas_a_tomar: Int): Unit = {
    if (mazo > 0 && cartas_a_tomar <= 3) {
      mazo -= cartas_a_tomar
      mano += cartas_a_tomar
    }
  }

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Jugador]) {
      val foo = other.asInstanceOf[Jugador]
      nombre == foo.nombre && seccion == foo.seccion
    } else {
      false
    }
  }
}
