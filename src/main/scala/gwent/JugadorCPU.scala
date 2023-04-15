package cl.uchile.dcc
package gwent

import java.util.Objects

class JugadorCPU (name: String,
                  gems: Int = 2,
                  deck: Int = 25,
                  hand: Int = 0)
  extends AbstractJugador(name,gems,deck,hand) with Equals {

  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[JugadorCPU]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[JugadorCPU]
      name == other.name
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[JugadorCPU], name)
  }
}
