package cl.uchile.dcc
package gwent.tablero
import gwent.cartas.CartaClima

import gwent.cartas.cartaclima.CartaClimaDespejado

/** Clase que representa la zona de clima del tablero.
  *
  * @param cartas_clima_in Carta de clima que se encuentra en la zona.
  */
class ZonaClima(var cartas_clima_in: CartaClima = CartaClimaDespejado("Init")) extends ZonaCartasClima {

  // Documentación en el trait ZonaCartasClima
  // Para este caso solo reemplaza la carta de clima por una inicial
  override def clean_zone(): Unit = {
    cartas_clima_in = CartaClimaDespejado("Init")
  }
  
  // Documentación en el trait ZonaCartasClima
  override def replace_clima(carta: CartaClima): Unit = {
    cartas_clima_in = carta
  }
}
