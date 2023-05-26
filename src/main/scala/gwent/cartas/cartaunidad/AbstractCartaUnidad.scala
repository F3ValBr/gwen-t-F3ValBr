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

  /** Un metodo validCartaUnidad que permite saber si una carta de unidad es valida o no
   * 
   * @return Un booleano que indica si la carta de unidad es valida o no
   */
  override def validCartaUnidad(): Boolean = {
    // una carta de unidad es valida si su fuerza es mayor a 0 y menor a 11
    // y si su nombre no es vacio
    _strength > 0 && _strength <= 15 && _name != ""
  } 

  /** Un metodo que permite modificar la fuerza de una carta de unidad
   * 
   * Modifica la fuerza de una carta de unidad, con la condiciones que se detallan en el metodo
   * @param other Una carta de unidad que se desea modificar
   */
  override def power_modder(card_modifier: CartaUnidad, card_modified: CartaUnidad): Unit = {
    if (card_modifier._ability.get == rm) {
      card_modified._strength += 1

      // si la habilidad de la carta es Vinculo Estrecho y ademas la carta que modifica tiene el
      // mismo nombre que la carta a modificar, tanto a la carta propia como a la modificada se le duplica su fuerza
    } else if (card_modifier._ability.get == ve && card_modified._name == card_modifier._name) {
      card_modified._strength *= 2
      card_modifier._strength *= 2
    }
  }

  /*
  override def pow_strength(other: CartaUnidad): Unit = {
    // solo puede modificar a una carta de unidad cuya clasificacion concuerde con la de
    // esta misma carta, ademas de verificar que la carta tenga una habilidad definida
    if (other.getClass.getSimpleName == this.getClass.getSimpleName && this._ability.isDefined) {

      // si la habilidad de la carta es esfuerzo moral, la fuerza de la otra carta suma 1
      if (this._ability.get == rm) {
        other._strength += 1

        // si la habilidad de la carta es Vinculo Estrecho y ademas la carta que modifica tiene el
        // mismo nombre que la carta a modificar, tanto a la carta propia como a la modificada se le duplica su fuerza
      } else if (this._ability.get == ve && this._name == other._name) {
        this._strength *= 2
        other._strength *= 2
      }
    }
  }*/
}
