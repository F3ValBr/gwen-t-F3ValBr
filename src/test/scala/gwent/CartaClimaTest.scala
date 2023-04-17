package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.cartas.*
import cl.uchile.dcc.gwent.cartas.cartaclima.{CartaClimaDespejado, CartaEscarchaMordiente, CartaLluviaTorrencial, CartaNieblaImpenetrable}
import cl.uchile.dcc.gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}
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
    // Carta Niebla Impenetrable solo puede cambiar stats de carta Cuerpo a Cuerpo
    cartani.set_to_one_strength(cartacac)
    assertEquals(cartacac._strength, expected = 5)
    cartaem.set_to_one_strength(cartacac)
    assertEquals(cartacac._strength, expected = 1)
  }
}
