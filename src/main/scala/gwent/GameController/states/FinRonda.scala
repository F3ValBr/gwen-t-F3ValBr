package cl.uchile.dcc
package gwent.GameController.states

import gwent.GameController.{GameController, GameState}

/**
  * Estado que representa el fin de una ronda.
  * @param context el controlador del juego.
  */
class FinRonda(context: GameController) extends GameState(context) {
  override def toJ1GanaRonda(): Unit = {
    context.state = new J1GanaRonda(context)
    context.elim_gem_j2()
  }

  override def toJ2GanaRonda(): Unit = {
    context.state = new J2GanaRonda(context)
    context.elim_gem_j1()
  }

  override def toEmpate(): Unit = {
    context.state = new Empate(context)
    context.elim_gem_j1()
    context.elim_gem_j2()
  }
  
}
