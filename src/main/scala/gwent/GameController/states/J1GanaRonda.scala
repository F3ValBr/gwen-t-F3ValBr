package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

class J1GanaRonda(context: GameController) extends GameState(context) {
  override def toSiguienteRonda(): Unit = {
    context.state = new InicioRonda(context)
  }

  override def toJ1GanaJuego(): Unit = {
    context.state = new J1GanaJuego(context)
  }
}
