package cl.uchile.dcc
package gwent.cartas

import java.util.Objects

class CartaLluviaTorrencial(_name: String)
  extends AbstractCartaClima(_name) with Equals {

  override def set_to_one_strength(other: CartaUnidad): Unit = {
    if (other.getClass.getSimpleName == "CartaAsedio")
      other._strength = 1
  }
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaLluviaTorrencial]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaLluviaTorrencial]
      _name == other._name
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[CartaLluviaTorrencial], _name)
  }
}