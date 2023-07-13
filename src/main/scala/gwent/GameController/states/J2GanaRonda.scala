package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

/**
  * Estado que representa que el jugador 2 gano la ronda.
  * @param context el controlador de juego.
  */
class J2GanaRonda(context: GameController) extends GameState(context) {

  override def ganoRondaJ2(): Boolean = true

  override def toInicioRonda(): Unit = {
    context.state = new InicioRonda(context)
  }
  
  override def toJ2GanaJuego(): Unit = {
    context.state = new J2GanaJuego(context)
  }
}
