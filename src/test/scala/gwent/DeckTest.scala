package cl.uchile.dcc
package gwent

import gwent.cartas.{Carta, DeckClass}

import munit.FunSuite

import scala.collection.mutable.ListBuffer

/**
  * Test de la clase DeckClass
  * @author Felipe Valdebenito Bravo
  */
class DeckTest extends FunSuite{
  var deck1: DeckClass = _

  override def beforeEach(context: BeforeEach): Unit = {
    deck1 = new DeckClass()
  }

  test("Deck tiene 25 cartas"){
    assertEquals(deck1.cant_cards(), 25)
  }
  test("Se le puede quitar una cantidad de cartas a deck"){
    for (i <- 1 to 5) deck1.draw_card()
    assertEquals(deck1.cant_cards(), 20)
  }
  test("Se le puede agregar una cantidad de cartas a deck"){
    val almacen_cards: ListBuffer[Carta] = ListBuffer()
    for (i <- 0 to 4) { almacen_cards += deck1.draw_card()}
    assertEquals(deck1.cant_cards(), 20)
    for (i <- 0 to 4) deck1.add_card(almacen_cards(i))
    assertEquals(deck1.cant_cards(), 25)
  }
  test("Se pueden mezclar las cartas en un deck"){
    val deck2: DeckClass = new DeckClass()
    assertEquals(deck1._deck, deck2._deck)
    deck1.shuffle_deck()
    assertNotEquals(deck1._deck, deck2._deck)
  }
  test("Se puede obtener una carta de un deck"){
    val carta: Carta = deck1.draw_card()
    assertEquals(deck1.cant_cards(), 24)
    assertEquals(deck1._deck.contains(carta), false)
  }
}
