package cl.uchile.dcc
package gwent.GameController

import gwent.GameController.states.InicioRonda
import gwent.GameController.observer.{Observer, Subject, WinCondition}
import gwent.jugadores.{Jugador, JugadorCPU, JugadorP1}

class GameController extends Observer[WinCondition] {
  private var jugador1: JugadorP1 = _//Option[JugadorP1] = None
  private var jugador2: JugadorCPU = _//Option[JugadorCPU] = None

  var state: GameState = new InicioRonda(this)

  def startGame(jugador_n: String = "J1", cpu_n: String = "CPU"): Unit = {
    jugador1 = addJugador(jugador_n)
    jugador2 = addCPU(cpu_n)
    
  }

  private def addJugador(name: String): JugadorP1 = {
    jugador1 = new JugadorP1(name)
    jugador1.addObserver(this)
    jugador1
  }

  private def addCPU(name: String): JugadorCPU = {
    jugador2 = new JugadorCPU(name)
    jugador2.addObserver(this)
    jugador2
  }

  override def update(subject: Subject[WinCondition], value: WinCondition): Unit = {
    println(s"Jugador $subject ha ganado la ronda por ${value.name}")
  }

  def toInicioRonda(): Unit = state.toInicioRonda()
  def toTurnoJ1(): Unit = state.toTurnoJ1()
  def toTurnoJ2(): Unit = state.toTurnoJ2()
  def pasarTurno(): Unit = state.pasarTurno()
  def toSelectCarta(): Unit = state.toSelectCarta()
  def jugarCarta(): Unit = state.jugarCarta()
  def toFinRonda(): Unit = state.toFinRonda()
  def toConteoFinalStrength(): Unit = state.toConteoFinalStrength()
  def toJ1GanaRonda(): Unit = state.toJ1GanaRonda()
  def toJ2GanaRonda(): Unit = state.toJ1GanaRonda()
  def toEmpate(): Unit = state.toEmpate()
  def toJ1GanaJuego(): Unit = state.toJ2GanaJuego()
  def toJ2GanaJuego(): Unit = state.toJ2GanaJuego()
  def toSiguienteRonda(): Unit = state.toSiguienteRonda()
  def toFinJuego(): Unit = state.toFinJuego()


  def isTurnoJ1(): Boolean = state.isTurnoJ1()
  def isTurnoJ2(): Boolean = state.isTurnoJ2()

  def pasoTurnoJ1(): Boolean = state.pasoTurnoJ1()

  def pasoTurnoJ2(): Boolean = state.pasoTurnoJ2()
  def ganoRondaJ1(): Boolean = state.ganoRondaJ1()
  def ganoRondaJ2(): Boolean = state.ganoRondaJ2()
  def isEmpate(): Boolean = state.isEmpate()
  def ganoJuegoJ1(): Boolean = state.ganoJuegoJ1()
  def ganoJuegoJ2(): Boolean = state.ganoJuegoJ2()
  def isFinJuego(): Boolean = state.isFinJuego()
  def tieneGemasJ1(): Boolean = state.tieneGemasJ1()
  def tieneGemasJ2(): Boolean = state.tieneGemasJ2()
}
