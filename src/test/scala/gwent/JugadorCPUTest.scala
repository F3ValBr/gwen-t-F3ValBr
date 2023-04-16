package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.jugadores.{JugadorCPU, JugadorP1}
import munit.FunSuite

class JugadorCPUTest extends FunSuite{
  var JugadorPC: JugadorCPU = _
  var JugadorIA: JugadorCPU = _
  var JugadorMQ: JugadorCPU = _

  override def beforeEach(context: BeforeEach): Unit = {
    JugadorPC = new JugadorCPU("Computador")
    JugadorIA = new JugadorCPU("Inteligencia Artifical")
    JugadorMQ = new JugadorCPU("X", 0, 0, 0)
  }

  test("Un jugador tiene un nombre") {
    assertEquals(JugadorPC.name, expected = "Computador") // Un jugador tiene un nombre dado
    assert(!JugadorPC.name.equals(JugadorIA.name)) // Jugadores con nombres distintos
  }
  test("El jugador tiene una cantidad de gemas") {
    assertEquals(JugadorIA.gems, expected = 2) // el jugador 1 tiene 3 gemas
    assert(JugadorIA.gems > (new JugadorCPU("J5", 5, 1)).gems, "JugadorIA tiene menos gemas que el jugador nuevo") // las gemas de 1 son mas que las de 2
  }
  test("Jugador tiene un mazo de cartas") {
    assertEquals(JugadorPC.deck, expected = 25) // El jugador parte con 25 cartas en su mazo
    JugadorPC.first_take()
    assertEquals(JugadorPC.deck, expected = 15) // El J2 saca 10 cartas iniciales, quedando 15 en su mazo
    JugadorPC.del_hand(5)
    JugadorPC.take_cards_deck()
    JugadorPC.take_cards_deck()
    assertEquals(JugadorPC.deck, expected = 10) // El J2 saca 5 cartas del mazo, quedando 10
    JugadorMQ.take_cards_deck()
    assertEquals(JugadorMQ.deck, expected = 0) // J3 no puede tomar cartas de un mazo vacio
  }
  test("Jugador tiene su propia mano de cartas") {
    assertEquals(JugadorPC.hand, expected = 0)
    JugadorPC.first_take()
    assertEquals(JugadorPC.hand, expected = 10) // el J1 toma 10 cartas
    JugadorMQ.first_take()
    assertEquals(JugadorMQ.hand, expected = 0) // J3 no puede tener una mano si su mazo esta vacio
  }
  test("Un jugador tiene todos sus atributos definidos") {
    assertEquals(new JugadorP1("JugadorDFA", 4), new JugadorP1("JugadorDFA", 4))
    // Crear un nuevo jugador sigue igual a crear el mismo
  }
  test("El jugador puede perder gemas") {
    JugadorPC.del_gems() // quitar 1 gema, queda 1
    assertEquals(JugadorPC.gems, expected = 1)
    JugadorPC.del_gems() // quitar 1 gema, quedan 0
    JugadorPC.del_gems() // quitar otra gema, debe seguir en 0
    assertEquals(JugadorPC.gems, expected = 0)
  }

}
