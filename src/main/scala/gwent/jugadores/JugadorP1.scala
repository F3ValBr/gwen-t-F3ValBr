package cl.uchile.dcc
package gwent.jugadores

import gwent.jugadores.AbstractJugador

import java.util.Objects

class JugadorP1(name: String,
                gems: Int = 2,
                deck: Int = 25,
                hand: Int = 0)
  extends AbstractJugador(name,gems,deck,hand) with Equals {
  /** quitar_gema se encarga de descontar gemas de un jugador */

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

