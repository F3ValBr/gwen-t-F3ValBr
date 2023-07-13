package cl.uchile.dcc
package gwent.tablero.subdivisiones_combate

import gwent.cartas.{Carta, CartaUnidad}
import gwent.tablero.ZonaCartasCombate
import gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}

import scala.collection.mutable.ListBuffer

/**
  * Clase abstracta que representa una zona de combate de un jugador.
  * @param cartas_zona_in Lista de cartas que se encuentran en la zona.
  */
abstract class AbstractZonaCombateJugador(var cartas_zona_in: ListBuffer[CartaUnidad]) extends ZonaCartasCombate{

  var cards_in: ListBuffer[CartaUnidad] = cartas_zona_in.clone()

  override def viewZone(): ListBuffer[CartaUnidad] = {
    cards_in = cartas_zona_in.clone()
    cards_in
  }

  // Documentacion en el trait ZonaCartasCombate
  // Para este caso se reinicia la zona de combate del jugador con una lista vacia
  override def clean_zone(): Unit = {
    cartas_zona_in = ListBuffer()
  }

  // Documentacion en el trait ZonaCartasCombate
  override def counter_strength(): Int = {
    var total_strength: Int = 0
    for (card <- cartas_zona_in) {
      if (card.getcurrentstrength() > 0){
        total_strength += card.getcurrentstrength()
      }
    }
    total_strength
  }

  // Documentacion en el trait ZonaCartasCombate
  override def add_card(card: CartaUnidad): Unit = {
    card.add_card_to(this)
  }

  // Documentacion en el trait ZonaCartasCombate
  override def card_adder(list_of_cards: ListBuffer[CartaUnidad], card: CartaUnidad): Unit = {
    list_of_cards += card
  }

  // Documentacion en el trait ZonaCartasCombate
  override def mod_cards(last_card: CartaUnidad): Unit = {
    for (card <- cartas_zona_in) {
      last_card.pow_strength_of(card)
    }
  }

  // Documentacion en el trait ZonaCartasCombate
  override def mod_n_add_card(card_to_add: CartaUnidad): Unit = {
    mod_cards(card_to_add)
    add_card(card_to_add)
  }
}
