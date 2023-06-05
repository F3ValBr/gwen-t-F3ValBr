package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

class J1GanaJuego(context: GameController) extends GameState(context) {
  override def ganoJuegoJ1(): Boolean = true
  override def toFinJuego(): Unit = {
    context.state = new FinJuego(context)
  }
}
