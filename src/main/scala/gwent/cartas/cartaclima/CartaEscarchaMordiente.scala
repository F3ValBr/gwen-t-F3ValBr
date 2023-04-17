package cl.uchile.dcc
package gwent.cartas.cartaclima

import gwent.cartas.CartaUnidad

import java.util.Objects

class CartaEscarchaMordiente(_name: String)
  extends AbstractCartaClima(_name) with Equals {

  override def set_to_one_strength(other: CartaUnidad): Unit = {
    if (other.getClass.getSimpleName == "CartaCuerpoACuerpo")
      other._strength = 1
  }
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaEscarchaMordiente]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaEscarchaMordiente]
      _name == other._name
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[CartaEscarchaMordiente], _name)
  }
}
