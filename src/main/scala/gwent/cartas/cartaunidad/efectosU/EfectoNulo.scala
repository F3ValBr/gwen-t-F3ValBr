package cl.uchile.dcc
package gwent.cartas.cartaunidad.efectosU
import gwent.cartas.CartaUnidad

class EfectoNulo extends Efecto {
  override def apply(self: CartaUnidad, target: CartaUnidad): Unit = {
    // No hace nada
  }
}
