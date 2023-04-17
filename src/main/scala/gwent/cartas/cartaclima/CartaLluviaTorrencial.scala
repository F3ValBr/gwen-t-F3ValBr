package cl.uchile.dcc
package gwent.cartas.cartaclima

import gwent.cartas.CartaUnidad

import java.util.Objects

/** Una clase CartaLluviaTorrencial que genera una carta de lluvia torrencial, extendiendo a AbstractCartaClima
 *
 * @constructor CartaLluviaTorrencial genera una carta de clima con un nombre definido
 *              y sobreescribiendo la funcion para setear el valor de fuerza a 1 de una carta de unidad
 * @param _name Nombre de la carta de clima
 */
class CartaLluviaTorrencial(_name: String)
  extends AbstractCartaClima(_name) with Equals {

  /** documentacion heredada desde [[AbstractCartaClima]]
  * se añade a la sobreescritura la condicion de que la modificacion de fuerza
  * solo se hace para determinado tipo de carta de unidad
  */
  override def set_to_one_strength(other: CartaUnidad): Unit = {
    if (other.getClass.getSimpleName == "CartaAsedio")
      other._strength = 1
  }

  /// Documentacion heredada desde [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaLluviaTorrencial]

  /// Documentacion heredada desde [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaLluviaTorrencial]
      _name == other._name
    } else {
      false
    }
  }

  /// Documentacion heredada desde [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[CartaLluviaTorrencial], _name)
  }
}