package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

/**
  * Estado que representa el inicio de una ronda
  * @param context contexto del controlador del juego
  */
class InicioRonda(context: GameController) extends GameState(context) {
  override def toTurnoJ1(): Unit = {
    context.state = new TurnoJ1(context)
  }
}
