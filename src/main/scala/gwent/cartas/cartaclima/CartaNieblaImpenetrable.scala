package cl.uchile.dcc
package gwent.cartas.cartaclima

import gwent.cartas.CartaUnidad

import java.util.Objects

/** Una clase CartaNieblaImpenetrable que genera una carta de niebla impenetrable, extendiendo a AbstractCartaClima
 *
 * @constructor CartaNieblaImpenetrable genera una carta de clima con un nombre definido
 *              y sobreescribiendo la funcion para setear el valor de fuerza a 1 de una carta de unidad
 * @param _name Nombre de la carta de clima
 */

class CartaNieblaImpenetrable(_name: String)
  extends AbstractCartaClima(_name) with Equals {

  /** se sobreescribe la funcion mod_strength para modificar el valor de
  * fuerza de una carta de unidad
  * se añade a la sobreescritura la condicion de que la modificacion de fuerza
  * solo se hace para determinado tipo de carta de unidad
  */
  override def mod_strength(other: CartaUnidad): Unit = {
    if (other.getClass.getSimpleName == "CartaDistancia")
      other._current_strength = 1
  }

  /// Documentacion heredada desde [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaNieblaImpenetrable]

  /// Documentacion heredada desde [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaNieblaImpenetrable]
      _name == other._name
    } else {
      false
    }
  }

  /// Documentacion heredada desde [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[CartaNieblaImpenetrable], _name)
  }
}
