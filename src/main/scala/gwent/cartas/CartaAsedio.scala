package cl.uchile.dcc
package gwent.cartas

import java.util.Objects

class CartaAsedio(_name: String,
                  _strength: Int,
                  _ability: Option[String])
  extends AbstractCartaUnidad(_name, _strength, _ability) with Equals {

  def this(_name: String, _strength: Int) = {
    this(_name, _strength, None)
  }

  override def pow_strength(other: CartaUnidad): Unit = {
    if (other.getClass.getSimpleName == "CartaAsedio") {
      if (_ability.isEmpty) {
        other._strength
      } else if (_ability.get == rm) {
        other._strength += 1
      } else if (_ability.get == ve && _name == other._name) {
        _strength *= 2
        other._strength *= 2
      }
    }
  }

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
