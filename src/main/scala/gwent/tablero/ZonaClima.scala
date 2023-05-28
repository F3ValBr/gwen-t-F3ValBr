package cl.uchile.dcc
package gwent.tablero
import gwent.cartas.{Carta, CartaClima}
import gwent.cartas.cartaclima.CartaClimaDespejado

import scala.collection.mutable.ListBuffer

/** Clase que representa la zona de clima del tablero.
  *
  * @param cartas_clima_in Carta de clima que se encuentra en la zona.
  */
class ZonaClima(var cartas_clima_in: CartaClima = CartaClimaDespejado("Init")) extends ZonaCartasClima {

  var card_in = cartas_clima_in

  // Documentación en el trait ZonaCartasClima
  // Para este caso solo reemplaza la carta de clima por una inicial
  override def clean_zone(): Unit = {
    cartas_clima_in = CartaClimaDespejado("Init")
  }

  override def viewZone(): CartaClima = {
    card_in = cartas_clima_in
    card_in
  }

  // Documentación en el trait ZonaCartasClima
  override def replace_clima(carta: CartaClima): Unit = {
    cartas_clima_in = carta
  }
}
