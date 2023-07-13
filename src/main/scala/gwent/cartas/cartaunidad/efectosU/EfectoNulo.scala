package cl.uchile.dcc
package gwent.cartas.cartaunidad.efectosU
import gwent.cartas.CartaUnidad

/** Representa un efecto que no hace nada.
 *
 * @constructor crea un efecto nulo aplicable a una carta unidad.
 */
class EfectoNulo extends Efecto {

  // Documentacion en el trait Efecto
  override def apply(self: CartaUnidad, target: CartaUnidad): Unit = {
    // No hace nada
  }
}
