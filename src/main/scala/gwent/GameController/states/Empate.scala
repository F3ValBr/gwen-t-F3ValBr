package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

class Empate(context: GameController) extends GameState(context) {
  override def toSiguienteRonda(): Unit = {
    context.state = new SiguienteRonda(context)
  }

  override def toJ1GanaJuego(): Unit = {
    context.state = new J1GanaJuego(context)
  }

  override def toJ2GanaJuego(): Unit = {
    context.state = new J2GanaJuego(context)
  }
}
