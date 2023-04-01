package cl.uchile.dcc
import gwent.Jugador


class JugadorTest extends munit.FunSuite {
  var Jugador1: Jugador = _
  var Jugador2: Jugador = _
  var Jugador3: Jugador = _

  override def beforeEach(context: BeforeEach): Unit = {
    Jugador1 = Jugador("Jugador 1",1,3)
    Jugador2 = Jugador("Jugador 2",2,3)
    //Jugador3 = Jugador()
  }

  test("Un jugador debe tener nombre"){
    assertEquals(Jugador1.nombre, expected = "Jugador 1") // Jugador 1 corresponde a su nombre
    assertEquals(Jugador2.nombre, expected = "Jugador 2") // Jugador 2 corresponde
    assert(!Jugador1.nombre.equals(Jugador2.nombre))      // Jugadores con distintos nombres son distintos
  }

  test("El jugador tiene una seccion en el tablero"){
    assertEquals(Jugador2.seccion,Jugador2.seccion)
    assertEquals(Jugador1.seccion, expected = 1)
    assert(!Jugador1.seccion.equals(Jugador2.seccion)) // Dos jugadores no pueden tener la misma posicion
  }
  test("El jugador tiene una cantidad de gemas"){
    assertEquals(Jugador1.gemas, expected = 3)
    assert(Jugador1.gemas > (new Jugador("J5",5,2)).gemas,"1 tiene menos gemas que el jugador nuevo") // las gemas de 1 son mas que las de 2
  }
  test("Jugador tiene un mazo de cartas"){
    //assert()
  }
  /**test("Jugador tiene su propia mano de cartas"){

  }*/
  test("Un jugador tiene todos sus atributos definidos"){
    assertEquals(new Jugador("Jugador4",4,2),new Jugador("Jugador4",4,2)) // Crear un nuevo jugador sigue igual a crear el mismo
  }
}
