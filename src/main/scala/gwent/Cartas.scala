package cl.uchile.dcc
package gwent

/** Clase representando cartas
 *
 * Cartas son definidas principalmente por su clasificacion, a partir de eso
 * se definen los atributos de las cartas
 *
 * @param clasific La clasificacion de la carta
 *
 * Si es carta de Unidad, recibe los sgtes parametros
 * @param _fuerza La fuerza medida en un numero entero
 * @param _tipo La asignacion de la carta segun un luagr del tablero
 * @param _habilidad La habilidad que puede recibir la carta, o bien puede no tenerla
 *
 * Si es carta de clima, recibe los sgtes parametros
 * @param _climatipo El tipo de clima que posee la carta en cuestion
 *
 * @author Felipe Valdebenito Bravo
 * */
class Cartas(val clasific: String) {
  var _fuerza: Int = 0
  var _tipo: String = ""
  var _habilidad: Option[String] = None
  var _climatipo: String = ""

  /**  */
  def this(clasific: String, fuerza: Int, tipo: String, habilidad: String) = {
    this(clasific)
    _fuerza = fuerza
    _tipo = tipo
    _habilidad = Some(habilidad)
  }

  def this(clasific: String, climatipo: String) = {
    this(clasific)
    _climatipo = climatipo
  }

  // funcion para determinar si dos valores son iguales pese a tener ubicaciones de memoria distintas
  /** override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Cartas]) {
      val goo = other.asInstanceOf[Cartas]
      _tipo == goo._tipo // && seccion == foo.seccion
    } else {
      false
    }
  }*/
}
