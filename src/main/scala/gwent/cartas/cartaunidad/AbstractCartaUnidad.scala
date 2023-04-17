package cl.uchile.dcc
package gwent.cartas.cartaunidad

import gwent.cartas.CartaUnidad

/** Una clase abstracta que genera a las cartas de unidad
 *
 * @constructor Crea una nueva Carta de Unidad con un nombre, valor de fuerza y habilidad dadas
 * @param _name Nombre de una carta de unidad
 * @param _strength Valor de fuerza de dicha carta
 * @param _ability Habilidad que puede o no tener la carta de unidad
 */

abstract class AbstractCartaUnidad(override val _name: String,
                                   var _strength: Int,
                                   override val _ability: Option[String])
  extends CartaUnidad {

  // los siguientes valores son para simplificar la evaluacion de algunos metodos en cada carta
  val rm = "Refuerzo Moral"
  val ve = "Vinculo Estrecho"

  val carddis = "CartaDistancia"
  val cardcac = "CartaCuerpoACuerpo"
  val cardase = "CartaAsedio"
}
