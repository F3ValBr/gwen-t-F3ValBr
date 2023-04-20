package cl.uchile.dcc
package gwent.jugadores

import gwent.cartas.{Carta, DeckClass}
import scala.collection.mutable.ListBuffer

/** Clase jugador representa al jugador o jugadores en una partida de gwent
 *
 * @constructor Jugador se define por su nombre, su cantidad de gemas (en representacion a su vida), 
 * mazo de cartas a su disposicion y la mano de cartas con la cual juega
 * 
 * Adicionalmente, se definen los metodos:
 * del_gems como el metodo que quita gemas a un jugador
 * first_take como la primera toma de cartas de un jugador
 * del_hand como el metodo para quitar cartas de una mano
 * take_cards_deck como el metodo para obtener cartas desde el mazo 
 * @param name Nombre del jugador
 * @param gems cantidad de vida en juego
 * @param decknum nro de cartas disponibles a robar
 * @param handnum nro de cartas disponibles a jugar
 * @param deck_list lista de cartas disponibles a robar
 * @param hand_list lista de cartas disponibles a jugar
 *                  
 * @author Felipe Valdebenito Bravo
 * @version 1.0
 * @since 1.0
 * */
trait Jugador {
  val name: String
  var gems: Int
  var decknum: Int
  var handnum: Int
  var deck_list: DeckClass
  var hand_list: ListBuffer[Carta]

  def isValidName(): Boolean
  def del_gems(): Unit

  def first_take(): Unit

  def del_hand(cards_take: Int): Unit

  def take_cards_deck(): Unit
}
