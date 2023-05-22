package cl.uchile.dcc
package gwent.tablero.subdivisiones_combate

import gwent.tablero.{Tablero, ZonaCartasCombate}

import cl.uchile.dcc.gwent.Exceptions.InvalidPosForCardException
import cl.uchile.dcc.gwent.cartas.{Carta, CartaUnidad}
import cl.uchile.dcc.gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}

class ZonaAsedio(var cartas_zona_in: List[CartaUnidad] = List()) extends ZonaCartasCombate{

  override def add_card(card: CartaUnidad): Unit = {
    card.add_card_to(this)
  }

  def add_card_asedio(card: CartaUnidad): Unit = {
    cartas_zona_in = card :: cartas_zona_in
  }

  def add_card_cuerpo_a_cuerpo(card: CartaUnidad): Unit = {
    throw new InvalidPosForCardException("No se puede agregar una carta de cuerpo a cuerpo a la zona de asedio")
  }

  def add_card_distancia(card: CartaUnidad): Unit = {
    throw new InvalidPosForCardException("No se puede agregar una carta de distancia a la zona de asedio")
  }

}
