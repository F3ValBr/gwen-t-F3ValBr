package cl.uchile.dcc
package gwent.tablero.subdivisiones_combate

import gwent.cartas.CartaUnidad
import gwent.tablero.ZonaCartasCombate
import gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}

import scala.collection.mutable.ListBuffer

abstract class AbstractZonaCombateJugador(var cartas_zona_in: ListBuffer[CartaUnidad]) extends ZonaCartasCombate{

  override def clean_zone(): Unit = {
    cartas_zona_in = ListBuffer()
  }

  override def counter_strength(/*group_of_cards: List[CartaUnidad]*/): Int = {
    var total_strength: Int = 0
    for (card <- cartas_zona_in) {
      if (card._current_strength > 0) {
        total_strength += card._current_strength
      }
    }
    //group_of_cards.foreach(card => total_strength += card._current_strength)
    total_strength
  }

  override def add_card(card: CartaUnidad): Unit = {
    card.add_card_to(this)
  }

  override def card_adder(list_of_cards: ListBuffer[CartaUnidad], card: CartaUnidad): Unit = {
    list_of_cards += card
  }
}
