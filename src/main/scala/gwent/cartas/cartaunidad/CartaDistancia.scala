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

  /** Un metodo pow_strength que toma una carta de unidad y modifica su atributo de fuerza
   * @param other carta de la cual se pueden obtener sus atributos
   */
  override def pow_strength(other: CartaUnidad): Unit = {
    // solo puede modificar a una carta de unidad cuya clasificacion concuerde con la de
    // esta misma carta, ademas de verificar que la carta tenga una habilidad definida
    if (other.getClass.getSimpleName == carddis && _ability.isDefined) {

      // si la habilidad de la carta es esfuerzo moral, la fuerza de la otra carta suma 1
      if (_ability.get == rm) {
        other._strength += 1

        // si la habilidad de la carta es Vinculo Estrecho y ademas la carta que modifica tiene el
        // mismo nombre que la carta a modificar, tanto a la carta propia como a la modificada se le duplica su fuerza
      } else if (_ability.get == ve && _name == other._name) {
        _strength *= 2
        other._strength *= 2
      }
    }
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
