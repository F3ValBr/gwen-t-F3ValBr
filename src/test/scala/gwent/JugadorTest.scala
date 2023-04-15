package cl.uchile.dcc
package gwent

import gwent.Jugador

/**
class JugadorTest extends munit.FunSuite {
  var Jugador1: Jugador = _
  var Jugador2: Jugador = _
  var Jugador3: Jugador = _

  override def beforeEach(context: BeforeEach): Unit = {
    Jugador1 = JugadorP1("Jugador 1")
    Jugador2 = JugadorCPU("Jugador 2")
    //Jugador3 = Jugador("",0,0,0,0)
  }

  test("Un jugador debe tener nombre"){
    assertEquals(Jugador1.nombre, expected = "Jugador 1") // Jugador 1 corresponde a su nombre
    assertEquals(Jugador2.nombre, expected = "Jugador 2") // Jugador 2 corresponde
    assert(!Jugador1.nombre.equals(Jugador2.nombre))      // Jugadores con distintos nombres son distintos
    //assert()
  }

  test("El jugador tiene una seccion en el tablero"){
    assertEquals(Jugador2.seccion,Jugador2.seccion)     // El jugador 2 si esta en su posicion correspondiente
    assertEquals(Jugador1.seccion, expected = 1)        // El jugador 1 esta en la posicion 1
    assert(!Jugador1.seccion.equals(Jugador2.seccion))  // Dos jugadores no pueden tener la misma posicion
  }
  test("El jugador tiene una cantidad de gemas"){
    assertEquals(Jugador1.gemas, expected = 2)          // el jugador 1 tiene 3 gemas
    assert(Jugador1.gemas > (new Jugador("J5",5,1)).gemas,"1 tiene menos gemas que el jugador nuevo") // las gemas de 1 son mas que las de 2
  }
  test("Jugador tiene un mazo de cartas"){
    assertEquals(Jugador2.mazo, expected = 25)  // El jugador parte con 25 cartas en su mazo
    Jugador2.prim_toma()
    assertEquals(Jugador2.mazo, expected = 15)  // El J2 saca 10 cartas iniciales, quedando 15 en su mazo
    Jugador2.descontar_mano(5)
    Jugador2.tomar_cartas_mazo()
    Jugador2.tomar_cartas_mazo()
    assertEquals(Jugador2.mazo, expected = 10)  // El J2 saca 5 cartas del mazo, quedando 10
    Jugador3.tomar_cartas_mazo()
    assertEquals(Jugador3.mazo, expected = 0)   // J3 no puede tomar cartas de un mazo vacio
  }
  test("Jugador tiene su propia mano de cartas"){
    assertEquals(Jugador1.mano, expected = 0)
    Jugador1.prim_toma()
    assertEquals(Jugador1.mano, expected = 10)  // el J1 toma 10 cartas
    Jugador3.prim_toma()
    assertEquals(Jugador3.mano, expected = 0)   // J3 no puede tener una mano si su mazo esta vacio
  }
  test("Un jugador tiene todos sus atributos definidos"){
    assertEquals(new Jugador("Jugador4",4),new Jugador("Jugador4",4))
    // Crear un nuevo jugador sigue igual a crear el mismo
  }
  test("El jugador puede perder gemas"){
    Jugador1.del_gems()                      // quitar 1 gema, queda 1
    assertEquals(Jugador1.gems, expected = 1)
    Jugador1.del_gems()                      // quitar 1 gema, quedan 0
    Jugador1.del_gems()                      // quitar otra gema, debe seguir en 0
    assertEquals(Jugador1.gems, expected = 0)
  }
}*/
