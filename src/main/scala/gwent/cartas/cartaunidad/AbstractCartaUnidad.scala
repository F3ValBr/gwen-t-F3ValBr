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
                                   private val _ability: Efecto)
                                   //private val _ability: Option[String])
  extends CartaUnidad {

  // Valores privados de la clase
  private var _current_strength: Int = _strength

  // Valores visibles desde fuera de la clase
  var curr_strength: Int = _current_strength
  var ability: Efecto = _ability
  var name: String = _name
  
  override def getname(): String = {
    name = _name
    name
  }

  override def getcurrentstrength(): Int = {
    curr_strength = _current_strength
    curr_strength
  }

  override def getability(): String = {
    // Aqui use getClass solo para obtener el nombre y realizar los tests correspondientes
    ability.getClass.getSimpleName
  }

  // Documentacion heredada desde [[CartaUnidad]]
  override def validCartaUnidad(): Boolean = {
    // una carta de unidad es valida si su fuerza es mayor a 0 y menor a 11
    // y si su nombre no es vacio
    _strength > 0 && _strength <= 15 && _name != ""
  }

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
