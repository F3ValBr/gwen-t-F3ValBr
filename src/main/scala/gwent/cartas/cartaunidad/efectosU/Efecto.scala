package cl.uchile.dcc
package gwent.cartas.cartaunidad.efectosU

import gwent.cartas.{Carta, CartaUnidad}

/**
 * Trait que representa un efecto de una carta unidad
 * @see [[gwent.cartas.cartaunidad.efectosU]]
 * 
 * @constructor crea un efecto
 * 
 * @author Felipe Valdebenito Bravo
 * @version 1.0
 * @since 1.0
 */
trait Efecto {

  /**
   * Aplica el efecto a la carta objetivo
   * @param self Carta que aplica el efecto
   * @param target Carta a la que se le aplica el efecto
   * @return Unit
   */
  def apply(self: CartaUnidad, target: CartaUnidad): Unit
}
