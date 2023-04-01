package cl.uchile.dcc
import gwent.Jugador


class JugadorTest extends munit.FunSuite {
  var Jugador1: Jugador = _
  var Jugador2: Jugador = _
  var Jugador3: Jugador = _

  override def beforeEach(context: BeforeEach): Unit = {
    Jugador1 = Jugador("Jugador 1")
    Jugador2 = Jugador("Jugador 2")
    Jugador3 = Jugador()
  }

  test("Un jugador debe tener nombre"){
    assertEquals(Jugador1.nombre, expected = "Jugador 1")
    assertEquals(Jugador2.nombre, expected = "Jugador 2")
    assertEquals(Jugador3.nombre)
  }

}
