package cl.uchile.dcc
import gwent.Cartas

class CartasTest extends munit.FunSuite {
  var carta1: Cartas = _
  var carta2: Cartas = _
  var carta3: Cartas = _

  val as = "Asedio"
  val cc = "Cuerpo a cuerpo"
  val di = "Distancia"

  val un = "Unidad"
  val cl = "Clima"

  override def beforeEach(context: BeforeEach): Unit = {
    carta1 = Cartas(un)
    carta2 = Cartas(cl)

  }

  test("Una carta tiene un tipo especifico"){
    assertEquals(carta1.tipo, expected = "Unidad")  // una carta tiene un tipo
    assert(!carta1.tipo.equals(carta2.tipo))        // dos cartas pueden tener tipos diferentes
    assertEquals(carta1.tipo, carta1.tipo)          // una carta comparada consigo misma
    assertEquals(carta2.tipo, (new Cartas("Clima")).tipo) // generar una carta con el mismo tipo de otra
  }
  test("Una carta tiene una clasificacion en particular"){

  }
  /**test("Una carta tiene un valor de fuerza"){

  }
  test("Las cartas climaticas tienen un clima en especifico"){

  }
  test("Las cartas de unidad tienen una o ninguna habilidad en especial")*/
}
