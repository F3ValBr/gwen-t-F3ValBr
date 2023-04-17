package cl.uchile.dcc
package gwent.cartas.cartaclima

import gwent.cartas.{CartaClima, CartaUnidad}

/** Una clase abstracta que crea una Carta de clima
 *
 * @constructor AbstractCartaClima, la cual tiene un nombre definido y un metodo que setea
 *              la fuerza de una carta de Unidad en 1
 * @param _name Nombre de la carta de clima
 */

abstract class AbstractCartaClima(override val _name: String)
  extends CartaClima {

  /** se sobreescribe la funcion set_to_one_strength para modificar el valor de
  * fuerza de una carta de unidad
  */
  override def set_to_one_strength(other: CartaUnidad): Unit = {
    other._strength = 1
  }
}
