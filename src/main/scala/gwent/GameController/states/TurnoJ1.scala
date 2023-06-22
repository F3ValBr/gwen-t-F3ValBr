package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

class TurnoJ1(context: GameController) extends GameState(context) {
  override def isTurnoJ1(): Boolean = true

  override def pasarTurno(): Unit = {
    context.state = new TurnoJ2(context)
  }

  override def jugarCarta(): Unit = {
    context.state = new SelectCarta(context)
  }
  override def toTurnoJ2(): Unit = {
    context.state = new TurnoJ2(context)
  }

  override def toSelectCarta(): Unit = {
    context.state = new SelectCarta(context)
  }

  override def toFinRonda(): Unit = {
    context.state = new FinRonda(context)
  }
}
