package cl.uchile.dcc
package gwent.cartas.cartaclima

import gwent.cartas.{CartaClima, CartaUnidad}

/** Una clase abstracta que crea una Carta de clima
 *
 * @constructor AbstractCartaClima, la cual tiene un nombre definido
 * @param _name Nombre de la carta de clima
 */

abstract class AbstractCartaClima(private val _name: String)
  extends CartaClima {

  var name: String = _name
  
  // Documentacion heredada desde Carta
  override def getname(): String = {
    name = _name
    name
  }
  
}
