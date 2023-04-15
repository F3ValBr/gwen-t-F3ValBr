package cl.uchile.dcc
package gwent

import gwent.JugadorP1

import munit.FunSuite

class JugadorP1Test extends FunSuite{
  var JugadorTu: JugadorP1 = _
  var JugadorYo: JugadorP1 = _
  var JugadorX: JugadorP1 = _

  override def beforeEach(context: BeforeEach): Unit = {
    JugadorTu = JugadorP1("Nombre generico")
    JugadorYo = JugadorP1("Nombre especial")
    JugadorX = JugadorP1("X",0,0,0)
  }

  test("Un jugador tiene un nombre"){
    assertEquals(JugadorTu.name, expected = "Nombre generico")  // Un jugador tiene un nombre dado
    assert(!JugadorTu.name.equals(JugadorYo.name))              // Jugadores con nombres distintos
  }
  test("El jugador tiene una cantidad de gemas") {
    assertEquals(JugadorTu.gems, expected = 2) // el jugador 1 tiene 3 gemas
    assert(JugadorTu.gems > (new JugadorP1("J5", 5, 1)).gems, "JugadorTu tiene menos gemas que el jugador nuevo") // las gemas de 1 son mas que las de 2
  }
  test("Jugador tiene un mazo de cartas") {
    assertEquals(JugadorYo.deck, expected = 25) // El jugador parte con 25 cartas en su mazo
    JugadorYo.first_take()
    assertEquals(JugadorYo.deck, expected = 15) // El J2 saca 10 cartas iniciales, quedando 15 en su mazo
    JugadorYo.del_hand(5)
    JugadorYo.take_cards_deck()
    JugadorYo.take_cards_deck()
    assertEquals(JugadorYo.deck, expected = 10) // El J2 saca 5 cartas del mazo, quedando 10
    JugadorX.take_cards_deck()
    assertEquals(JugadorX.deck, expected = 0) // J3 no puede tomar cartas de un mazo vacio
  }
  test("Jugador tiene su propia mano de cartas") {
    assertEquals(JugadorYo.hand, expected = 0)
    JugadorYo.first_take()
    assertEquals(JugadorYo.hand, expected = 10) // el J1 toma 10 cartas
    JugadorX.first_take()
    assertEquals(JugadorX.hand, expected = 0) // J3 no puede tener una mano si su mazo esta vacio
  }
  test("Un jugador tiene todos sus atributos definidos") {
    assertEquals(new JugadorP1("JugadorY", 4), new JugadorP1("JugadorY", 4))
    // Crear un nuevo jugador sigue igual a crear el mismo
  }
  test("El jugador puede perder gemas") {
    JugadorYo.del_gems() // quitar 1 gema, queda 1
    assertEquals(JugadorYo.gems, expected = 1)
    JugadorYo.del_gems() // quitar 1 gema, quedan 0
    JugadorYo.del_gems() // quitar otra gema, debe seguir en 0
    assertEquals(JugadorYo.gems, expected = 0)
  }
}
