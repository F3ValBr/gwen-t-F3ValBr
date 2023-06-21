package cl.uchile.dcc
package gwent.cartas.cartaunidad.efectosU

import gwent.cartas.{Carta, CartaUnidad}

trait Efecto {
  def apply(self: CartaUnidad, target: CartaUnidad): Unit
}
