package cl.uchile.dcc
package gwent.cartas

import gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}
import gwent.cartas.cartaclima.{CartaClimaDespejado, CartaEscarchaMordiente, CartaLluviaTorrencial, CartaNieblaImpenetrable}

import java.util.Objects
import scala.collection.mutable.ListBuffer

/** Clase que representa un deck de cartas
 *
 * Deck es una clase abstracta que representa un deck de cartas
 * @param _deck lista de cartas que contiene el deck
 *              por defecto se crea un deck con todas las cartas
 *              del juego, 25 en total:
 *              (6 cartas de asedio, 6 cartas cuerpo a cuerpo,
 *              6 cartas de distancia, 2 cartas de niebla,
 *              2 cartas de lluvia, 2 cartas de escarcha,
 *              1 carta de clima despejado)
 */
class DeckClass(var _deck: ListBuffer[Carta]) extends Deck with Equals {

  // constructor por defecto, crea un deck con todas las cartas
  def this() =
    this(ListBuffer(new CartaAsedio("1", 1),
      new CartaAsedio("2", 2, Some("Refuerzo Moral")),
      new CartaAsedio("3", 3),
      new CartaAsedio("4", 4, Some("Vinculo Estrecho")),
      new CartaAsedio("5", 5),
      new CartaAsedio("6", 6),
      new CartaCuerpoACuerpo("1", 1),
      new CartaCuerpoACuerpo("2", 2, Some("Vinculo Estrecho")),
      new CartaCuerpoACuerpo("3", 3),
      new CartaCuerpoACuerpo("4", 4, Some("Vinculo Estrecho")),
      new CartaCuerpoACuerpo("5", 5),
      new CartaCuerpoACuerpo("6", 6),
      new CartaDistancia("1", 1),
      new CartaDistancia("2", 2),
      new CartaDistancia("3", 3, Some("Refuerzo Moral")),
      new CartaDistancia("4", 4),
      new CartaDistancia("5", 5),
      new CartaDistancia("6", 6, Some("Refuerzo Moral")),
      new CartaEscarchaMordiente("1"),
      new CartaEscarchaMordiente("2"),
      new CartaNieblaImpenetrable("3"),
      new CartaNieblaImpenetrable("4"),
      new CartaLluviaTorrencial("5"),
      new CartaLluviaTorrencial("6"),
      new CartaClimaDespejado("7")))


  /** isValidDeck retorna true si el deck es valido
   * 
   * @return true si el deck es valido, false en caso contrario
   */
  override def isValidDeck(): Boolean = {
    if (_deck.size == 25 && _deck.distinct.size == _deck.size) true
    else false
  }

  /** cant_cards retorna la cantidad de cartas en el deck
   * 
   * @return cantidad de cartas en el deck
   */
  override def cant_cards(): Int = _deck.length

  /** shuffle_deck mezcla el deck de cartas
   */
  override def shuffle_deck(): Unit = {
    _deck = scala.util.Random.shuffle(_deck)
  }

  /** draw_card saca una carta del deck
   * 
   * @return carta sacada del deck
   */
  override def draw_card(): Carta = {
    val carta = _deck.head
    _deck = _deck.tail
    carta
  }

  /** add_card agrega una carta al deck
   * 
   * @param card carta a agregar al deck
   */
  override def add_card(card: Carta): Unit = {
    _deck = _deck :+ card
  }

  /** remove_card elimina una carta del deck
   * 
   * @param card carta a eliminar del deck
   */
  override def remove_card(card: Carta): Unit = {
    _deck = _deck.filter(_ != card)
  }

  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[DeckClass]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[DeckClass]
      _deck == other._deck
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[DeckClass], _deck)
  }
}
