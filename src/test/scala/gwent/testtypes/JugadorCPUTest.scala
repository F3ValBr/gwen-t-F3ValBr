package cl.uchile.dcc
package gwent.testtypes

import gwent.cartas
import gwent.cartas.cartaclima.{CartaClimaDespejado, CartaEscarchaMordiente, CartaLluviaTorrencial, CartaNieblaImpenetrable}
import gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}
import gwent.cartas.{Carta, Deck, DeckClass}
import gwent.jugadores.{JugadorCPU, JugadorP1}

import munit.FunSuite

import scala.collection.mutable.ListBuffer

class JugadorCPUTest extends FunSuite {
  var JugadorPC: JugadorCPU = _
  var JugadorIA: JugadorCPU = _
  var JugadorMQ: JugadorCPU = _
  var JugadorY: JugadorCPU = _

  val rm = "Refuerzo Moral"
  val ve = "Vinculo Estrecho"

  override def beforeEach(context: BeforeEach): Unit = {
    JugadorPC = new JugadorCPU("Computador")
    JugadorIA = new JugadorCPU("Inteligencia Artifical")
    JugadorMQ = new JugadorCPU("X", 0, 1, 0, DeckClass(ListBuffer(CartaAsedio("1", 1))))
    JugadorY = new JugadorCPU("", 0, 1, 0, DeckClass(ListBuffer(CartaAsedio("1", 1))))
  }

  test("Un jugador tiene un nombre valido"){
    assert(JugadorPC.isValidName())
    assert(!JugadorY.isValidName())
  }
  test("Un jugador tiene una cantidad de gemas valida"){
    assert(JugadorPC.isValidGems())
    assert(!JugadorMQ.isValidGems())
  }
  test("Dos jugadores pueden ser distintos"){
    assert(!JugadorPC.equals(JugadorIA))
    assert(new JugadorCPU("Computador").equals(JugadorPC))
  }
  test("Un jugador tiene un nombre") {
    assertEquals(JugadorPC.getname(), expected = "Computador") // Un jugador tiene un nombre dado
    assert(!JugadorPC.getname().equals(JugadorIA.getname())) // Jugadores con nombres distintos
    assert(JugadorPC.getname().equals(JugadorPC.getname())) // Jugadores con nombres iguales
    assertNotEquals(JugadorPC.getname(), JugadorIA.getname()) // Un jugador tiene un nombre dado
  }
  test("El jugador tiene una cantidad de gemas") {
    assertEquals(JugadorIA.getgems(), expected = 2) // el jugadorIA tiene 2 gemas
    assert(JugadorIA.getgems() < new JugadorCPU("J5", 5, 1).gems, "JugadorIA tiene menos gemas que el jugador nuevo") // las gemas de 1 son mas que las de 2
  }
  test("Jugador tiene un mazo de cartas") {
    // El jugadorPC parte con 25 cartas en su mazo
    assertEquals(JugadorPC.getdeck().cant_cards(), expected = 25)
    assertEquals(JugadorPC.decknum, expected = 25)

    JugadorPC.first_take()
    // El JPC saca 10 cartas iniciales, quedando 15 en su mazo
    assertEquals(JugadorPC.decknum, expected = 15)
    assertEquals(JugadorPC.getdeck().cant_cards(), expected = 15)
    assertEquals(JugadorPC.gethand().length, expected = 10)
    assertEquals(JugadorPC.handnum, JugadorPC.gethand().length)

    JugadorPC.del_hand(5)
    JugadorPC.take_cards_deck()
    JugadorPC.take_cards_deck()
    // El J2 saca 5 cartas de su mano, luego toma cartas hasta tener 10 en su mano, quedando 10 en su mazo
    assertEquals(JugadorPC.decknum, expected = 10)
    assertEquals(JugadorPC.getdeck().cant_cards(), expected = 10)
    assertEquals(JugadorPC.gethand().length, expected = 10)
    assertEquals(JugadorPC.handnum, JugadorPC.gethand().length)

  }
  test("Verifica que un jugador tiene un deck invalido") {
    // al tener un deck invalido, el jugador no puede tomar cartas de su mazo, ni tener una mano
    assert(!JugadorMQ.deck_list.isValidDeck())
    assert(JugadorPC.deck_list.isValidDeck())
    assert(JugadorIA.deck_list.isValidDeck())
  }
  test("Jugador tiene su propia mano de cartas") {
    assertEquals(JugadorPC.handnum, expected = 0)
    assertEquals(JugadorPC.gethand().length, expected = 0)
    JugadorPC.first_take()
    // el J1 toma 10 cartas iniciales
    assertEquals(JugadorPC.handnum, expected = 10)
    assertEquals(JugadorPC.gethand().length, expected = 10)
  }
  test("Un jugador tiene todos sus atributos definidos") {
    assertEquals(new JugadorP1("JugadorDFA", 4), new JugadorP1("JugadorDFA", 4))
    // Crear un nuevo jugador sigue igual a crear el mismo
  }
  test("El jugador puede perder gemas") {
    JugadorPC.del_gems() // quitar 1 gema, queda 1
    assertEquals(JugadorPC.getgems(), expected = 1)
    JugadorPC.del_gems() // quitar 1 gema, quedan 0
    JugadorPC.del_gems() // quitar otra gema, debe seguir en 0
    assertEquals(JugadorPC.getgems(), expected = 0)
  }
  test("El hashcode de un jugador es consistente con Equals") {
    assertEquals(new JugadorCPU("Computador").##, JugadorPC.##)
    assert(!new JugadorCPU("Computador").##.equals(JugadorIA.##))
  }
}