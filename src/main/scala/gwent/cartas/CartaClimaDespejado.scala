package cl.uchile.dcc
package gwent.cartas

import java.util.Objects

class CartaClimaDespejado(_name: String)
  extends AbstractCartaClima(_name) with Equals {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaClimaDespejado]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaClimaDespejado]
      _name == other._name
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[CartaClimaDespejado], _name)
  }
}
