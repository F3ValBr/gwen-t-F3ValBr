package cl.uchile.dcc
package gwent

/** Clase jugador representa al jugador o jugadores en una partida de gwent
 *
 * Jugador se define por su nombre, su seccion en el tablero, su cantidad de gemas
 * inicialmente es 2 (en representacion a su vida), mazo de cartas a su disposicion
 * y la mano de cartas con la cual juega
 *
 * @param name Nombre del jugador
 * @param gems cantidad de vida en juego
 * @param deck cartas disponibles a robar
 * @param hand cartas disponibles a jugar
 * @author Felipe Valdebenito Bravo
 * */
trait Jugador {
  val name: String
  var gems: Int
  var deck: Int
  var hand: Int

  def del_gems(): Unit

  def first_take(): Unit

  def del_hand(cards_take: Int): Unit

  def take_cards_deck(): Unit
}
