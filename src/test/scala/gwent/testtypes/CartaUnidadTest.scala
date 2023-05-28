package cl.uchile.dcc
package gwent.testtypes

import gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}

import gwent.Exceptions.InvalidTypeModStrengthException
import munit.FunSuite

class CartaUnidadTest extends FunSuite{
  var cartacac: CartaCuerpoACuerpo = _
  var cartaase: CartaAsedio = _
  var cartadis: CartaDistancia = _
  var cartaasex: CartaAsedio = _

  val ase = "Asedio"
  val cac = "Cuerpo a Cuerpo"
  val dis = "Distancia"

  val rm = "Refuerzo Moral"
  val ve = "Vinculo Estrecho"

  val namex = "Asedio 1"
  val strengthx = 10

  override def beforeEach(context: BeforeEach): Unit = {
    cartacac = new CartaCuerpoACuerpo("Cuerpo a Cuerpo 1", 5, Some(ve))
    cartaase = new CartaAsedio("Asedio 1", 10)
    cartadis = new CartaDistancia("Distancia 1", 3, Some(rm))
    cartaasex = new CartaAsedio("Asedio X",5,Some(rm))
  }

  test("Se puede crear una carta de unidad con sus atributos"){
    assertEquals(new CartaAsedio(namex,strengthx),cartaase)
  }
  test("Una carta de unidad tiene un rango de parametros que la hace valida"){
    assert(cartaase.validCartaUnidad())
    assert(cartacac.validCartaUnidad())
    assert(cartadis.validCartaUnidad())
    assert(cartaasex.validCartaUnidad())
    assert(!new CartaAsedio("",1).validCartaUnidad())
    assert(!new CartaAsedio("a",16).validCartaUnidad())
  }
  test("El hashcode de una carta de unidad es consistente con Equals"){
    assertEquals(new CartaAsedio(namex,strengthx).##, cartaase.##)
  }
  test("Una carta de unidad tiene un nombre, distinto al de otras cartas"){
    assertEquals(cartacac.getname(), expected = "Cuerpo a Cuerpo 1")
    val cartadis2 = new CartaDistancia("Distancia 2", 4)
    assert(!cartadis.getname().equals(cartadis2.getname()))
  }
  test("Una carta de unidad tiene un valor de fuerza, el cual puede ser distinto al de otras cartas"){
    assertEquals(cartaase.getcurrentstrength(), expected = 10)
    assert(!cartadis.getcurrentstrength().equals(cartacac._strength))
  }
  test("Hay cartas con habilidad definida como hay cartas sin habilidad"){
    assertEquals(cartaase.getability(), expected = None)
    assertEquals(cartaasex.getability(), expected = Some(rm))
    assertEquals(cartadis.getability(), expected = Some(rm))
    assert(!cartadis.getability().equals(cartacac.getability()))
  }
  test("Las cartas con habilidad modifican la fuerza de otras cartas"){
    val cartacac2 = new CartaCuerpoACuerpo("CAC 2", 4, Some(rm))
    val cartacac1var = new CartaCuerpoACuerpo("Cuerpo a Cuerpo 1", 3, Some(ve))

    // una carta con Vinculo Estrecho duplica la fuerza de otra carta
    // si la carta tiene distinto nombre, no modifica nada
    cartacac.pow_strength_of(cartacac2)
    assertEquals(cartacac2.getcurrentstrength(), expected = 4)

    // si la carta tiene el mismo nombre que la que modificara, se cambia la fuerza de esa carta y de si misma
    cartacac.pow_strength_of(cartacac1var)
    assertEquals(cartacac1var.getcurrentstrength(), expected = 6)
    assertEquals(cartacac.getcurrentstrength(), expected = 10) // fza cartacac = 10

    // una carta con Refuerzo Moral aumenta en 1 la fuerza de otra carta, sin mod a si mismo
    cartacac2.pow_strength_of(cartacac)
    //cartacac.pow_strength(cartacac2)
    assertEquals(cartacac.getcurrentstrength(), expected = 11) // fza cartacac = 11
    assertEquals(cartacac2.getcurrentstrength(), expected = 4)

    // una carta sin habilidad alguna no cambia la fuerza de otra carta
    val cartaase2 = new CartaAsedio("Asedio 2", 6)
    cartaase2.pow_strength_of(cartaase)
    assertEquals(cartaase.getcurrentstrength(), expected = 10)
  }
  test("Una carta de unidad solo modifica a otras de su misma clasificacion, siempre que tenga una habilidad definida") {
    interceptMessage[InvalidTypeModStrengthException]("Fuerza de Carta Asedio no puede ser modificada por Carta Cuerpo a Cuerpo") {
      cartacac.pow_strength_of(cartaase)
    }
    interceptMessage[InvalidTypeModStrengthException]("Fuerza de Carta Distancia no puede ser modificada por Carta de Cuerpo a Cuerpo"){
      cartacac.pow_strength_of(cartadis)
    }
    assertEquals(cartadis.getcurrentstrength(), expected = 3)
    assertEquals(cartaase.getcurrentstrength(), expected = 10)
    val cartacac5 = new CartaCuerpoACuerpo("Cuerpo a Cuerpo 1",3)
    cartacac.pow_strength_of(cartacac5)
    assertEquals(cartacac5.getcurrentstrength(), expected = 6)
    cartacac5.pow_strength_of(cartacac)
    assertEquals(cartacac.getcurrentstrength(), expected = 10)
  }
  test("Una carta de asedio solo modifica a otras de su mismo tipo, siempre que tenga una habilidad definida"){
    cartaase.pow_strength_of(cartadis)
    cartaase.pow_strength_of(cartacac)
    assertEquals(cartacac.getcurrentstrength(), expected = 5)
    assertEquals(cartadis.getcurrentstrength(), expected = 3)
    val cartaase2 = new CartaAsedio("Asedio 2", 6, Some(rm))
    cartaase.pow_strength_of(cartaase2)
    assertEquals(cartaase2.getcurrentstrength(), expected = 6)
    cartaase2.pow_strength_of(cartaase)
    assertEquals(cartaase.getcurrentstrength(), expected = 11)
    interceptMessage[InvalidTypeModStrengthException]("Fuerza de Carta Distancia no puede ser modificada por Carta de Asedio"){
      cartaase2.pow_strength_of(cartadis)
    }
    interceptMessage[InvalidTypeModStrengthException]("Fuerza de Carta Cuerpo a Cuerpo no puede ser modificada por Carta de Asedio"){
      cartaase2.pow_strength_of(cartacac)
    }
  }

  test("Una carta de distancia solo modifica a otras de su mismo tipo"){
    interceptMessage[InvalidTypeModStrengthException]("Fuerza de Carta Cuerpo a Cuerpo no puede ser modificada por Carta de Distancia"){
      cartadis.pow_strength_of(cartacac)
    }
    interceptMessage[InvalidTypeModStrengthException]("Fuerza de Carta Distancia no puede ser modificada por Carta Cuerpo a Cuerpo") {
      cartadis.pow_strength_of(cartaase)
    }
    assertEquals(cartacac._current_strength, expected = 5)
    assertEquals(cartaase._current_strength, expected = 10)
    val cartadis2 = new CartaDistancia("Distancia 2", 4)
    cartadis.pow_strength_of(cartadis2)
    assertEquals(cartadis2._current_strength, expected = 5)
    cartadis2.pow_strength_of(cartadis)
    assertEquals(cartadis._current_strength, expected = 3)
  }
}
