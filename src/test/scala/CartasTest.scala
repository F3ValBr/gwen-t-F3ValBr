package cl.uchile.dcc
import gwent.Cartas

class CartasTest extends munit.FunSuite {
  var carta1: Cartas = _
  var carta2: Cartas = _

  override def beforeEach(context: BeforeEach): Unit = {
    carta1 = Cartas()
    carta2 = Cartas()
  }

  test("Una carta tiene un tipo especifico"){

  }
  test("Una carta tiene una clasificacion en particular"){

  }
  test("Una carta tiene un valor de fuerza"){

  }
  test("Las cartas climaticas tienen un clima en especifico"){

  }
  test("Las cartas de unidad tienen una o ninguna habilidad en especial")
}
