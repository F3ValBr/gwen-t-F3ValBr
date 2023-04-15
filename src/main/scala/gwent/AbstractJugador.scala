package cl.uchile.dcc
package gwent

abstract class AbstractJugador(override val name: String,
                               var gems: Int,
                               var deck: Int,
                               var hand: Int)
  extends Jugador
