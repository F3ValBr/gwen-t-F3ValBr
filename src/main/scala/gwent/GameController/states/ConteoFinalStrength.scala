package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

class ConteoFinalStrength(context: GameController) extends GameState(context) {
  override def toJ1GanaRonda(): Unit = {
    context.state = new J1GanaRonda(context)
  }

  override def toJ2GanaRonda(): Unit = {
    context.state = new J2GanaRonda(context)
  }

  override def toEmpate(): Unit = {
    context.state = new Empate(context)
  }
}
