package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

class SiguienteRonda(context: GameController) extends GameState(context) {
  override def toInicioRonda(): Unit = {
    context.state = new InicioRonda(context)
  }
}
