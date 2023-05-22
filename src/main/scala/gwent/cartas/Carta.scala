package cl.uchile.dcc
package gwent.cartas

import cl.uchile.dcc.gwent.tablero.ZonaCartasCombate
import cl.uchile.dcc.gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}

import javax.print.attribute.standard.MediaSize.Other

/** Un trait que representa una Carta, este es el supertrait de las cartas
 *
 * Una carta tiene un parametro que lo define a modo general
 * @constructor Crea una carta con un nombre definido
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
 */
trait CartaUnidad extends Carta {
  // valor de fuerza de una carta de unidad
  var _strength: Int
  // habilidad que puede o no tener una carta de unidad
  val _ability: Option[String]
  // pow_strength modifica el valor de fuerza de otra carta de unidad
  def pow_strength(other: CartaUnidad): Unit
  // validCartaUnidad verifica si una carta cumple con ciertos parametros de CartaUnidad
  def validCartaUnidad(): Boolean
  // add_card_to agrega la carta a la zona del tablero correspondiente
  def add_card_to(tablero_zona: ZonaCartasCombate): Unit
  
  /*
  def add_card_to_caczone(zonaCAC: ZonaCuerpoACuerpo): Unit
  def add_card_to_asezone(zonaAse: ZonaAsedio): Unit
  def add_card_to_diszone(zonaDis: ZonaDistancia): Unit
  */
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