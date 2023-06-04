package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

class J2GanaRonda(context: GameController) extends GameState(context) {
  override def toSiguienteRonda(): Unit = {
    context.state = new InicioRonda(context)
  }
  
  override toJ2GanaJuego(): Unit = {
    context.state = new J2GanaJuego(context)
  }
}
