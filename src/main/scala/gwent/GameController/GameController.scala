package cl.uchile.dcc
package gwent.GameController

import gwent.GameController.states.{FinJuego, InicioRonda, J1GanaJuego, J2GanaJuego}
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
    val player = new JugadorP1(name)
    player.addObserver(this)
    player
  }

  private def addCPU(name: String): JugadorCPU = {
    val player = new JugadorCPU(name)
    player.addObserver(this)
    player
  }

  override def update(subject: Subject[WinCondition], value: WinCondition): Unit = {
    println(s"Jugador ${subject.getClass.getSimpleName} ha perdido el juego por quedar sin ${value.name}")
    if (jugador1.getgems() == 0){
      println(s"Jugador ${jugador2.getname()} ha ganado el juego")
      state = new J2GanaJuego(this)
    } else if (jugador2.getgems() == 0) {
      println(s"Jugador ${jugador1.getname()} ha ganado el juego")
      state = new J1GanaJuego(this)
    }
  }

  def elim_gem_j1(): Unit = jugador1.del_gems()
  def elim_gem_j2(): Unit = jugador2.del_gems()

  def toInicioRonda(): Unit = state.toInicioRonda()
  def toTurnoJ1(): Unit = state.toTurnoJ1()
  def toTurnoJ2(): Unit = state.toTurnoJ2()
  def pasarTurno(): Unit = state.pasarTurno()
  def toSelectCarta(): Unit = state.toSelectCarta()
  def jugarCarta(): Unit = state.jugarCarta()
  def toFinRonda(): Unit = state.toFinRonda()
  def toJ1GanaRonda(): Unit = state.toJ1GanaRonda()
  def toJ2GanaRonda(): Unit = state.toJ2GanaRonda()
  def toEmpate(): Unit = state.toEmpate()
  def toJ1GanaJuego(): Unit = state.toJ1GanaJuego()
  def toJ2GanaJuego(): Unit = state.toJ2GanaJuego()
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
