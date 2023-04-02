package cl.uchile.dcc
package gwent

class Jugador(val nombre: String, val seccion: Int, var gemas: Int, var mazo: Int, var mano: Int) {
  // quitar_gema se encarga de descontar gemas de un jugador
  def quitar_gema(): Unit = {
    if (gemas > 0){
      gemas -= 1
    }
  }

  // prim_toma es la asignacion de las primeras 10 cartas por partida
  def prim_toma(): Unit = {
    if (mazo == 25) {
      mazo -= 10
      mano += 10
    }
  }

  // tomar_cartas_mazo permite al jugador sacar un numero determinado de cartas y anadirlas a su mano
  def tomar_cartas_mazo(cartas_a_tomar: Int): Unit = {
    if (mazo > 0 && cartas_a_tomar <= 3) {
      mazo -= cartas_a_tomar
      mano += cartas_a_tomar
    }
  }

  // funcion para comparar dos objetos iguales, aun estando en ubicaciones distintas de memoria
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Jugador]) {
      val foo = other.asInstanceOf[Jugador]
      nombre == foo.nombre && seccion == foo.seccion
    } else {
      false
    }
  }
}
