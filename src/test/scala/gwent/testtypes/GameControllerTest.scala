package cl.uchile.dcc
package gwent.testtypes

import gwent.GameController.GameController

import cl.uchile.dcc.gwent.Exceptions.InvalidTransitionException
import cl.uchile.dcc.gwent.GameController.states.InicioRonda
import munit.FunSuite

class GameControllerTest extends FunSuite{
  var gameController: GameController = _

  val player1 = "jugador1"
  val player2 = "jugador2"

  override def beforeEach(context: BeforeEach): Unit = {
    gameController = new GameController()
  }

  test("Se puede pasar a traves de todos los estados creados, y hay estados de los que no se puede transicionar a otros"){
    gameController.startGame()
    interceptMessage[InvalidTransitionException]("No se puede transicionar de InicioRonda a FinJuego") {
      gameController.toFinJuego()
    }
    interceptMessage[InvalidTransitionException]("No se puede transicionar de InicioRonda a Empate") {
      gameController.toEmpate()
    }
    interceptMessage[InvalidTransitionException]("No se puede transicionar de InicioRonda a J1GanaJuego") {
      gameController.toJ1GanaJuego()
    }
    interceptMessage[InvalidTransitionException]("No se puede transicionar de InicioRonda a J2GanaJuego") {
      gameController.toJ2GanaJuego()
    }
    interceptMessage[InvalidTransitionException]("No se puede transicionar de InicioRonda a SelectCarta") {
      gameController.toSelectCarta()
    }
    interceptMessage[InvalidTransitionException]("No se puede transicionar de InicioRonda a TurnoJ2") {
      gameController.toTurnoJ2()
    }
    assert(!gameController.isTurnoJ1())

    gameController.toTurnoJ1()
    interceptMessage[InvalidTransitionException]("No se puede transicionar de TurnoJ1 a FinJuego") {
      gameController.toFinJuego()
    }
    assert(gameController.isTurnoJ1())
    gameController.pasarTurno()
    assert(!gameController.isTurnoJ1())
    assert(gameController.isTurnoJ2())
    gameController.jugarCarta()
    assert(!gameController.isTurnoJ2())
    gameController.toSelectCarta()
    assert(!gameController.isTurnoJ2())
    gameController.toTurnoJ1()
    assert(gameController.isTurnoJ1())
    gameController.jugarCarta()
    assert(!gameController.isTurnoJ1())
    gameController.toTurnoJ2()
    assert(gameController.isTurnoJ2())
    gameController.toFinRonda()
    gameController.toEmpate()
    assert(gameController.isEmpate())
    gameController.toInicioRonda()
    gameController.toTurnoJ1()
    assert(gameController.isTurnoJ1())
    gameController.toFinRonda()
    gameController.toJ1GanaRonda()
    assert(gameController.ganoRondaJ1())
    assert(!gameController.ganoRondaJ2())
    //gameController.toJ1GanaJuego()
    assert(gameController.ganoJuegoJ1())
    gameController.toFinJuego()
  }

  test("JugadorCPU gana la partida y se notifica al observer de ello"){
    gameController.startGame()
    gameController.toTurnoJ1()
    gameController.toFinRonda()
    gameController.toJ1GanaRonda()
    gameController.toInicioRonda()
    gameController.toTurnoJ1()
    gameController.toFinRonda()
    gameController.toJ1GanaRonda()
    assert(gameController.ganoJuegoJ1())
    gameController.toFinJuego()
    assert(gameController.isFinJuego())
  }

  test("Jugador1 gana la partida y se notifica al observer de ello"){
    gameController.startGame()
    gameController.toTurnoJ1()
    gameController.toFinRonda()
    gameController.toJ2GanaRonda()
    gameController.toInicioRonda()
    gameController.toTurnoJ1()
    gameController.toFinRonda()
    gameController.toJ2GanaRonda()
    assert(gameController.ganoJuegoJ2())
    gameController.toFinJuego()
    assert(gameController.isFinJuego())
  }
}
