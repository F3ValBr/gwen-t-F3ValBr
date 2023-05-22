package cl.uchile.dcc
package gwent.tablero.subdivisiones_combate

import gwent.tablero.{Tablero, ZonaCartasCombate}

import gwent.Exceptions.InvalidPosForCardException
import gwent.cartas.{Carta, CartaUnidad}
import gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}

class ZonaAsedio(cartas_zona_in: List[CartaUnidad] = List()) extends AbstractZonaCombateJugador(cartas_zona_in){

  override def add_card_asedio(card: CartaUnidad): Unit = {
    cartas_zona_in = card :: cartas_zona_in
  }

  override def add_card_cuerpo_a_cuerpo(card: CartaUnidad): Unit = {
    throw new InvalidPosForCardException("No se puede agregar una carta de cuerpo a cuerpo a la zona de asedio")
  }

  override def add_card_distancia(card: CartaUnidad): Unit = {
    throw new InvalidPosForCardException("No se puede agregar una carta de distancia a la zona de asedio")
  }

}
