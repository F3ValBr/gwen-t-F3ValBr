package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

class InicioRonda(context: GameController) extends GameState(context) {
  override def toTurnoJ1(): Unit = {
    context.state = new TurnoJ1(context)
  }
}
