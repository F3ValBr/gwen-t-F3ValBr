package cl.uchile.dcc
package gwent

import munit.FunSuite
import gwent.cartas.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}

class CartaUnidadTest extends FunSuite{
  var cartacac: CartaCuerpoACuerpo = _
  var cartaase: CartaAsedio = _
  var cartadis: CartaDistancia = _

  val rm = "Refuerzo Moral"
  val ve = "Vinculo Estrecho"

  val namex = "Asedio 1"
  val strengthx = 10

  override def beforeEach(context: BeforeEach): Unit = {
    cartacac = new CartaCuerpoACuerpo("Cuerpo a Cuerpo 1", 5, Some(ve))
    cartaase = new CartaAsedio("Asedio 1", 10)
    cartadis = new CartaDistancia("Distancia 1", 3, Some(rm))
  }

  test("Se puede crear una carta de unidad con sus atributos"){
    assertEquals(new CartaAsedio(namex,strengthx),cartaase)
  }
  test("El hashcode de una carta de unidad es consistente con Equals"){
    assertEquals(new CartaAsedio(namex,strengthx).##, cartaase.##)
  }
  test("Una carta de unidad tiene un nombre, distinto al de otras cartas"){
    assertEquals(cartacac._name, expected = "Cuerpo a Cuerpo 1")
    val cartadis2 = new CartaDistancia("Distancia 2", 4)
    assert(!cartadis._name.equals(cartadis2._name))
  }
  test("Una carta de unidad tiene un valor de fuerza, el cual puede ser distinto al de otras cartas"){
    assertEquals(cartaase._strength, expected = 10)
    assert(!cartadis._strength.equals(cartacac._strength))
  }
  test("Hay cartas con habilidad definida como hay cartas sin habilidad"){
    assertEquals(cartaase._ability, expected = None)
    assertEquals(cartadis._ability, expected = Some(rm))
    assert(!cartadis._ability.equals(cartacac._ability))
  }
  test("Las cartas con habilidad modifican la fuerza de otras cartas"){
    val cartacac2 = new CartaCuerpoACuerpo("CAC 2", 4, Some(rm))
    cartacac.pow_strength(cartacac2)
    assertEquals(cartacac2._strength, expected = 8)
    cartacac2.pow_strength(cartacac)
    assertEquals(cartacac._strength, expected = 6)
    val cartaase2 = new CartaAsedio("Asedio 2", 6)
    cartaase2.pow_strength(cartaase)
    assertEquals(cartaase._strength, expected = 10)
  }

}
