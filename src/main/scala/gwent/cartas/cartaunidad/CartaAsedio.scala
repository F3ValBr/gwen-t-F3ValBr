package cl.uchile.dcc
package gwent.cartas.cartaunidad

import gwent.cartas.CartaUnidad
import gwent.tablero.ZonaCartasCombate
import gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}
import gwent.Exceptions.InvalidTypeModStrengthException
import gwent.cartas.cartaclima.{CartaEscarchaMordiente, CartaLluviaTorrencial, CartaNieblaImpenetrable}

import cl.uchile.dcc.gwent.cartas.cartaunidad.efectosU.{Efecto, EfectoNulo}

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

  // se asigna la fuerza actual de la carta a su fuerza base
  //_current_strength = _strength
  //curr_strength = _current_strength


  // se asigna la habilidad protegida de la carta a un getter
  ability = _ability

  // Documentacion heredada desde [[CartaUnidad]]
  override def pow_strength_of(other: CartaUnidad): Unit = {
    // si la habilidad esta definida, se procede a modificar la fuerza de la carta
    other.gmod_pow_strength_asedio(this)
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // una carta cuerpo a cuerpo no puede modificar a una de asedio
  override def gmod_pow_strength_cuerpoacuerpo(other: CartaCuerpoACuerpo): Unit = {
    throw new InvalidTypeModStrengthException("Fuerza de Carta Asedio no puede ser modificada por Carta Cuerpo a Cuerpo")
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // una carta cuerpo a cuerpo no puede modificar a una de distancia
  override def gmod_pow_strength_distancia(other: CartaDistancia): Unit = {
    throw new InvalidTypeModStrengthException("Fuerza de Carta Distancia no puede ser modificada por Carta Cuerpo a Cuerpo")
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // se procede con la modificacion al corresponder los tipos
  override def gmod_pow_strength_asedio(other: CartaAsedio): Unit = {
    other.ability(other, this)
    //power_modder(other, this)
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // se procede a añadir la carta via el metodo add_card de la zona de asedio
  override def add_card_to(tablero_zona: ZonaCartasCombate): Unit = {
    tablero_zona.add_card_asedio(this)
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // no se puede modificar la fuerza de una carta de asedio con una carta de clima de escarcha mordiente
  override def get_mod_strength_em(other: CartaEscarchaMordiente): Unit = {
    throw new InvalidTypeModStrengthException("Carta Asedio no puede ser afectada por Carta Escarcha Mordiente")
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // se procede con la modificacion al corresponder los tipos
  override def get_mod_strength_lt(other: CartaLluviaTorrencial): Unit = {
    //this._current_strength = 1
    this.set_strength_to_num(1)
  }

  // Documentacion heredada desde [[CartaUnidad]]
  // no se puede modificar la fuerza de una carta de asedio con una carta de clima de niebla impenetrable
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
      this.getname() == other.getname()
      //_name == other._name
    } else {
      false
    }
  }

  /// Documentacion heredada desde [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[CartaAsedio], getname())//_name)
  }
}
