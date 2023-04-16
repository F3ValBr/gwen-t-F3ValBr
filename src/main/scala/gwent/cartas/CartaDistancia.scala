package cl.uchile.dcc
package gwent.cartas

import gwent.cartas.AbstractCartaUnidad
import java.util.Objects

private class CartaDistancia(_name: String, 
                             _strength: Int, 
                             _ability: Option[String])
  extends AbstractCartaUnidad(_name, _strength, _ability) with Equals {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaDistancia]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaDistancia]
      _name == other._name
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[CartaDistancia], _name)
  }
}
