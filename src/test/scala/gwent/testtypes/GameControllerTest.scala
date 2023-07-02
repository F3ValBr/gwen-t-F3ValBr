package cl.uchile.dcc
package gwent.testtypes

import gwent.GameController.GameController
import munit.FunSuite

class GameControllerTest extends FunSuite{
  test("Testeo del controlador del juego"){
    val gameController = new GameController()
    val player1 = "jugador1"
    val player2 = "jugador2"
    gameController.startGame(player1, player2)
    assert(!gameController.isTurnoJ1())
    gameController.toTurnoJ1()
    assert(gameController.isTurnoJ1())
    gameController.pasarTurno()
    assert(!gameController.isTurnoJ1())
    assert(gameController.isTurnoJ2())
    gameController.jugarCarta()
    assert(!gameController.isTurnoJ2())
    gameController.toTurnoJ1()
    assert(gameController.isTurnoJ1())
  }

  test("testeo")
}
