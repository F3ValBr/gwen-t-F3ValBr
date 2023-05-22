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
 * @param name Nombre del jugador
 * @param gems cantidad de vida en juego, representado como cantidad de gemas
 * @param decknum cartas disponibles a robar del mazo
 * @param handnum cartas disponibles a jugar en la mano del jugador
 * @param deck_list lista de cartas en el mazo
 * @param hand_list lista de cartas en la mano
 *
 */
class JugadorP1(name: String,
                gems: Int = 2,
                decknum: Int = 25,
                handnum: Int = 0,
                deck_list: DeckClass = DeckClass(),
                hand_list: ListBuffer[Carta] = ListBuffer())
  extends AbstractJugador(name, gems, decknum, handnum, deck_list, hand_list) with Equals {

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

