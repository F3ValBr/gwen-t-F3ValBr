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
   * Esta funcion se encarga de setear la fuerza en el valor original que tenia
   * previo a ser afectado por una carta climatica de otro tipo
   */
  override def mod_strength(other: CartaUnidad): Unit = {
    other._current_strength = other._strength
  }

  def get_mod_strength_em(other: CartaEscarchaMordiente): Unit = {

  }

  def get_mod_strength_lt(other: CartaLluviaTorrencial): Unit = {

  }

  def get_mod_strength_ci(other: CartaNieblaImpenetrable): Unit = {

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
