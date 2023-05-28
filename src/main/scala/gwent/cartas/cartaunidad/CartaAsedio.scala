package cl.uchile.dcc
package gwent.cartas.cartaunidad

import gwent.cartas.CartaUnidad
import gwent.tablero.ZonaCartasCombate
import gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}
import gwent.Exceptions.InvalidTypeModStrengthException

import gwent.cartas.cartaclima.{CartaEscarchaMordiente, CartaLluviaTorrencial, CartaNieblaImpenetrable}

import java.util.Objects

/** Una clase CartaAsedio que extiende a AbstractCartaUnidad
 *
 * @constructor CartaAsedio genera una carta de unidad con los atributos de nombre y fuerza,
 *              con la opcion de incluir la habilidad que, en caso de no incluirse, se considera como None
 * @param _name     Nombre de una carta de unidad
 * @param _strength Valor de fuerza de dicha carta
 * @param _ability  Habilidad que puede o no tener la carta de unidad
 * @param _current_strength Valor de fuerza actual de la carta
 */
class CartaAsedio(_name: String,
                  _strength: Int,
                  _ability: Option[String])
  extends AbstractCartaUnidad(_name, _strength, _ability) with Equals {

  /** Un constructor auxiliar que define la clase en caso de no darse el parametro de habilidad
   *
   * @constructor auxiliar, define como None la habilidad en caso de no ser dada
   * @param _name     Nombre de una carta de unidad
   * @param _strength Valor de fuerza de dicha carta
   */
  def this(_name: String, _strength: Int) = {
    this(_name, _strength, None)
  }

  //#######################################################################

  _current_strength = _strength

  override def pow_strength_of(other: CartaUnidad): Unit = {
    if (this._ability.isDefined) {
      other.gmod_pow_strength_asedio(this)
    }
  }

  override def gmod_pow_strength_cuerpoacuerpo(other: CartaCuerpoACuerpo): Unit = {
    throw new InvalidTypeModStrengthException("Fuerza de Carta Asedio no puede ser modificada por de Carta Cuerpo a Cuerpo")
  }

  override def gmod_pow_strength_distancia(other: CartaDistancia): Unit = {
    throw new InvalidTypeModStrengthException("Fuerza de Carta Distancia no puede ser modificada por de Carta Cuerpo a Cuerpo")
  }

  override def gmod_pow_strength_asedio(other: CartaAsedio): Unit = {
    power_modder(other, this)
  }
  
  override def add_card_to(tablero_zona: ZonaCartasCombate): Unit = {
    tablero_zona.add_card_asedio(this)
  }

  override def get_mod_strength_em(other: CartaEscarchaMordiente): Unit = {
    throw new InvalidTypeModStrengthException("Carta Asedio no puede ser afectada por Carta Escarcha Mordiente")
  }

  override def get_mod_strength_lt(other: CartaLluviaTorrencial): Unit = {
    this._current_strength = 1
  }

  override def get_mod_strength_ci(other: CartaNieblaImpenetrable): Unit = {
    throw new InvalidTypeModStrengthException("Carta Aseido no puede ser afectada por Carta Niebla Impenetrable")
  }

  //#######################################################################

  /// Documentacion heredada desde [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaAsedio]

  /// Documentacion heredada desde [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaAsedio]
      _name == other._name
    } else {
      false
    }
  }

  /// Documentacion heredada desde [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[CartaAsedio], _name)
  }
}
