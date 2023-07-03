package cl.uchile.dcc
package gwent.cartas.cartaunidad.efectosU
import gwent.cartas.CartaUnidad

/** Representa el efecto VinculoEstrecho que duplica la fuerza de la carta
 * que lo posee y la carta objetivo si es que son la misma carta.
 * 
 * @constructor crea un efecto VinculoEstrecho aplicable a una carta de unidad.
 */
class VinculoEstrecho extends Efecto {

  // Documentacion en el trait Efecto
  override def apply(self: CartaUnidad, target: CartaUnidad): Unit = {
    if (self.getname() == target.getname()) {
      self.strength_x_times(2)
      target.strength_x_times(2)
    }
  }
}
