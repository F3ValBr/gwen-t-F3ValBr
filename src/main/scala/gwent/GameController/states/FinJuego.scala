package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

class FinJuego(context: GameController) extends GameState(context) {
  override def isFinJuego(): Boolean = true
}
