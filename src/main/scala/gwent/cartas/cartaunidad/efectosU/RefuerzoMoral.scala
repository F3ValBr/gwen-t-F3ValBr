package cl.uchile.dcc
package gwent.cartas.cartaunidad.efectosU
import gwent.cartas.CartaUnidad

/** Representa el efecto Refuerzo Moral que aumenta en 1 la fuerza de una unidad aliada
 * 
 * @constructor crea un efecto Refuerzo Moral aplicable a una carta unidad
 */
class RefuerzoMoral extends Efecto {

  // Documentacion en el trait Efecto
  override def apply(self: CartaUnidad, target: CartaUnidad): Unit = {
    target.sum_to_strength(1)
  }
}
