package cl.uchile.dcc
package gwent.cartas.cartaunidad

import gwent.cartas.CartaUnidad

abstract class AbstractCartaUnidad(override val _name: String,
                                   var _strength: Int,
                                   override val _ability: Option[String])
  extends CartaUnidad {

  val rm = "Refuerzo Moral"
  val ve = "Vinculo Estrecho"

  val carddis = "CartaDistancia"
  val cardcac = "CartaCuerpoACuerpo"
  val cardase = "CartaAsedio"

}
