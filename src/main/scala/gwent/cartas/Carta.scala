package cl.uchile.dcc
package gwent.cartas

import javax.print.attribute.standard.MediaSize.Other

trait Carta {
  val _name: String
  val _ability: Option[String]
}
trait CartaUnidad extends Carta {
  var _strength: Int
  def pow_strength(other: CartaUnidad): Unit
}

trait CartaClima extends Carta {
  def del_strength(other: CartaUnidad): Unit
}
