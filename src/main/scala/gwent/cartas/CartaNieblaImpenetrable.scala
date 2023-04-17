package cl.uchile.dcc
package gwent.cartas

import java.util.Objects

class CartaNieblaImpenetrable(_name: String)
  extends AbstractCartaClima(_name) with Equals {

  override def set_to_one_strength(other: CartaUnidad): Unit = {
    if (other.getClass.getSimpleName == "CartaDistancia")
      other._strength = 1
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaNieblaImpenetrable]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaNieblaImpenetrable]
      _name == other._name
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[CartaNieblaImpenetrable], _name)
  }
}
