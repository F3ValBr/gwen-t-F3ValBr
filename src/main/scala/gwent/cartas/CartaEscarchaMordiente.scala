package cl.uchile.dcc
package gwent.cartas

import java.util.Objects

class CartaEscarchaMordiente(_name: String,
                            _ability: String)
  extends AbstractCartaClima(_name,_ability)
  with Equals {

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

  /**def del_strength(other: AbstractCartaUnidad): Unit = {
    if (_ability.isDefined) {
      other._strength
    }
  }*/

}
