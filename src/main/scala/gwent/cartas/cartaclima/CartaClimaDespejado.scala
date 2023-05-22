package cl.uchile.dcc
package gwent.cartas.cartaclima

import gwent.cartas.CartaUnidad

import java.util.Objects

/** Una clase CartaClimaDespejado que genera una carta de clima despejado, extendiendo a AbstractCartaClima
 *
 * @constructor CartaClimaDespejado genera una carta de clima con un nombre definido
 * @param _name Nombre de la carta de clima
 */
class CartaClimaDespejado(_name: String)
  extends AbstractCartaClima(_name) with Equals {

  /** se sobreescribe la funcion mod_strength para modificar el valor de
   * fuerza de una carta de unidad
   * Este no es el comportamiento apropiado de esta carta, investigar como setear valores y devolverlos
   */
  override def mod_strength(other: CartaUnidad): Unit = {
    other._strength = 1
  }

  /// Documentacion heredada desde [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaClimaDespejado]

  /// Documentacion heredada desde [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaClimaDespejado]
      _name == other._name
    } else {
      false
    }
  }

  /// Documentacion heredada desde [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[CartaClimaDespejado], _name)
  }
}
