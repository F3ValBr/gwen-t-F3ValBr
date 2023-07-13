package cl.uchile.dcc
package gwent.GameController

import gwent.GameController.states.{FinJuego, InicioRonda, J1GanaJuego, J2GanaJuego}
import gwent.GameController.observer.{Observer, Subject, WinCondition}
import gwent.jugadores.{Jugador, JugadorCPU, JugadorP1}

/**
  * Clase que representa el controlador del juego
  * @param jugador1 Jugador 1 (Humano)
  * @param jugador2 Jugador 2 (CPU)
  * @param state Estado actual del juego
  *
  * El controlador es el encargado de manejar el flujo del juego, es decir, de cambiar de estado
  */
class GameController extends Observer[WinCondition] {
  private var jugador1: JugadorP1 = _
  private var jugador2: JugadorCPU = _

  var state: GameState = new InicioRonda(this)

  /**
    * Inicia el juego con los nombres de los jugadores
    * @param jugador_n Nombre del jugador 1
    * @param cpu_n Nombre del jugador 2
    * Se crea un jugador humano y un jugador CPU
    */
  def startGame(jugador_n: String = "J1", cpu_n: String = "CPU"): Unit = {
    jugador1 = addJugador(jugador_n)
    jugador2 = addCPU(cpu_n)
  }

  /**
   * Agrega un jugador humano al juego
   * @param name Nombre del jugador
   * @return Jugador humano
   * Se crea un jugador humano y se agrega como observador del controlador
   */
  private def addJugador(name: String): JugadorP1 = {
    val player = new JugadorP1(name)
    player.addObserver(this)
    player
  }

  /**
   * Agrega un jugador CPU al juego
   * @param name Nombre del jugador
   * @return Jugador CPU
   * Se crea un jugador CPU y se agrega como observador del controlador
   */
  private def addCPU(name: String): JugadorCPU = {
    val player = new JugadorCPU(name)
    player.addObserver(this)
    player
  }

  /**
   * Actualiza el estado del juego cuando un jugador queda sin cartas
   * @param subject Jugador que quedó sin cartas
   * @param value Condición de victoria
   *
   * Si el jugador 1 queda sin cartas, el jugador 2 gana el juego
   * Si el jugador 2 queda sin cartas, el jugador 1 gana el juego
   */
  override def update(subject: Subject[WinCondition], value: WinCondition): Unit = {
    println(s"Jugador ${subject.getClass.getSimpleName} ha perdido el juego por quedar sin ${value.name}")
    if (jugador1.getgems() == 0){
      println(s"Jugador ${jugador2.getname()} ha ganado el juego")
      state = new J2GanaJuego(this)
    } else if (jugador2.getgems() == 0) {
      println(s"Jugador ${jugador1.getname()} ha ganado el juego")
      state = new J1GanaJuego(this)
    }
  }

  // Metodos para quitar gemas a los jugadores de acuerdo a quien gano la ronda
  /**
   * Método que quita una gema a J1
   */
  def elim_gem_j1(): Unit = jugador1.del_gems()
  /**
   * Método que quita una gema a J2
   */
  def elim_gem_j2(): Unit = jugador2.del_gems()

  /**
   * Metodo que cambia a estado InicioRonda
   */
  def toInicioRonda(): Unit = state.toInicioRonda()
  /**
   * Metodo que cambia a estado TurnoJ1
   */
  def toTurnoJ1(): Unit = state.toTurnoJ1()
  /**
   * Metodo que cambia a estado TurnoJ2
   */
  def toTurnoJ2(): Unit = state.toTurnoJ2()
  /**
   * Metodo que cambia a estado PasarTurnoJ1 o PasarTurnoJ2 dependiendo de quien sea el turno
   */
  def pasarTurno(): Unit = state.pasarTurno()
  /**
   * Metodo que cambia a estado SelectCarta
   */
  def toSelectCarta(): Unit = state.toSelectCarta()
  /**
   * Metodo que cambia a estado JugarCarta
   */
  def jugarCarta(): Unit = state.jugarCarta()
  /**
   * Metodo que cambia a estado FinRonda
   */
  def toFinRonda(): Unit = state.toFinRonda()
  /**
   * Metodo que cambia a estado J1GanaRonda
   */
  def toJ1GanaRonda(): Unit = state.toJ1GanaRonda()
  /**
   * Metodo que cambia a estado J2GanaRonda
   */
  def toJ2GanaRonda(): Unit = state.toJ2GanaRonda()
  /**
   * Metodo que cambia a estado Empate
   */
  def toEmpate(): Unit = state.toEmpate()
  /**
   * Metodo que cambia a estado J1GanaJuego
   */
  def toJ1GanaJuego(): Unit = state.toJ1GanaJuego()
  /**
   * Metodo que cambia a estado J2GanaJuego
   */
  def toJ2GanaJuego(): Unit = state.toJ2GanaJuego()
  /**
   * Metodo que cambia a estado FinJuego
   */
  def toFinJuego(): Unit = state.toFinJuego()

  
  // Metodos para obtener el estado del juego
  /**
   * Metodo que retorna el valor contenido en la variable state relacionada a TurnoJ1
   */
  def isTurnoJ1(): Boolean = state.isTurnoJ1()
  /**
   * Metodo que retorna el valor contenido en la variable state relacionada a TurnoJ2
   */
  def isTurnoJ2(): Boolean = state.isTurnoJ2()
  /**
   * Metodo que retorna el valor contenido en la variable state relacionada a pasoTurnoJ1
   */
  def pasoTurnoJ1(): Boolean = state.pasoTurnoJ1()
  /**
   * Metodo que retorna el valor contenido en la variable state relacionada a pasoTurnoJ2
   */
  def pasoTurnoJ2(): Boolean = state.pasoTurnoJ2()
  /**
   * Metodo que retorna el valor contenido en la variable state relacionada a ganoRondaJ1
   */
  def ganoRondaJ1(): Boolean = state.ganoRondaJ1()
  /**
   * Metodo que retorna el valor contenido en la variable state relacionada a ganoRondaJ2
   */
  def ganoRondaJ2(): Boolean = state.ganoRondaJ2()
  /**
   * Metodo que retorna el valor contenido en la variable state relacionada a empate
   */
  def isEmpate(): Boolean = state.isEmpate()
  /**
   * Metodo que retorna el valor contenido en la variable state relacionada a ganoJuegoJ1
   */
  def ganoJuegoJ1(): Boolean = state.ganoJuegoJ1()
  /**
   * Metodo que retorna el valor contenido en la variable state relacionada a ganoJuegoJ2
   */
  def ganoJuegoJ2(): Boolean = state.ganoJuegoJ2()
  /**
   * Metodo que retorna el valor contenido en la variable state relacionada a finJuego
   */
  def isFinJuego(): Boolean = state.isFinJuego()
  /**
   * Metodo que retorna el valor contenido en la variable state relacionada a tieneGemasJ1
   */
  def tieneGemasJ1(): Boolean = state.tieneGemasJ1()
  /**
   * Metodo que retorna el valor contenido en la variable state relacionada a tieneGemasJ2
   */
  def tieneGemasJ2(): Boolean = state.tieneGemasJ2()
}
