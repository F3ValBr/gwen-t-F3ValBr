package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

/** Estado que representa que el jugador 1 gana el juego.
 * @param context el controlador de juego.
 */
class J1GanaJuego(context: GameController) extends GameState(context) {
  override def ganoRondaJ1(): Boolean = true
  override def ganoJuegoJ1(): Boolean = true
  override def toFinJuego(): Unit = {
    context.state = new FinJuego(context)
  }
}
