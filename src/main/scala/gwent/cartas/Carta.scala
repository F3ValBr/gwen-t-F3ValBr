package cl.uchile.dcc
package gwent.cartas

import gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}
import gwent.tablero.ZonaCartasCombate
import gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}

import gwent.cartas.cartaclima.{CartaClimaDespejado, CartaEscarchaMordiente, CartaLluviaTorrencial, CartaNieblaImpenetrable}

import javax.print.attribute.standard.MediaSize.Other

/** Un trait que representa una Carta, este es el supertrait de las cartas
 *
 * Una carta tiene un parametro que lo define a modo general
 * @constructor Crea una carta con un nombre definido
 * @param _name nombre de una carta
 *
 * @author Felipe Valdebenito Bravo
 * @version 1.0
 * @since 1.0
 */
trait Carta {
  // nombre de una carta
  val _name: String
}

/** Un trait donde una carta tiene una clasificacion CartaUnidad
 *
 * @constructor CartaUnidad, ademas de tener un nombre, tiene un valor de fuerza
 *              en nro entero y opcionalmente puede tener una habilidad o no.
 *              Tiene un metodo donde una carta aumenta la fuerza de otra CartaUnidad
 * @param _strength valor de fuerza de una carta de unidad
 * @param _current_strength valor actual de la fuerza de una carta en el juego
 * @param _ability habilidad que puede o no tener una carta de unidad
 */
trait CartaUnidad extends Carta {
  // valor de fuerza de una carta de unidad
  val _strength: Int
  // valor actual de la fuerza de una carta en el juego
  var _current_strength: Int
  // habilidad que puede o no tener una carta de unidad
  val _ability: Option[String]
  // pow_strength modifica el valor de fuerza de otra carta de unidad
  def pow_strength_of(other: CartaUnidad): Unit
  // validCartaUnidad verifica si una carta cumple con ciertos parametros de CartaUnidad
  def validCartaUnidad(): Boolean

  def gmod_pow_strength_asedio(other: CartaAsedio /*other: CartaUnidad*/): Unit

  def gmod_pow_strength_distancia(other: CartaDistancia /*other: CartaUnidad*/): Unit

  def gmod_pow_strength_cuerpoacuerpo(other: CartaCuerpoACuerpo /*other: CartaUnidad*/): Unit

  protected def power_modder(card_modifier: CartaUnidad, card_modified: CartaUnidad): Unit

  // add_card_to agrega la carta a la zona del tablero correspondiente
  def add_card_to(tablero_zona: ZonaCartasCombate): Unit

  def get_mod_strength_em(other: CartaEscarchaMordiente): Unit

  def get_mod_strength_lt(other: CartaLluviaTorrencial): Unit

  def get_mod_strength_ci(other: CartaNieblaImpenetrable): Unit

  def get_mod_strength_cd(other: CartaClimaDespejado): Unit
}

/** Un trait donde una carta tiene una clasificacion CartaClima
 *
 * @constructor CartaClima, el cual hereda los atributos de una carta, e incluye
 *              un metodo que cambia a 1 el valor de fuerza de una carta de unidad
 */
trait CartaClima extends Carta {
  // mod_strength modifica el valor de fuerza de una carta de unidad
  def mod_strength(other: CartaUnidad): Unit
}