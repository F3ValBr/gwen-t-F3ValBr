package cl.uchile.dcc
package gwent.jugadores

import gwent.jugadores.AbstractJugador
import gwent.cartas.{Carta, DeckClass}
import java.util.Objects
import scala.collection.mutable.ListBuffer

/** Una clase JugadorCPU, extiende a AbstractJugador
 *
 * @constructor JugadorCPU define a la computadora contra quien juega el jugador principal
 * @param _name Nombre del jugador
 * @param _gems Gemas del jugador, inicialmente son 2
 * @param decknum Mazo del jugador, inicialmente de 25 cartas
 * @param handnum Mano del jugador, inicialmente de 0 cartas
 * @param _deck_list Lista de cartas del mazo del jugador
 * @param _hand_list Lista de cartas de la mano del jugador
 */
class JugadorCPU (_name: String,
                  _gems: Int = 2,
                  decknum: Int = 25,
                  handnum: Int = 0,
                  _deck_list: DeckClass = DeckClass(),
                  _hand_list: ListBuffer[Carta] = ListBuffer())
  extends AbstractJugador(_name,_gems,decknum,handnum,_deck_list,_hand_list) with Equals {

  // Definicion inicial de getters
  override val name: String = _name
  gems = _gems

  deck_list = _deck_list
  hand_list = _hand_list.clone()

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
