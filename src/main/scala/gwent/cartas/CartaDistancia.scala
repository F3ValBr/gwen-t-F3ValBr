package cl.uchile.dcc
package gwent.cartas

import gwent.cartas.AbstractCartaUnidad
import java.util.Objects

class CartaDistancia(_name: String,
                             _strength: Int,
                             _ability: Option[String])
  extends AbstractCartaUnidad(_name, _strength, _ability) with Equals {

  def this(_name: String, _strength: Int) = {
    this(_name, _strength, None)
  }
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
