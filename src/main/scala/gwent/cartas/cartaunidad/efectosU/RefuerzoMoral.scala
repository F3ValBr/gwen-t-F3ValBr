package cl.uchile.dcc
package gwent.cartas.cartaunidad.efectosU
import gwent.cartas.CartaUnidad

class RefuerzoMoral extends Efecto {
  override def apply(self: CartaUnidad, target: CartaUnidad): Unit = {
    target.sum_to_strength(1)
  }
}
