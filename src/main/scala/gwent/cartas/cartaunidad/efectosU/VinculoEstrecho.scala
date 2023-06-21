package cl.uchile.dcc
package gwent.cartas.cartaunidad.efectosU
import gwent.cartas.CartaUnidad

class VinculoEstrecho extends Efecto {
  override def apply(self: CartaUnidad, target: CartaUnidad): Unit = {
    if (self.getname() == target.getname()) {
      //self.curr_strength *= 2
      //target.curr_strength *= 2
      self.strength_x_times(2)
      target.strength_x_times(2)
    }
  }
}
