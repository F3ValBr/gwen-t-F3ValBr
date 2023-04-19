package cl.uchile.dcc
package gwent.cartas.cartaunidad

import gwent.cartas.CartaUnidad

import java.util.Objects

/** Una clase CartaDistancia que extiende a AbstractCartaUnidad
 *
 * @constructor CartaDistancia genera una carta de unidad con los atributos de nombre y fuerza,
 *              con la opcion de incluir la habilidad que, en caso de no incluirse, se considera como None
 * @param _name     Nombre de una carta de unidad
 * @param _strength Valor de fuerza de dicha carta
 * @param _ability  Habilidad que puede o no tener la carta de unidad
 */
class CartaDistancia(_name: String,
                     _strength: Int,
                     _ability: Option[String])
  extends AbstractCartaUnidad(_name, _strength, _ability) with Equals {

  /** Un constructor auxiliar que define la clase en caso de no darse el parametro de habilidad
   * @constructor auxiliar, define como None la habilidad en caso de no ser dada
   * @param _name     Nombre de una carta de unidad
   * @param _strength Valor de fuerza de dicha carta
   */
  def this(_name: String, _strength: Int) = {
    this(_name, _strength, None)
  }

  /// Documentacion heredada desde [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaDistancia]

  /// Documentacion heredada desde [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaDistancia]
      _name == other._name
    } else {
      false
    }
  }

  /// Documentacion heredada desde [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[CartaDistancia], _name)
  }
}
