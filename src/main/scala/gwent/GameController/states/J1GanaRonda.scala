package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

/**
  * Estado que representa que el jugador 1 gano la ronda.
  * @param context el controlador del juego.
  */
class J1GanaRonda(context: GameController) extends GameState(context) {
  override def ganoRondaJ1(): Boolean = true

  override def toInicioRonda(): Unit = {
    context.state = new InicioRonda(context)
  }
  
  override def toJ1GanaJuego(): Unit = {
    context.state = new J1GanaJuego(context)
  }
}
