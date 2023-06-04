package cl.uchile.dcc
package gwent.GameController

import gwent.GameController.states.InicioRonda

class GameController {
  var state = new InicioRonda(this)
}
