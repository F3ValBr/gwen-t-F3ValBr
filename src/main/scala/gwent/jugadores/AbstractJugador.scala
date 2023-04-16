package cl.uchile.dcc
package gwent.jugadores

abstract class AbstractJugador(override val name: String,
                               var gems: Int,
                               var deck: Int,
                               var hand: Int)
  extends Jugador {
  override def del_gems(): Unit = {
    if (gems > 0) {
      gems -= 1
    }
  }

  /** prim_toma es la asignacion de las primeras 10 cartas por partida */
  override def first_take(): Unit = {
    if (deck > 0) {
      deck -= 10
      deck += 10
    }
  }

  /** Funcion auxiliar para sacar cartas de una mano en juego */
  override def del_hand(cards_take: Int): Unit = {
    hand -= cards_take
  }

  /** tomar_cartas_mazo permite al jugador sacar un numero determinado de cartas y anadirlas a su mano */
  override def take_cards_deck(): Unit = {
    if (deck > 0 && hand <= 7) {
      deck -= 3
      hand += 3
    } else if (deck > 0) { //mano > 7
      val leftover: Int = 10 - hand
      deck -= leftover
      hand += leftover
    }
  }
}
