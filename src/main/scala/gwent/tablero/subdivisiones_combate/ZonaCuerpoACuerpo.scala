package cl.uchile.dcc
package gwent.tablero.subdivisiones_combate

import gwent.tablero.{Tablero, ZonaCartasCombate}

import cl.uchile.dcc.gwent.cartas.{Carta, CartaUnidad}
import cl.uchile.dcc.gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}

class ZonaCuerpoACuerpo(var cartas_zona_in: List[CartaUnidad]) extends ZonaCartasCombate{

  def add_card(zona: ZonaCartasCombate, card: CartaCuerpoACuerpo): Unit = {
    zona.add_card_cuerpo_a_cuerpo(this, card)
  }

  override def add_card_asedio(zonaAse: ZonaAsedio, cartaase: CartaAsedio): Unit = {
    cartas_zona_in = cartaase :: cartas_zona_in
  }

  override def add_card_cuerpo_a_cuerpo(zonaCAC: ZonaCuerpoACuerpo, cartacac: CartaCuerpoACuerpo): Unit = {
    cartas_zona_in = cartacac :: cartas_zona_in
  }

  override def add_card_distancia(zonaDis: ZonaDistancia, cartadis: CartaDistancia): Unit = {
    cartas_zona_in = cartadis :: cartas_zona_in
  }
}
