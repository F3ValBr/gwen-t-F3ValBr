package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

/**
  * Estado que representa un empate entre los jugadores.
  * @param context el controlador del juego.
  */
class Empate(context: GameController) extends GameState(context) {
  override def isEmpate(): Boolean = true
  
  override def toInicioRonda(): Unit = {
    context.state = new InicioRonda(context)
  }

  override def toJ1GanaJuego(): Unit = {
    context.state = new J1GanaJuego(context)
  }

  override def toJ2GanaJuego(): Unit = {
    context.state = new J2GanaJuego(context)
  }
}
