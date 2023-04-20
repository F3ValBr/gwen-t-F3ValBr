package cl.uchile.dcc
package gwent.cartas

import scala.collection.mutable.ListBuffer

/**
 * Deck es un conjunto de cartas que se pueden mezclar, sacar y agregar cartas.
 * @param deck es una lista de cartas que representa el deck.
 *
 * Se define un trait Deck que contiene los siguientes métodos:
 * isValidDeck verifica que el deck sea válido.
 * cant_cards retorna la cantidad de cartas en el deck.
 * shuffle_deck mezcla el deck.
 * draw_card saca una carta del deck.
 * add_card agrega una carta al deck.
 * remove_card elimina una carta del deck.
 */
trait Deck {
  var _deck: ListBuffer[Carta]

  // isValidDeck verifica que el deck sea válido
  def isValidDeck(): Boolean

  // cant_cards retorna la cantidad de cartas en el deck
  def cant_cards(): Int

  // shuffle_deck mezcla el deck
  def shuffle_deck(): Unit

  // draw_card saca una carta del deck
  def draw_card(): Carta

  // add_card agrega una carta al deck
  def add_card(card: Carta): Unit

  // remove_card elimina una carta del deck
  def remove_card(card: Carta): Unit
}
