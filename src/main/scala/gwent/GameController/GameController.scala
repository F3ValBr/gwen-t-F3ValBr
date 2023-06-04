package cl.uchile.dcc
package gwent.GameController

import gwent.GameController.states.InicioRonda

import cl.uchile.dcc.gwent.jugadores.{Jugador, JugadorCPU, JugadorP1}

class GameController {
  private var jugador1: JugadorP1 = _//Option[JugadorP1] = None
  private var jugador2: JugadorCPU = _//Option[JugadorCPU] = None

  var state: GameState = new InicioRonda(this)

  def startGame(jugador_n: String, cpu_n: String = "CPU"): Unit = {
    jugador1 = addJugador(jugador_n)
    jugador2 = addCPU(cpu_n)
  }

  def addJugador(name: String): JugadorP1 = {
    jugador1 = new JugadorP1(name)
    jugador1
  }

  def addCPU(name: String): JugadorCPU = {
    jugador2 = new JugadorCPU(name)
    jugador2
  }
}
