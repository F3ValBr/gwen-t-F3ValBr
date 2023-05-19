package cl.uchile.dcc
package gwent.tablero.subdivisiones_combate

import gwent.tablero.{Tablero, ZonaCartasCombate}

import cl.uchile.dcc.gwent.Exceptions.InvalidPosForCardException
import cl.uchile.dcc.gwent.cartas.{Carta, CartaUnidad}
import cl.uchile.dcc.gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}

class ZonaDistancia(var cartas_zona_in: List[CartaUnidad] = List()) extends ZonaCartasCombate{

  def add_card(zona: ZonaCartasCombate, card: CartaDistancia): Unit = {
    zona.add_card_distancia(this, card)
  }

  override def add_card_asedio(zonaAse: ZonaAsedio, card: CartaAsedio): Unit = {
    throw new InvalidPosForCardException("No se puede agregar una carta de asedio a la zona de distancia")
  }

  override def add_card_cuerpo_a_cuerpo(zonaCAC: ZonaCuerpoACuerpo, card: CartaCuerpoACuerpo): Unit = {
    throw new InvalidPosForCardException("No se puede agregar una carta de cuerpo a cuerpo a la zona de distancia")
  }

  override def add_card_distancia(zonaDis: ZonaDistancia, card: CartaDistancia): Unit = {
    cartas_zona_in = card :: cartas_zona_in
  }
}
