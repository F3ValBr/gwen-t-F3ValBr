package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

class Empate(context: GameController) extends GameState(context) {
  override def isEmpate(): Boolean = true
  //override def toSiguienteRonda(): Unit = {
  //  context.state = new SiguienteRonda(context)
  //}
  
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
