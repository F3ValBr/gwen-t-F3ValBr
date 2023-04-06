package cl.uchile.dcc
package gwent

class Cartas(val clasific: String) {
  private var _fuerza: Int = 0
  private var _tipo: String = ""
  private var _habilidad: Option[String] = None
  private var _climatipo: String = ""

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
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Cartas]) {
      val goo = other.asInstanceOf[Cartas]
      tipo == goo.tipo // && seccion == foo.seccion
    } else {
      false
    }
  }
}
