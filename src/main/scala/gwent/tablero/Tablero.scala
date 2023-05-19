package cl.uchile.dcc
package gwent.tablero

import gwent.cartas.{Carta, CartaClima, CartaUnidad}

import cl.uchile.dcc.gwent.cartas.cartaunidad.*
import cl.uchile.dcc.gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}

trait Tablero {

  //def add_card_clima(cartac:CartaClima): Unit
  //def sum_total_zona(list_cards_on:List[Carta]): Unit
}
trait ZonaCartasCombate extends Tablero {
  var cartas_zona_in: List[CartaUnidad]
  //def add_card(zona: ZonaCartasCombate, carta: CartaUnidad): Unit

  def add_card_distancia(zonaDis: ZonaDistancia, card: CartaDistancia): Unit

  def add_card_cuerpo_a_cuerpo(zonaCAC: ZonaCuerpoACuerpo, card: CartaCuerpoACuerpo): Unit

  def add_card_asedio(zonaAse: ZonaAsedio, card: CartaAsedio): Unit
}

trait ZonaCartasClima extends Tablero {
  var cartas_clima_in: List[CartaClima]

}
