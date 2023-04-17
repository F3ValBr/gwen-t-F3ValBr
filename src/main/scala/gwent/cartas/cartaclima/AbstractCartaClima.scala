package cl.uchile.dcc
package gwent.cartas.cartaclima

import gwent.cartas.{CartaClima, CartaUnidad}

abstract class AbstractCartaClima(override val _name: String)
  extends CartaClima {

  private val em = "Escarcha Mordiente"
  private val ni = "Niebla Impenetrable"
  private val lt = "Lluvia Torrencial"
  private val cd = "Clima Despejado"

  override def set_to_one_strength(other: CartaUnidad): Unit = {
    other._strength = 1
  }
}
