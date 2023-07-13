package cl.uchile.dcc
package gwent.GameController

import gwent.Exceptions.InvalidTransitionException

/**
  * Clase abstracta que representa un estado del juego.
  * Cada estado implementa los métodos que permiten transicionar a otros estados.
  * Además, implementa métodos que permiten consultar el estado actual del juego.
  *
  * @param context Referencia al controlador del juego.
  *  
  * @constructor Crea un nuevo estado del juego.
  */
class GameState(val context: GameController) {
  context.state = this

  var pasoTurno = false

  /**
   * Medoto que crea una excepción cuando se intenta transicionar a un estado inválido.
   * @param targetState Nombre del estado al que se intenta transicionar.
   */
  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(s"No se puede transicionar de ${getClass.getSimpleName} a $targetState")
  }

  // A continuación se definen los métodos que permiten transicionar a otros estados.
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

  // A continuación se definen los métodos que permiten consultar el estado actual del juego.
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
