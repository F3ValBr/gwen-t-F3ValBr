package cl.uchile.dcc
package gwent.cartas.cartaunidad

import gwent.cartas.CartaUnidad
import gwent.Exceptions.InvalidTypeModStrengthException
import gwent.tablero.ZonaCartasCombate
import gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}
import gwent.cartas.cartaclima.{CartaEscarchaMordiente, CartaLluviaTorrencial, CartaNieblaImpenetrable}

import cl.uchile.dcc.gwent.cartas.cartaunidad.efectosU.{Efecto, EfectoNulo}

import java.util.Objects

/** Una clase CartaCuerpoACuerpo que extiende a AbstractCartaUnidad
 *
 * @constructor CartaCuerpoACuerpo genera una carta de unidad con los atributos de nombre y fuerza,
 *              con la opcion de incluir la habilidad que, en caso de no incluirse, se considera como None
 * @param _name     Nombre de una carta de unidad
 * @param _strength Valor de fuerza de dicha carta
 * @param _ability  Habilidad que puede o no tener la carta de unidad
 * @param _current_strength Valor de fuerza actual de la carta
 */
class CartaCuerpoACuerpo(_name: String,
                         _strength: Int,
                         _ability: Efecto)
  extends AbstractCartaUnidad(_name, _strength, _ability) with Equals {

  /** Un constructor auxiliar que define la clase en caso de no darse el parametro de habilidad
   *
   * @constructor auxiliar, define como None la habilidad en caso de no ser dada
   * @param _name     Nombre de una carta de unidad
   * @param _strength Valor de fuerza de dicha carta
   */
  def this(_name: String, _strength: Int) = {
    this(_name, _strength, EfectoNulo())
  }

  // se asigna la habilidad protegida de la carta a un getter
  ability = _ability

  // Documentacion heredada desde [[CartaUnidad]]
  // se procede a añadir la carta via el metodo add_card_cuerpo_a_cuerpo
  override def pow_strength_of(other: CartaUnidad): Unit = {
    other.gmod_pow_strength_cuerpoacuerpo(this)
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // no se puede modificar la fuerza de una carta cuerpo a cuerpo con una carta de asedio
  override def gmod_pow_strength_asedio(other: CartaAsedio): Unit = {
    throw new InvalidTypeModStrengthException("Fuerza de Carta Cuerpo a Cuerpo no puede ser modificada por Carta de Asedio")
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // no se puede modificar la fuerza de una carta cuerpo a cuerpo con una carta de distancia
  override def gmod_pow_strength_distancia(other: CartaDistancia): Unit = {
    throw new InvalidTypeModStrengthException("Fuerza de Carta Cuerpo a Cuerpo no puede ser modificada por Carta de Distancia")
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // se procede la modificacion via Efecto
  override def gmod_pow_strength_cuerpoacuerpo(other: CartaCuerpoACuerpo): Unit = {
    other.ability(other, this)
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // Se procede a modificar la fuerza de la carta cuerpo a cuerpo
  override def get_mod_strength_em(other: CartaEscarchaMordiente): Unit = {
    this.set_strength_to_num(1)
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // No se puede modificar la fuerza de una carta cuerpo a cuerpo con una carta de lluvia torrencial
  override def get_mod_strength_lt(other: CartaLluviaTorrencial): Unit = {
    throw new InvalidTypeModStrengthException("Carta Cuerpo a Cuerpo no puede ser afectada por Carta Lluvia Torrencial")
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // No se puede modificar la fuerza de una carta cuerpo a cuerpo con una carta de niebla impenetrable
  override def get_mod_strength_ci(other: CartaNieblaImpenetrable): Unit = {
    throw new InvalidTypeModStrengthException("Carta Cuerpo a Cuerpo no puede ser afectada por Carta Niebla Impenetrable")
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // se procede a añadir la carta via el metodo add_card_cuerpo_a_cuerpo
  override def add_card_to(tablero_zona: ZonaCartasCombate): Unit = {
    tablero_zona.add_card_cuerpo_a_cuerpo(this)
  }

  //#######################################################################

  /// Documentacion heredada desde [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaCuerpoACuerpo]

  /// Documentacion heredada desde [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaCuerpoACuerpo]
      this.getname() == other.getname()
      //_name == other._name
    } else {
      false
    }
  }

  /// Documentacion heredada desde [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[CartaCuerpoACuerpo], getname())//_name)
  }

}
