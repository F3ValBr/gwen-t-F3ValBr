package cl.uchile.dcc
package gwent.tablero
import gwent.cartas.CartaUnidad

import cl.uchile.dcc.gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}

abstract class AbstractZonaJugadorTab(var cartas_zona_in: List[CartaUnidad]) extends ZonaCartasCombate {
  override def add_card(zona: ZonaCartasCombate, carta: CartaUnidad): Unit = ???

  override def add_card_distancia(zonaDis: ZonaDistancia, card: CartaUnidad): Unit = ???

  override def add_card_cuerpo_a_cuerpo(zonaCAC: ZonaCuerpoACuerpo, card: CartaUnidad): Unit = ???

  override def add_card_asedio(zonaAse: ZonaAsedio, card: CartaUnidad): Unit = ???

}
