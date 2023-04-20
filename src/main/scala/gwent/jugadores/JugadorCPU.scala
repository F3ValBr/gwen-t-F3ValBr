package cl.uchile.dcc
package gwent.jugadores

import gwent.jugadores.AbstractJugador
import gwent.cartas.{Carta, DeckClass}
import java.util.Objects
import scala.collection.mutable.ListBuffer

/** Una clase JugadorCPU, extiende a AbstractJugador
 *
 * @constructor JugadorCPU define a la computadora contra quien juega el jugador principal
 * @param name Nombre del jugador
 * @param gems Gemas del jugador, inicialmente son 2
 * @param decknum Mazo del jugador, inicialmente de 25 cartas
 * @param handnum Mano del jugador, inicialmente de 0 cartas
 * @param deck_list Lista de cartas del mazo del jugador
 * @param hand_list Lista de cartas de la mano del jugador
 */
class JugadorCPU (name: String,
                  gems: Int = 2,
                  decknum: Int = 25,
                  handnum: Int = 0,
                  deck_list: DeckClass = DeckClass(),
                  hand_list: ListBuffer[Carta] = ListBuffer())
  extends AbstractJugador(name,gems,decknum,handnum,deck_list,hand_list) with Equals {

  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[JugadorCPU]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[JugadorCPU]
      name == other.name
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[JugadorCPU], name)
  }
}
