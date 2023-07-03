package cl.uchile.dcc
package gwent.jugadores

import gwent.cartas.{Carta, DeckClass}

import cl.uchile.dcc.gwent.GameController.observer.{AbstractSubject, WinCondition}

import scala.collection.mutable.ListBuffer

/** Una clase abstracta AbstractJugador, extiende a Jugador
 *
 * @constructor AbstractJugador cre un jugador con un nombre, una cantidad de gemas, un mazo y una mano de cartas
 *              con las cuales puede jugar, ademas de definir los metodos del_gems, first_take, del_hand y take_cards_deck
 *              definidos mas abajp
 * @param _name Nombre del jugador
 * @param _gems cantidad de vida en juego, representado como cantidad de gemas
 * @param decknum cartas disponibles a robar del mazo
 * @param handnum cartas disponibles a jugar en la mano del jugador
 * @param _deck_list lista de cartas del mazo
 * @param _hand_list lista de cartas en la mano
 */
abstract class AbstractJugador(private val _name: String,
                               private var _gems: Int,
                               var decknum: Int,
                               var handnum: Int,
                               private var _deck_list: DeckClass,
                               private var _hand_list: ListBuffer[Carta])
  extends AbstractSubject[WinCondition] with Jugador {

  // Se asignan nombre y gemas protegidas a las variables publicas
  override val name: String = _name
  var gems: Int = _gems

  var deck_list: DeckClass = _deck_list
  var hand_list: ListBuffer[Carta] = _hand_list.clone()

  override def getname(): String = {
    name
  }
  
  override def getgems(): Int = {
    gems = _gems
    gems
  }
  
  override def getdeck(): DeckClass = {
    deck_list = _deck_list
    deck_list
  }
  
  override def gethand(): ListBuffer[Carta] = {
    hand_list = _hand_list.clone()
    hand_list
  }

  /** isValidName es el metodo para validar el nombre del jugador, el cual debe tener entre 4 y 20 caracteres
   *
   * @return true si el nombre es valido, false si no lo es
   */
  override def isValidName(): Boolean = {
    if (_name.length > 3 && _name.length < 20) true
    else false
  }

  /** isValidGems es el metodo para validar la cantidad de gemas del jugador, la cual debe ser entre 1 y 2
   *
   * @return true si la cantidad de gemas es valida, false si no lo es
   */
  override def isValidGems(): Boolean = {
    if (_gems > 0 && _gems <= 2) true
    else false
  }
  
  /** del_gems es el metodo para borrar gemas de un jugador, borrandolas de a uno */
  override def del_gems(): Unit = {
    if (_gems > 0) {
      _gems -= 1
    }
    if (_gems == 0) {
      notifyObservers(new WinCondition("gemas"))
    }
  }

  /** prim_toma es la asignacion de las primeras 10 cartas por partida */
  override def first_take(): Unit = {
    if (decknum > 0) {
      decknum -= 10
      handnum += 10
      for (i <- 1 to 10) { _hand_list = _hand_list :+ _deck_list.draw_card() }
    }
  }

  /** Metodo auxiliar para sacar cartas de una mano en juego
   *
   * @param cards_take numero de cartas a sacar de la mano
   */
  override def del_hand(cards_take: Int): Unit = {
    handnum -= cards_take
    for (i <- 1 to cards_take) { _hand_list = _hand_list.drop(1) }
  }

  /** tomar_cartas_mazo permite al jugador sacar un numero determinado de cartas y anadirlas a su mano */
  override def take_cards_deck(): Unit = {
    // si hay 1 o mas cartas en el mazo y a lo mas 7 cartas en la mano, se toman 3 cartas del mazo
    if (handnum <= 7 && decknum > 0) {
      decknum -= 3
      handnum += 3
      for (i <- 1 to 3) { _hand_list = _hand_list :+ _deck_list.draw_card() }
    // si hay mas de 7 cartas en la mano, se rellena con lo que reste para llegar a 10
    } else if (handnum > 7 && decknum > 0) {
      val leftover: Int = 10 - handnum
      decknum -= leftover
      handnum += leftover
      for (i <- 1 to leftover) { _hand_list = _hand_list :+ _deck_list.draw_card() }
    }
  }
}
