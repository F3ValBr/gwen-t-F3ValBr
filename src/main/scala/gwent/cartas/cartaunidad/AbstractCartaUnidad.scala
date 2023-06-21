package cl.uchile.dcc
package gwent.cartas.cartaunidad

import gwent.cartas.CartaUnidad
import gwent.cartas.cartaclima.CartaClimaDespejado

import cl.uchile.dcc.gwent.cartas.cartaunidad.efectosU.Efecto

/** Una clase abstracta que genera a las cartas de unidad
 *
 * @constructor Crea una nueva Carta de Unidad con un nombre, valor de fuerza y habilidad dadas
 * @param _name Nombre de una carta de unidad
 * @param _strength Valor de fuerza de dicha carta
 * @param _ability Habilidad que puede o no tener la carta de unidad
 */

abstract class AbstractCartaUnidad(private val _name: String,
                                   private val _strength: Int,
                                   val _ability: Efecto)
                                   //private val _ability: Option[String])
  extends CartaUnidad {

  // Valores privados de la clase
  private var _current_strength: Int = _strength

  // Valores visibles desde fuera de la clase
  var curr_strength: Int = _current_strength
  var ability: String = _ability.getClass.getSimpleName
  var name: String = _name

  // los siguientes valores son para simplificar la evaluacion de algunos metodos en cada carta
  val rm = "Refuerzo Moral"
  val ve = "Vinculo Estrecho"

  val carddis = "CartaDistancia"
  val cardcac = "CartaCuerpoACuerpo"
  val cardase = "CartaAsedio"

  override def getname(): String = {
    name = _name
    name
  }

  override def getcurrentstrength(): Int = {
    curr_strength = _current_strength
    curr_strength
  }

  override def getability(): String = {
    ability
  }

  // Documentacion heredada desde [[CartaUnidad]]
  override def validCartaUnidad(): Boolean = {
    // una carta de unidad es valida si su fuerza es mayor a 0 y menor a 11
    // y si su nombre no es vacio
    _strength > 0 && _strength <= 15 && _name != ""
  }

  /**
  def apply(self: CartaUnidad, target: CartaUnidad): Unit = {
    _ability(self, target)
  }*/

  override def power_modder(card_modifier: CartaUnidad, card_modified: CartaUnidad): Unit = {
    _ability(card_modified, card_modifier)
  }
  /**
  // Documentacion heredada desde [[CartaUnidad]]
  override def power_modder(card_modifier: CartaUnidad, card_modified: CartaUnidad): Unit = {
    // si la habilidad de la carta es esfuerzo moral, la fuerza de la otra carta suma 1
    if (card_modifier.getability() == rm) {
      //card_modified._current_strength += 1
      card_modified.sum_to_strength(1)
    }
    // si la habilidad de la carta es Vinculo Estrecho y ademas la carta que modifica tiene el
    // mismo nombre que la carta a modificar, tanto a la carta propia como a la modificada se le duplica su fuerza
    else if (card_modifier.getability() == ve && card_modified.getname() == card_modifier.getname()) {
      //card_modified._current_strength *= 2
      card_modified.strength_x_times(2)
      //card_modifier._current_strength *= 2
      card_modifier.strength_x_times(2)
    }
  }
  */

  // Documentacion heredada desde [[CartaUnidad]]
  override def get_mod_strength_cd(other: CartaClimaDespejado): Unit = {
    this._current_strength = this._strength
  }

  override def give_back_strength(): Unit = {
    this._current_strength = this._strength
  }

  override def sum_to_strength(num: Int): Unit = {
    this._current_strength += num
  }

  override def strength_x_times(x: Int): Unit = {
    this._current_strength *= x
  }

  override def set_strength_to_num(num: Int): Unit = {
    this._current_strength = num
  }
}
