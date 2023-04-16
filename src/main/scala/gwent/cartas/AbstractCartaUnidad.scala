package cl.uchile.dcc
package gwent.cartas

abstract class AbstractCartaUnidad(override val _name: String,
                                   var _strength: Int,
                                   override val _ability: Option[String])
  extends CartaUnidad {

  def pow_strength(other: CartaUnidad): Unit = {
    if (_ability.contains(Some("Refuerzo Moral"))) {
      other._strength += 1
    } else if (_ability.contains(Some("Vinculo Estrecho"))) {
      other._strength *= 2
    }
  }

}
