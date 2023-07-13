package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

/**
  * Estado en el que el jugador 2 gana el juego.
  * @param context el controlador del juego.
  */
class J2GanaJuego(context: GameController) extends GameState(context) {
  override def ganoRondaJ2(): Boolean = true
  override def ganoJuegoJ2(): Boolean = true
  override def toFinJuego(): Unit = {
    context.state = new FinJuego(context)
  }
}
