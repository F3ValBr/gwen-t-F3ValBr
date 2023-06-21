package cl.uchile.dcc
package gwent.cartas

import gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}
import gwent.tablero.ZonaCartasCombate
import gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}
import gwent.cartas.cartaclima.{CartaClimaDespejado, CartaEscarchaMordiente, CartaLluviaTorrencial, CartaNieblaImpenetrable}

import cl.uchile.dcc.gwent.cartas.cartaunidad.efectosU.Efecto

import javax.print.attribute.standard.MediaSize.Other

/** Un trait que representa una Carta, este es el supertrait de las cartas
 *
 * Una carta tiene un parametro que lo define a modo general
 * @constructor Crea una carta con un nombre definido
 * @param name nombre de una carta
 *
 * @author Felipe Valdebenito Bravo
 * @version 1.0
 * @since 1.0
 */
trait Carta {
  // nombre de una carta
  //protected val _name: String
  var name: String

  /** getname devuelve el nombre de una carta
   *
   * @return nombre de una carta
   */
  def getname(): String
}

/** Un trait donde una carta tiene una clasificacion CartaUnidad
 *
 * @constructor CartaUnidad, ademas de tener un nombre, tiene un valor de fuerza
 *              en nro entero y opcionalmente puede tener una habilidad o no.
 *              Tiene un metodo donde una carta aumenta la fuerza de otra CartaUnidad
 * @param current_strength valor actual de la fuerza de una carta en el juego
 * @param ability habilidad que puede o no tener una carta de unidad
 */
trait CartaUnidad extends Carta {
  // valor de fuerza de una carta de unidad en el juego
  var curr_strength: Int

  // habilidad que puede o no tener una carta de unidad
  var ability: Efecto

  // Definicion de getters
  /** getstrength devuelve el valor de fuerza de una carta de unidad
   *
   * @return valor de fuerza de una carta de unidad
   */
  def getcurrentstrength(): Int

  /** getability devuelve la habilidad de una carta de unidad
   *
   * @return habilidad de una carta de unidad
   */
  def getability(): String

  /** pow_strength_of aumenta el valor de fuerza de una carta de unidad
   *
   * @param other carta de unidad que aumenta su valor de fuerza
   */
  def pow_strength_of(other: CartaUnidad): Unit

  /** validCartaUnidad verifica si una carta cumple con ciertos parametros de CartaUnidad
   *
   * @return true si la carta cumple con los parametros de CartaUnidad, false en caso contrario
   */
  def validCartaUnidad(): Boolean

  /** gmod_pow_strength_asedio modifica el valor de fuerza de una carta de asedio
   *
   * @param other carta de asedio que aumenta su valor de fuerza
   */
  def gmod_pow_strength_asedio(other: CartaAsedio): Unit

  /** gmod_pow_strength_distancia modifica el valor de fuerza de una carta de distancia
   *
   * @param other carta de distancia que aumenta su valor de fuerza
   */
  def gmod_pow_strength_distancia(other: CartaDistancia): Unit

  /** gmod_pow_strength_cuerpoacuerpo modifica el valor de fuerza de una carta de cuerpo a cuerpo
   *
   * @param other carta de cuerpo a cuerpo que aumenta su valor de fuerza
   */
  def gmod_pow_strength_cuerpoacuerpo(other: CartaCuerpoACuerpo): Unit

  /** Un metodo que permite modificar la fuerza de otra carta de unidad, dada una carta que tenga ability
   *
   * Modifica la fuerza de una carta de unidad, con la condiciones que se detallan en el metodo
   *
   * @param card_modifier Una carta de unidad que se encargara de modificar la fuerza de la carta de unidad
   * @param card_modified Una carta de unidad que sera modificada por la carta de unidad anterior
   */
  protected def power_modder(card_modifier: CartaUnidad, card_modified: CartaUnidad): Unit

  /** add_card_to agrega la carta a la zona del tablero correspondiente
   *
   * @param tablero_zona zona del tablero donde se agrega la carta
   */
  def add_card_to(tablero_zona: ZonaCartasCombate): Unit

  /** get_mod_strength_em modifica el valor de fuerza de una carta de unidad, dada una carta de clima EscarchaMordiente
   *
   * @param other carta de clima EscarchaMordiente
   */
  def get_mod_strength_em(other: CartaEscarchaMordiente): Unit

  /** get_mod_strength_lt modifica el valor de fuerza de una carta de unidad, dada una carta de clima LluviaTorrencial
   *
   * @param other carta de clima LluviaTorrencial
   */
  def get_mod_strength_lt(other: CartaLluviaTorrencial): Unit

  /** get_mod_strength_ci modifica el valor de fuerza de una carta de unidad, dada una carta de clima NieblaImpenetrable
   *
   * @param other carta de clima NieblaImpenetrable
   */
  def get_mod_strength_ci(other: CartaNieblaImpenetrable): Unit

  /** get_mod_strength_cd modifica el valor de fuerza de una carta de unidad, dada una carta de Clima Despejado.
   * Este metodo devuelve el valor original de fuerza de la carta de unidad
   *
   * @param other carta de clima Despejado
   */
  def get_mod_strength_cd(other: CartaClimaDespejado): Unit

  // Definicion de setters
  /** setcurrentstrength modifica el valor de fuerza de una carta de unidad
   */
  def give_back_strength(): Unit

  /** setcurrentstrength modifica el valor de fuerza de una carta de unidad
   *
   * @param num valor a sumar al valor de fuerza de una carta de unidad
   */
  def sum_to_strength(num: Int): Unit

  /** setcurrentstrength modifica el valor de fuerza de una carta de unidad
   *
   * @param x valor a multiplicar al valor de fuerza de una carta de unidad
   */
  def strength_x_times(x: Int): Unit

  /** setcurrentstrength modifica el valor de fuerza de una carta de unidad
   *
   * @param num valor a asignar al valor de fuerza de una carta de unidad
   */
  def set_strength_to_num(num: Int): Unit
}

/** Un trait donde una carta tiene una clasificacion CartaClima
 *
 * @constructor CartaClima, el cual hereda los atributos de una carta, e incluye
 *              un metodo que cambia a 1 el valor de fuerza de una carta de unidad
 */
trait CartaClima extends Carta {
  /** mod_strength modifica el valor de fuerza de una carta de unidad
   *
   * @param other carta de unidad que tiene su valor de fuerza modificado
   */
  def mod_strength(other: CartaUnidad): Unit
}