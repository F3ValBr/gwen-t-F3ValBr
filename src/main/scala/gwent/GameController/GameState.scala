package cl.uchile.dcc
package gwent.GameController

import gwent.Exceptions.InvalidTransitionException

class GameState(val context: GameController) {
  context.state = this

  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(s"No se puede transicionar de ${getClass.getSimpleName} a $targetState")
  }

  def toInicioRonda(): Unit = transitionError("InicioRonda")
  def toTurnoJ1(): Unit = transitionError("TurnoJ1")
  def toTurnoJ2(): Unit = transitionError("TurnoJ2")
  def toSelectCarta(): Unit = transitionError("SelectCarta")
  def toFinRonda(): Unit = transitionError("FinRonda")
  def toConteoFinalStrength(): Unit = transitionError("ConteoFinalStrength")
  def toJ1GanaRonda(): Unit = transitionError("J1GanaRonda")
  def toJ2GanaRonda(): Unit = transitionError("J2GanaRonda")
  def toEmpate(): Unit = transitionError("Empate")
  def toJ1GanaJuego(): Unit = transitionError("J1GanaJuego")
  def toJ2GanaJuego(): Unit = transitionError("J2GanaJuego")
  def toSiguienteRonda(): Unit = transitionError("SiguienteRonda")
  def toFinJuego(): Unit = transitionError("FinJuego")

}
