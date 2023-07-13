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
   *
   * @param targetState Nombre del estado al que se intenta transicionar.
   */
  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(s"No se puede transicionar de ${getClass.getSimpleName} a $targetState")
  }

  // A continuación se definen los métodos que permiten transicionar a otros estados.
  // En principio se declaran con error de transicion, ya que dependiendo del estado al que salten se hara override

  /**
   * Método que transiciona al estado InicioRonda.
   */
  def toInicioRonda(): Unit = transitionError("InicioRonda")

  /**
   * Método que transiciona al estado TurnoJ1.
   */
  def toTurnoJ1(): Unit = transitionError("TurnoJ1")

  /**
   * Método que transiciona al estado TurnoJ2.
   */
  def toTurnoJ2(): Unit = transitionError("TurnoJ2")

  /**
   * Método que transiciona al estado PasarTurno.
   */
  def pasarTurno(): Unit = transitionError("PasarTurno")

  /**
   * Método que transiciona al estado SelectCarta.
   */
  def toSelectCarta(): Unit = transitionError("SelectCarta")

  /**
   * Método que transiciona al estado JugarCarta.
   */
  def jugarCarta(): Unit = transitionError("JugarCarta")

  /**
   * Método que transiciona al estado FinRonda.
   */
  def toFinRonda(): Unit = transitionError("FinRonda")

  /**
   * Método que transiciona al estado J1GanaRonda.
   */
  def toJ1GanaRonda(): Unit = transitionError("J1GanaRonda")

  /**
   * Método que transiciona al estado J2GanaRonda.
   */
  def toJ2GanaRonda(): Unit = transitionError("J2GanaRonda")

  /**
   * Método que transiciona al estado Empate.
   */
  def toEmpate(): Unit = transitionError("Empate")

  /**
   * Método que transiciona al estado J1GanaJuego.
   */
  def toJ1GanaJuego(): Unit = transitionError("J1GanaJuego")

  /**
   * Método que transiciona al estado J2GanaJuego.
   */
  def toJ2GanaJuego(): Unit = transitionError("J2GanaJuego")

  /**
   * Método que transiciona al estado FinJuego.
   */
  def toFinJuego(): Unit = transitionError("FinJuego")

  
  // A continuación se definen los métodos que permiten consultar el estado actual del juego.
  // Todos se definen falso y se hara el cambio a verdadero de acuerdo a los estados a los que transicione.
  /**
   * Método que indica si el estado actual es TurnoJ1.
   * @return Verdadero si el estado actual es TurnoJ1, falso en caso contrario.
   */
  def isTurnoJ1(): Boolean = false
  /**
   * Método que indica si el estado actual es TurnoJ2.
   * @return Verdadero si el estado actual es TurnoJ2, falso en caso contrario.
   */
  def isTurnoJ2(): Boolean = false
  /**
   * Método que indica si el estado actual es PasarTurno, esto revisandose para el jugador 1.
   * @return Verdadero si el estado actual es PasarTurno, falso en caso contrario.
   */
  def pasoTurnoJ1(): Boolean = false
  /**
   * Método que indica si el estado actual es PasarTurno, esto revisandose para el jugador 2.
   * @return Verdadero si el estado actual es PasarTurno, falso en caso contrario.
   */
  def pasoTurnoJ2(): Boolean = false
  /**
   * Método que indica si el estado actual es J1GanaRonda.
   * @return Verdadero si el estado actual es J1GanaRonda, falso en caso contrario.
   */
  def ganoRondaJ1(): Boolean = false
  /**
   * Método que indica si el estado actual es J2GanaRonda.
   * @return Verdadero si el estado actual es J2GanaRonda, falso en caso contrario.
   */
  def ganoRondaJ2(): Boolean = false
  /**
   * Método que indica si el estado actual es Empate.
   * @return Verdadero si el estado actual es Empate, falso en caso contrario.
   */
  def isEmpate(): Boolean = false
  /**
   * Método que indica si el estado actual es J1GanaJuego.
   * @return Verdadero si el estado actual es J1GanaJuego, falso en caso contrario.
   */
  def ganoJuegoJ1(): Boolean = false
  /**
   * Método que indica si el estado actual es J2GanaJuego.
   * @return Verdadero si el estado actual es J2GanaJuego, falso en caso contrario.
   */
  def ganoJuegoJ2(): Boolean = false
  /**
   * Método que indica si el estado actual es FinJuego.
   * @return Verdadero si el estado actual es FinJuego, falso en caso contrario.
   */
  def isFinJuego(): Boolean = false
  /**
   * Método que indica si J1 tiene gemas para continuar el juego.
   * @return Verdadero si aun tiene gemas, falso en caso contrario.
   */
  def tieneGemasJ1(): Boolean = true
  /**
   * Método que indica si J2 tiene gemas para continuar el juego.
   * @return Verdadero si aun tiene gemas, falso en caso contrario.
   */
  def tieneGemasJ2(): Boolean = true
}
