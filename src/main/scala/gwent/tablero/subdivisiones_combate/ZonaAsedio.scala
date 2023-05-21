package cl.uchile.dcc
package gwent.tablero.subdivisiones_combate

import gwent.tablero.{Tablero, ZonaCartasCombate}

import cl.uchile.dcc.gwent.Exceptions.InvalidPosForCardException
import cl.uchile.dcc.gwent.cartas.{Carta, CartaUnidad}
import cl.uchile.dcc.gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}

class ZonaAsedio(var cartas_zona_in: List[CartaUnidad] = List()) extends ZonaCartasCombate{

  override def add_card(zona: ZonaCartasCombate, card: CartaUnidad): Unit = {
    zona.add_card_asedio(this, card)
  }

  def add_card_asedio(zonaAse: ZonaAsedio, card: CartaUnidad): Unit = {
    cartas_zona_in = card :: cartas_zona_in
  }

  def add_card_cuerpo_a_cuerpo(zonaCAC: ZonaCuerpoACuerpo, card: CartaUnidad): Unit = {
    throw new InvalidPosForCardException("No se puede agregar una carta de cuerpo a cuerpo a la zona de asedio")
  }

  def add_card_distancia(zonaDis: ZonaDistancia, card: CartaUnidad): Unit = {
    throw new InvalidPosForCardException("No se puede agregar una carta de distancia a la zona de asedio")
  }

}
