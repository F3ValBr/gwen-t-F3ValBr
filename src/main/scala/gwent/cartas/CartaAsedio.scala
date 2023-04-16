package cl.uchile.dcc
package gwent.cartas

import java.util.Objects

private class CartaAsedio(_name: String, 
                          _strength: Int, 
                          _ability: Option[String])
  extends AbstractCartaUnidad(_name, _strength, _ability) with Equals {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaAsedio]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaAsedio]
      _name == other._name
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[CartaAsedio], _name)
  }
}
