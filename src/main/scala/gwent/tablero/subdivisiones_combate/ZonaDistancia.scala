package cl.uchile.dcc
package gwent.tablero.subdivisiones_combate

import gwent.tablero.{Tablero, ZonaCartasCombate}
import gwent.Exceptions.InvalidPosForCardException
import gwent.cartas.{Carta, CartaUnidad}
import gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}

import scala.collection.mutable.ListBuffer

/**
  * Clase que representa la zona de distancia del tablero
  * @param cartas_zona_in Lista de cartas que se encuentran en la zona de distancia
  */
class ZonaDistancia(cartas_zona_in: ListBuffer[CartaUnidad] = ListBuffer()) extends AbstractZonaCombateJugador(cartas_zona_in){

  // Documentacion en el trait ZonaCartasCombate
  override def add_card_asedio(card: CartaUnidad): Unit = {
    throw new InvalidPosForCardException("No se puede agregar una carta de asedio a la zona de distancia")
  }

  // Documentacion en el trait ZonaCartasCombate
  override def add_card_cuerpo_a_cuerpo(card: CartaUnidad): Unit = {
    throw new InvalidPosForCardException("No se puede agregar una carta de cuerpo a cuerpo a la zona de distancia")
  }

  // Documentacion en el trait ZonaCartasCombate
  override def add_card_distancia(card: CartaUnidad): Unit = {
    card_adder(this.cartas_zona_in, card)
  }
}
