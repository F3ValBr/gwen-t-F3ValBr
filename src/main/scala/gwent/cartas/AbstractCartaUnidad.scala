package cl.uchile.dcc
package gwent.cartas

abstract class AbstractCartaUnidad(override val _name: String,
                                   var _strength: Int,
                                   override val _ability: Option[String])
  extends CartaUnidad {

  val rm = "Refuerzo Moral"
  val ve = "Vinculo Estrecho"

  def pow_strength(other: CartaUnidad): Unit = {
    if (_ability.isEmpty) {
      other._strength
    } else if (_ability.get == rm) {
      other._strength += 1
    } else if (_ability.get == ve) {
      other._strength *= 2
    }
  }

}
