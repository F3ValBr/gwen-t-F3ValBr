package cl.uchile.dcc
package gwent.cartas

import javax.print.attribute.standard.MediaSize.Other

trait Carta {
  val _name: String
}
trait CartaUnidad extends Carta {
  var _strength: Int
  val _ability: Option[String]
  def pow_strength(other: CartaUnidad): Unit
}

trait CartaClima extends Carta {
  val _ability: String
  def del_strength(other: CartaUnidad): Unit
}
