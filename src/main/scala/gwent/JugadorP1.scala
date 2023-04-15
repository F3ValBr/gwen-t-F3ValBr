package cl.uchile.dcc
package gwent

import java.util.Objects

class JugadorP1(name: String,
                gems: Int = 2,
                deck: Int = 25,
                hand: Int = 0)
  extends AbstractJugador(name,gems,deck,hand) with Equals {
  /** quitar_gema se encarga de descontar gemas de un jugador */
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
      val resto: Int = 10 - hand
      deck -= resto
      hand += resto
    }
  }

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

