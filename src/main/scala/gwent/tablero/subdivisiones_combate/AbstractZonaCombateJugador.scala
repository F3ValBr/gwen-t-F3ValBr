package cl.uchile.dcc
package gwent.tablero.subdivisiones_combate

import gwent.cartas.CartaUnidad
import gwent.tablero.ZonaCartasCombate
import gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}

abstract class AbstractZonaCombateJugador(var cartas_zona_in: List[CartaUnidad]) extends ZonaCartasCombate {

  override def add_card(card: CartaUnidad): Unit = {
    card.add_card_to(this)
  }
  //override def add_card_distancia(zonaDis: ZonaDistancia, card: CartaUnidad): Unit = ???

  //override def add_card_cuerpo_a_cuerpo(zonaCAC: ZonaCuerpoACuerpo, card: CartaUnidad): Unit = ???

  //override def add_card_asedio(zonaAse: ZonaAsedio, card: CartaUnidad): Unit = ???

}
