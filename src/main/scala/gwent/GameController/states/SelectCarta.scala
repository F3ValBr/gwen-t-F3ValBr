package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

class SelectCarta(context: GameController) extends GameState(context) {
  override def toSelectCarta(): Unit = {
    println("Ya estas en este estado")
  }

  override def toTurnoJ1(): Unit = {
    context.state = new TurnoJ1(context)
  }

  override def toTurnoJ2(): Unit = {
    context.state = new TurnoJ2(context)
  }
}
