package cl.uchile.dcc
package gwent.cartas.cartaclima

import java.util.Objects

/** Una clase CartaClimaDespejado que genera una carta de clima despejado, extendiendo a AbstractCartaClima
 *
 * @constructor CartaClimaDespejado genera una carta de clima con un nombre definido
 * @param _name Nombre de la carta de clima
 */
class CartaClimaDespejado(_name: String)
  extends AbstractCartaClima(_name) with Equals {

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
