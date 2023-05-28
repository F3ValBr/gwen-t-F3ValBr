package cl.uchile.dcc
package gwent.tablero

import gwent.cartas.{Carta, CartaClima, CartaUnidad}
import gwent.cartas.cartaunidad.*
import gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}

import scala.collection.mutable.ListBuffer

/** Tablero de juego de Gwent
 *
 * @constructor crea un tablero de juego de Gwent con las zonas de cartas de combate y clima
 *              
 * @author Felipe Valdebenito Bravo
 * @version 1.0
 * @since 1.0
 */
trait Tablero {
  
  /** clean_zone limpia la zona de cartas respectiva */
  def clean_zone(): Unit
}
/** ZonaCartasCombate es una zona del tablero de juego de Gwent
 * que contiene cartas de combate
 *
 * @constructor crea una zona de cartas de combate
 * @param cartas_zona_in lista de cartas de combate en la zona
 */
trait ZonaCartasCombate extends Tablero {
  
  // Lista de cartas de combate en la zona
  var cartas_zona_in: ListBuffer[CartaUnidad]

  /** counter_strength calcula la fuerza total de la zona
   * @return fuerza total de la zona
   */
  def counter_strength(): Int

  /** add_card agrega una carta a la zona
   * @param carta carta a agregar
   */
  def add_card(carta: CartaUnidad): Unit

  /** add_card_asedio agrega una carta a la zona de asedio
   * @param card carta a agregar
   */
  def add_card_asedio(card: CartaUnidad): Unit

  /** add_card_cuerpo_a_cuerpo agrega una carta a la zona de cuerpo a cuerpo
   * @param card carta a agregar
   */
  def add_card_cuerpo_a_cuerpo(card: CartaUnidad): Unit

  /** add_card_distancia agrega una carta a la zona de distancia
   * @param card carta a agregar
   */
  def add_card_distancia(card: CartaUnidad): Unit

  /** card_adder es el metodo auxiliar para añadir una carta a una lista dada 
   * @param list_of_cards lista de cartas a la que se le agregara la carta
   * @param card carta a agregar
   */
  def card_adder(list_of_cards: ListBuffer[CartaUnidad], card: CartaUnidad): Unit
}

/** ZonaCartasClima es una zona del tablero de juego de Gwent
 * que contiene cartas de clima
 *
 * @constructor crea una zona de cartas de clima
 * @param cartas_clima_in carta de clima en la zona
 */
trait ZonaCartasClima extends Tablero {

  // Carta de clima en la zona
  var cartas_clima_in: CartaClima

  /** replace_clima reemplaza la carta de clima en la zona
   * @param carta carta de clima a reemplazar
   */
  def replace_clima(carta: CartaClima): Unit
}
