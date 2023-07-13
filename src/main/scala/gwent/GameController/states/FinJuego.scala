package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

/**
  * Estado que representa el fin del juego.
  * @param context el controlador de juego.
  */
class FinJuego(context: GameController) extends GameState(context) {
  override def isFinJuego(): Boolean = true
}
