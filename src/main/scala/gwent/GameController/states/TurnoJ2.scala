package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

class TurnoJ2(context: GameController) extends GameState(context) {
  override def toTurnoJ1(): Unit = {
    context.state = new TurnoJ1(context)
  }

  override def toSelectCarta(): Unit = {
    context.state = new SelectCarta(context)
  }
  
  override def toFinRonda(): Unit = {
    context.state = new FinRonda(context)
  }
}
