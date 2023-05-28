package cl.uchile.dcc
package gwent.jugadores

import gwent.jugadores.AbstractJugador
import gwent.cartas.{Carta, DeckClass}
import java.util.Objects
import scala.collection.mutable.ListBuffer

/** Una Clase JugadorP1, extiende a AbstractJugador
 *
 * @constructor JugadorP1 define al jugador humano en el juego, con los atributos de su nombre, su cantidad de gemas
 *              que es inicialmente 2, sus cartas en el mazo deck que son inicialmente 25 y su mano hand que inicia en 0 cartas
 * @param _name Nombre del jugador
 * @param _gems cantidad de vida en juego, representado como cantidad de gemas
 * @param decknum cartas disponibles a robar del mazo
 * @param handnum cartas disponibles a jugar en la mano del jugador
 * @param _deck_list lista de cartas en el mazo
 * @param _hand_list lista de cartas en la mano
 *
 */
class JugadorP1(_name: String,
                _gems: Int = 2,
                decknum: Int = 25,
                handnum: Int = 0,
                _deck_list: DeckClass = DeckClass(),
                _hand_list: ListBuffer[Carta] = ListBuffer())
  extends AbstractJugador(_name, _gems, decknum, handnum, _deck_list, _hand_list) with Equals {

  // Definicion inicial de getters
  override val name: String = _name
  gems = _gems

  deck_list = _deck_list
  hand_list = _hand_list.clone()
  
  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[JugadorP1]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[JugadorP1]
      name == other.name
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[JugadorP1], name)
  }
}

