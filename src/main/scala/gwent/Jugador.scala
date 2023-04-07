package cl.uchile.dcc
package gwent

/** Clase jugador representa al jugador o jugadores en una partida de gwent
 *
 * Jugador se define por su nombre, su seccion en el tablero, su cantidad de gemas
 * inicialmente es 2 (en representacion a su vida), mazo de cartas a su disposicion
 * y la mano de cartas con la cual juega
 *
 * @param nombre Nombre del jugador
 * @param seccion Ubicacion en el tablero
 * @param gemas cantidad de vida en juego
 * @param mazo cartas disponibles a robar
 * @param mano cartas disponibles a jugar
 *
 * @author Felipe Valdebenito Bravo
 * */
class Jugador(val nombre: String,
              val seccion: Int,
              var gemas: Int = 2,
              var mazo: Int = 25,
              var mano: Int = 0) {

  /** quitar_gema se encarga de descontar gemas de un jugador */
  def quitar_gema(): Unit = {
    if (gemas > 0){
      gemas -= 1
    }
  }

  /** prim_toma es la asignacion de las primeras 10 cartas por partida */
  def prim_toma(): Unit = {
    if (mazo > 0) {
      mazo -= 10
      mano += 10
    }
  }
  /** Funcion auxiliar para sacar cartas de una mano en juego */
  def descontar_mano(cartas_sacar: Int): Unit = {
    mano -= cartas_sacar
  }

  /** tomar_cartas_mazo permite al jugador sacar un numero determinado de cartas y anadirlas a su mano */
  def tomar_cartas_mazo(): Unit = {
    if (mazo > 0 && mano <= 7) {
      mazo -= 3
      mano += 3
    } else if (mazo > 0 && mano > 7) {
      val resto: Int = 10 - mano
      mazo -= resto
      mano += resto
    }
  }

  /** funcion para comparar dos objetos iguales, aun estando en ubicaciones distintas de memoria */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Jugador]) {
      val foo = other.asInstanceOf[Jugador]
      nombre == foo.nombre && seccion == foo.seccion
    } else {
      false
    }
  }
}
