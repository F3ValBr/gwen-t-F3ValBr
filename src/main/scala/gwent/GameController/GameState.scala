package cl.uchile.dcc
package gwent.GameController

import gwent.Exceptions.InvalidTransitionException

class GameState(val context: GameController) {
  context.state = this

  var pasoTurno = false

  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(s"No se puede transicionar de ${getClass.getSimpleName} a $targetState")
  }

  def toInicioRonda(): Unit = transitionError("InicioRonda")
  def toTurnoJ1(): Unit = transitionError("TurnoJ1")
  def toTurnoJ2(): Unit = transitionError("TurnoJ2")
  def pasarTurno(): Unit = transitionError("PasarTurno")
  def toSelectCarta(): Unit = transitionError("SelectCarta")
  def jugarCarta(): Unit = transitionError("JugarCarta")
  def toFinRonda(): Unit = transitionError("FinRonda")
  def toJ1GanaRonda(): Unit = transitionError("J1GanaRonda")
  def toJ2GanaRonda(): Unit = transitionError("J2GanaRonda")
  def toEmpate(): Unit = transitionError("Empate")
  def toJ1GanaJuego(): Unit = transitionError("J1GanaJuego")
  def toJ2GanaJuego(): Unit = transitionError("J2GanaJuego")
  def toFinJuego(): Unit = transitionError("FinJuego")


  def isTurnoJ1(): Boolean = false
  def isTurnoJ2(): Boolean = false
  def pasoTurnoJ1(): Boolean = false
  def pasoTurnoJ2(): Boolean = false
  def ganoRondaJ1(): Boolean = false
  def ganoRondaJ2(): Boolean = false
  def isEmpate(): Boolean = false
  def ganoJuegoJ1(): Boolean = false
  def ganoJuegoJ2(): Boolean = false
  def isFinJuego(): Boolean = false
  def tieneGemasJ1(): Boolean = true
  def tieneGemasJ2(): Boolean = true
}
