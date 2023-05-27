package cl.uchile.dcc
package gwent.testtypes

import gwent.cartas.*
import gwent.cartas.cartaclima.{CartaClimaDespejado, CartaEscarchaMordiente, CartaLluviaTorrencial, CartaNieblaImpenetrable}
import gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}

import cl.uchile.dcc.gwent.Exceptions.InvalidTypeModStrengthException
import munit.FunSuite

class CartaClimaTest extends FunSuite{
  var cartacd: CartaClimaDespejado = _
  var cartaem: CartaEscarchaMordiente = _
  var cartalt: CartaLluviaTorrencial = _
  var cartani: CartaNieblaImpenetrable = _

  var cartacac: CartaCuerpoACuerpo = _
  var cartaase: CartaAsedio = _
  var cartadis: CartaDistancia = _

  val em = "Escarcha Mordiente"  // -> Cuerpo a Cuerpo
  val lt = "Lluvia Torrencial"   // -> Asedio
  val ni = "Niebla Impenetrable" // -> Distancia
  val cd = "Clima Despejado"

  val ase = "Asedio"
  val cac = "Cuerpo a Cuerpo"
  val dis = "Distancia"

  val rm = "Refuerzo Moral"
  val ve = "Vinculo Estrecho"

  override def beforeEach(context: BeforeEach): Unit = {
    cartacd = new CartaClimaDespejado("Dia soleado")
    cartalt = new CartaLluviaTorrencial("Tormenta")
    cartani = new CartaNieblaImpenetrable("Neblina")
    cartaem = new CartaEscarchaMordiente("Frio Extremo")

    cartacac = new CartaCuerpoACuerpo("Cuerpo a Cuerpo 1", 5, Some(ve))
    cartaase = new CartaAsedio("Asedio 1", 10)
    cartadis = new CartaDistancia("Distancia 1", 3, Some(rm))
  }

  test("Una carta de clima tiene un nombre definido, distinto de otras cartas"){
    assertEquals(cartacd._name, expected = "Dia soleado")
    assert(!cartaem._name.equals(cartani._name))
  }
  test("La habilidad de una carta de clima solo afecta a la carta de unidad correspondiente"){
    // Carta Niebla Impenetrable solo puede cambiar stats de carta Distancia
    interceptMessage[InvalidTypeModStrengthException]("Carta Cuerpo a Cuerpo no puede ser afectada por Carta Niebla Impenetrable"){
      cartani.mod_strength(cartacac) // NI intenta cambiar stats de Cuerpo a Cuerpo
    }
    assertEquals(cartacac._current_strength, expected = 5)
    cartaem.mod_strength(cartacac)
    assertEquals(cartacac._current_strength, expected = 1)
    cartani.mod_strength(cartadis)
    assertEquals(cartadis._current_strength, expected = 1)
    cartalt.mod_strength(cartaase)
    assertEquals(cartaase._current_strength, expected = 1)
    // Carta Clima Despejado restaura los valores de fuerza originales de las cartas
    cartacd.mod_strength(cartacac)
    assertEquals(cartacac._current_strength, expected = 5)
    cartacd.mod_strength(cartaase)
    assertEquals(cartaase._current_strength, expected = 10)
    cartacd.mod_strength(cartadis)
    assertEquals(cartadis._current_strength, expected = 3)
  }
}
