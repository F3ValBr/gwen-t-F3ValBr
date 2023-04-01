package cl.uchile.dcc
import gwent.Jugador


class JugadorTest extends munit.FunSuite {
  var Jugador1: Jugador = _
  var Jugador2: Jugador = _
  var Jugador3: Jugador = _

  override def beforeEach(context: BeforeEach): Unit = {
    Jugador1 = Jugador("Jugador 1")
    Jugador2 = Jugador("Jugador 2")
    //Jugador3 = Jugador()
  }

  test("Un jugador debe tener nombre"){
    assertEquals(Jugador1.nombre, expected = "Jugador 1") // Jugador 1 corresponde a su nombre
    assertEquals(Jugador2.nombre, expected = "Jugador 2") // Jugador 2 corresponde
    assert(!Jugador1.nombre.equals(Jugador2.nombre))      // Jugadores con distintos nombres son distintos
    assertEquals(new Jugador("Jugador4"),new Jugador("Jugador4")) // Crear un nuevo jugador sigue igual a crear el mismo
  }

  test("El jugador tiene una seccion en el tablero"){


  }
}
