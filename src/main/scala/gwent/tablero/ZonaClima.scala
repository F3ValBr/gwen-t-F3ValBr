package cl.uchile.dcc
package gwent.tablero
import gwent.cartas.CartaClima

import gwent.cartas.cartaclima.CartaClimaDespejado

class ZonaClima(var cartas_clima_in: CartaClima = CartaClimaDespejado("Init")) extends ZonaCartasClima {

  override def clean_zone(): Unit = {
    cartas_clima_in = CartaClimaDespejado("Init")
  }
  
  override def replace_clima(carta: CartaClima): Unit = {
    cartas_clima_in = carta
  }
}
