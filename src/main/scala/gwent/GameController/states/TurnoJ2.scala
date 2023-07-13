package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

/**
  * Estado que representa el turno del jugador 2
  * @param context contexto del controlador del juego
  */
class TurnoJ2(context: GameController) extends GameState(context) {
  override def isTurnoJ2(): Boolean = true

  override def pasarTurno(): Unit = {
    context.state = new TurnoJ2(context)
  }

  override def jugarCarta(): Unit = {
    context.state = new SelectCarta(context)
  }
  
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
