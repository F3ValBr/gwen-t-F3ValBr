package cl.uchile.dcc
package gwent.tablero.subdivisiones_combate

import gwent.tablero.{Tablero, ZonaCartasCombate}
import gwent.Exceptions.InvalidPosForCardException
import gwent.cartas.{Carta, CartaUnidad}
import gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}

import scala.collection.mutable.ListBuffer

/**
  * Clase que representa la zona de asedio de un jugador
  * @param cartas_zona_in Lista de cartas que se encuentran en la zona de asedio
  */
class ZonaCuerpoACuerpo(cartas_zona_in: ListBuffer[CartaUnidad] = ListBuffer()) extends AbstractZonaCombateJugador(cartas_zona_in){

  // Documentacion en el trait ZonaCartasCombate
  override def add_card_asedio(card: CartaUnidad): Unit = {
    throw new InvalidPosForCardException("No se puede agregar una carta de asedio a la zona de cuerpo a cuerpo")
  }

  // Documentacion en el trait ZonaCartasCombate
  override def add_card_cuerpo_a_cuerpo(card: CartaUnidad): Unit = {
    card_adder(this.cartas_zona_in, card)
  }

  // Documentacion en el trait ZonaCartasCombate
  override def add_card_distancia(card: CartaUnidad): Unit = {
    throw new InvalidPosForCardException("No se puede agregar una carta de distancia a la zona de cuerpo a cuerpo")
  }
}
