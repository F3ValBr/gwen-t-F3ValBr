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
  protected var cartas_zona_in: ListBuffer[CartaUnidad]

  // Lista de cartas de combate en la zona
  var cards_in: ListBuffer[CartaUnidad]

  /** viewZone muestra la zona de cartas respectiva
   *
   * @return lista de cartas de la zona en cuestion
   */
  def viewZone(): ListBuffer[CartaUnidad]

  /** counter_strength calcula la fuerza total de la zona
   * @return fuerza total de la zona
   */
  protected def counter_strength(): Int

  /** add_card agrega una carta a la zona
   * @param carta carta a agregar
   */
  protected def add_card(carta: CartaUnidad): Unit

  /** add_card_asedio agrega una carta a la zona de asedio
   * @param card carta a agregar
   */
  def add_card_asedio(card: CartaAsedio): Unit

  /** add_card_cuerpo_a_cuerpo agrega una carta a la zona de cuerpo a cuerpo
   * @param card carta a agregar
   */
  def add_card_cuerpo_a_cuerpo(card: CartaCuerpoACuerpo): Unit

  /** add_card_distancia agrega una carta a la zona de distancia
   * @param card carta a agregar
   */
  def add_card_distancia(card: CartaDistancia): Unit

  /** card_adder es el metodo auxiliar para añadir una carta a una lista dada
   * @param list_of_cards lista de cartas a la que se le agregara la carta
   * @param card carta a agregar
   */
  protected def card_adder(list_of_cards: ListBuffer[CartaUnidad], card: CartaUnidad): Unit

  /**
   * mod_cards es el metodo que modifica el valor de fuerza de cartas de unidad, dependiendo del
   * efecto que tenga la ultima carta recibida
   * @param last_card carta que hara el efecto sobre las demas
   */
  def mod_cards(last_card: CartaUnidad): Unit

  /**
   * mod_n_add_card mezcla la funcionalidad de modificar mediante el efecto de una carta junto con añadir esa misma
   * carta al juego. Primero la carta ejerce su efecto y luego es añadida al tablero
   * @param card_to_add Carta a añadir
   */
  def mod_n_add_card(card_to_add: CartaUnidad): Unit
}

/** ZonaCartasClima es una zona del tablero de juego de Gwent
 * que contiene cartas de clima
 *
 * @constructor crea una zona de cartas de clima
 * @param cartas_clima_in carta de clima en la zona
 */
trait ZonaCartasClima extends Tablero {

  // Carta de clima en la zona
  protected var cartas_clima_in: CartaClima

  // Carta de clima en la zona
  var card_in: CartaClima

  /** viewZone muestra la zona de cartas respectiva
   *
   * @return lista de cartas de la zona en cuestion
   */
  def viewZone(): CartaClima

  /** replace_clima reemplaza la carta de clima en la zona
   * @param carta carta de clima a reemplazar
   */
  protected def replace_clima(carta: CartaClima): Unit
}
