package cl.uchile.dcc
package gwent.cartas.cartaclima

import gwent.cartas.{CartaClima, CartaUnidad}

/** Una clase abstracta que crea una Carta de clima
 *
 * @constructor AbstractCartaClima, la cual tiene un nombre definido
 * @param _name Nombre de la carta de clima
 */

abstract class AbstractCartaClima(override val _name: String)
  extends CartaClima
