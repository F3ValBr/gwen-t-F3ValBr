package cl.uchile.dcc
package gwent.tablero

import gwent.cartas.{Carta, CartaClima, CartaUnidad}
import gwent.cartas.cartaunidad.*
import gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}

import scala.collection.mutable.ListBuffer

/** Tablero de juego de Gwent
 *
 * @constructor crea un tablero de juego de Gwent
 */
trait Tablero {
  def clean_zone(): Unit
}
/** ZonaCartasCombate es una zona del tablero de juego de Gwent
 * que contiene cartas de combate
 *
 */
trait ZonaCartasCombate extends Tablero {

  var cartas_zona_in: ListBuffer[CartaUnidad]

  def counter_strength(/*group_of_cards: List[CartaUnidad]*/): Int

  def add_card(carta: CartaUnidad): Unit

  def add_card_asedio(card: CartaUnidad): Unit

  def add_card_cuerpo_a_cuerpo(card: CartaUnidad): Unit

  def add_card_distancia(card: CartaUnidad): Unit

  def card_adder(list_of_cards: ListBuffer[CartaUnidad], card: CartaUnidad): Unit
}

trait ZonaCartasClima extends Tablero {

  var cartas_clima_in: CartaClima

  def replace_clima(carta: CartaClima): Unit
}
