package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

class J2GanaJuego(context: GameController) extends GameState(context) {
  override def ganoRondaJ2(): Boolean = true
  override def ganoJuegoJ2(): Boolean = true
  override def toFinJuego(): Unit = {
    context.state = new FinJuego(context)
  }
}
