package cl.uchile.dcc
package gwent.cartas.cartaunidad

import gwent.cartas.CartaUnidad
import gwent.Exceptions.InvalidTypeModStrengthException
import gwent.tablero.ZonaCartasCombate
import gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}
import gwent.cartas.cartaclima.{CartaEscarchaMordiente, CartaLluviaTorrencial, CartaNieblaImpenetrable}

import cl.uchile.dcc.gwent.cartas.cartaunidad.efectosU.{Efecto, EfectoNulo}

import java.util.Objects

/** Una clase CartaDistancia que extiende a AbstractCartaUnidad
 *
 * @constructor CartaDistancia genera una carta de unidad con los atributos de nombre y fuerza,
 *              con la opcion de incluir la habilidad que, en caso de no incluirse, se considera como None
 * @param _name     Nombre de una carta de unidad
 * @param _strength Valor de fuerza de dicha carta
 * @param _ability  Habilidad que puede o no tener la carta de unidad
 * @param _current_strength Valor de fuerza actual de la carta
 */
class CartaDistancia(_name: String,
                     _strength: Int,
                     _ability: Efecto)
  extends AbstractCartaUnidad(_name, _strength, _ability) with Equals {

  /** Un constructor auxiliar que define la clase en caso de no darse el parametro de habilidad
   * @constructor auxiliar, define como None la habilidad en caso de no ser dada
   * @param _name     Nombre de una carta de unidad
   * @param _strength Valor de fuerza de dicha carta
   */
  def this(_name: String, _strength: Int) = {
    this(_name, _strength, EfectoNulo())
  }

  // se asigna la fuerza actual de la carta a su fuerza base
  //_current_strength = _strength
  //curr_strength = _current_strength

  // se asigna la habilidad protegida de la carta a un getter
  ability = _ability

  // Documentacion heredada desde [[CartaUnidad]]
  // se procede a la modificacion si existe una habilidad, y se hace la modificacion via gmod_pow_strength_distancia
  override def pow_strength_of(other: CartaUnidad): Unit = {
    other.gmod_pow_strength_distancia(this)
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // no se puede modificar la fuerza de una carta de distancia con una carta de asedio
  override def gmod_pow_strength_asedio(other: CartaAsedio): Unit = {
    throw new InvalidTypeModStrengthException("Fuerza de Carta Distancia no puede ser modificada por Carta de Asedio")
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // no se puede modificar la fuerza de una carta de distancia con una carta de cuerpo a cuerpo
  override def gmod_pow_strength_cuerpoacuerpo(other: CartaCuerpoACuerpo): Unit = {
    throw new InvalidTypeModStrengthException("Fuerza de Carta Distancia no puede ser modificada por Carta de Cuerpo a Cuerpo")
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // se procede la modificacion via power_modder
  override def gmod_pow_strength_distancia(other: CartaDistancia): Unit = {
    other.ability(other, this)
    //power_modder(other, this)
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // se procede a añaadir la carta a la zona de cartas de combate de distancia
  override def add_card_to(tablero_zona: ZonaCartasCombate): Unit = {
    tablero_zona.add_card_distancia(this)
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // no se puede modificar la fuerza de una carta de distancia con una carta de clima de escarcha mordiente
  override def get_mod_strength_em(other: CartaEscarchaMordiente): Unit = {
    throw new InvalidTypeModStrengthException("Carta Distancia no puede ser afectada por Carta Escarcha Mordiente")
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // no se puede modificar la fuerza de una carta de distancia con una carta de clima de lluvia torrencial
  override def get_mod_strength_lt(other: CartaLluviaTorrencial): Unit = {
    throw new InvalidTypeModStrengthException("Carta Distancia no puede ser afectada por Carta Lluvia Torrencial")
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // se procede con la modificacion seteando en 1
  override def get_mod_strength_ci(other: CartaNieblaImpenetrable): Unit = {
    //this._current_strength = 1
    this.set_strength_to_num(1)
  }

  //#######################################################################

  /// Documentacion heredada desde [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaDistancia]

  /// Documentacion heredada desde [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaDistancia]
      this.getname() == other.getname()
      //_name == other._name
    } else {
      false
    }
  }

  /// Documentacion heredada desde [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[CartaDistancia], getname())//_name)
  }
}
