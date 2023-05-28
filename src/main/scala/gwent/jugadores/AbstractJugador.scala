package cl.uchile.dcc
package gwent.jugadores

import gwent.cartas.{Carta, DeckClass}

import scala.collection.mutable.ListBuffer

/** Una clase abstracta AbstractJugador, extiende a Jugador
 *
 * @constructor AbstractJugador cre un jugador con un nombre, una cantidad de gemas, un mazo y una mano de cartas
 *              con las cuales puede jugar, ademas de definir los metodos del_gems, first_take, del_hand y take_cards_deck
 *              definidos mas abajp
 * @param name Nombre del jugador
 * @param gems cantidad de vida en juego, representado como cantidad de gemas
 * @param decknum cartas disponibles a robar del mazo
 * @param handnum cartas disponibles a jugar en la mano del jugador
 * @param deck_list lista de cartas del mazo
 * @param hand_list lista de cartas en la mano
 */
abstract class AbstractJugador(override val name: String,
                               var gems: Int,
                               var decknum: Int,
                               var handnum: Int,
                               var deck_list: DeckClass,
                               var hand_list: ListBuffer[Carta])
  extends Jugador {

  override def isValidName(): Boolean = {
    if (name.length > 3 && name.length < 20) true
    else false
  }

  override def isValidGems(): Boolean = {
    if (gems > 0 && gems <= 2) true
    else false
  }
  
  /** del_gems es el metodo para borrar gemas de un jugador, borrandolas de a uno*/
  override def del_gems(): Unit = {
    if (gems > 0) {
      gems -= 1
    }
  }

  /** prim_toma es la asignacion de las primeras 10 cartas por partida */
  override def first_take(): Unit = {
    if (decknum > 0) {
      decknum -= 10
      handnum += 10
      for (i <- 1 to 10) { hand_list = hand_list :+ deck_list.draw_card() }
    }
  }

  /** Metodo auxiliar para sacar cartas de una mano en juego */
  override def del_hand(cards_take: Int): Unit = {
    handnum -= cards_take
    for (i <- 1 to cards_take) { hand_list = hand_list.drop(1) }
  }

  /** tomar_cartas_mazo permite al jugador sacar un numero determinado de cartas y anadirlas a su mano */
  override def take_cards_deck(): Unit = {
    // si hay 1 o mas cartas en el mazo y a lo mas 7 cartas en la mano, se toman 3 cartas del mazo
    if (handnum <= 7 && decknum > 0) {
      decknum -= 3
      handnum += 3
      for (i <- 1 to 3) { hand_list = hand_list :+ deck_list.draw_card() }
    // si hay mas de 7 cartas en la mano, se rellena con lo que reste para llegar a 10
    } else if (handnum > 7 && decknum > 0) {
      val leftover: Int = 10 - handnum
      decknum -= leftover
      handnum += leftover
      for (i <- 1 to leftover) { hand_list = hand_list :+ deck_list.draw_card() }
    }
  }
}
