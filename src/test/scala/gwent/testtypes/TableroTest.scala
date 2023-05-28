package cl.uchile.dcc
package gwent.testtypes

import gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}

import gwent.Exceptions.InvalidPosForCardException
import gwent.cartas.cartaclima.{CartaClimaDespejado, CartaEscarchaMordiente, CartaLluviaTorrencial, CartaNieblaImpenetrable}
import gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}
import gwent.tablero.ZonaClima

class TableroTest extends munit.FunSuite{
  var zonadis: ZonaDistancia = _
  var zonaase: ZonaAsedio = _
  var zonacac: ZonaCuerpoACuerpo = _
  var zonaclima: ZonaClima = _

  val card_dis = new CartaDistancia("dis_1", 5)
  val card_ase = new CartaAsedio("ase_1", 7)
  val card_cac = new CartaCuerpoACuerpo("cac_1", 9)

  val card_em = new CartaEscarchaMordiente("em_1")
  val card_ni = new CartaNieblaImpenetrable("ni_1")
  val card_lt = new CartaLluviaTorrencial("lt_1")
  val card_cd = new CartaClimaDespejado("cd_1")

  override def beforeEach(context: BeforeEach): Unit = {
    zonadis = new ZonaDistancia()
    zonaase = new ZonaAsedio()
    zonacac = new ZonaCuerpoACuerpo()
    zonaclima = new ZonaClima()
  }

  test("Ver las cartas que hay en la zona de combate"){
    assert(zonadis.cartas_zona_in.isEmpty)
    zonadis.add_card(card_dis)
    assert(zonadis.cartas_zona_in.contains(card_dis))
    val things_in = zonadis.viewZone()
    assert(things_in.contains(card_dis))
  }
  test("Ver la carta disponible en la zona de clima"){
    assertEquals(zonaclima.cartas_clima_in, CartaClimaDespejado("Init"))
    zonaclima.replace_clima(card_em)
    assert(zonaclima.cartas_clima_in == card_em)
    val things_in = zonaclima.viewZone()
    assertEquals(things_in, card_em)
  }
  // Tests por cada zona de combate
  test("Una zona puede añadir cartas y despues limpiar la zona"){
    assert(zonadis.cartas_zona_in.isEmpty)
    zonadis.add_card(card_dis)
    assert(zonadis.cartas_zona_in.contains(card_dis))
    zonadis.clean_zone()
    assert(zonadis.cartas_zona_in.isEmpty)
  }

  test("Una Zona de cartas de distancia puede añadir cartas de distancia, pero no de otro tipo"){
    assert(zonadis.cartas_zona_in.isEmpty)
    zonadis.add_card(card_dis)
    assert(zonadis.cartas_zona_in.contains(card_dis))
    interceptMessage[InvalidPosForCardException]("No se puede agregar una carta de asedio a la zona de distancia"){
      zonadis.add_card(card_ase)
    }
    interceptMessage[InvalidPosForCardException]("No se puede agregar una carta de cuerpo a cuerpo a la zona de distancia") {
      zonadis.add_card(card_cac)
    }
  }

  test("Una Zona de cartas de asedio puede añadir cartas de asedio, pero no de otro tipo") {
    assert(zonaase.cartas_zona_in.isEmpty)
    zonaase.add_card(card_ase)
    assert(zonaase.cartas_zona_in.contains(card_ase))
    interceptMessage[InvalidPosForCardException]("No se puede agregar una carta de distancia a la zona de asedio") {
      zonaase.add_card(card_dis)
    }
    interceptMessage[InvalidPosForCardException]("No se puede agregar una carta de cuerpo a cuerpo a la zona de asedio") {
      zonaase.add_card(card_cac)
    }
  }

  test("Una Zona de cartas de cuerpo a cuerpo puede añadir cartas de cuerpo a cuerpo, pero no de otro tipo") {
    assert(zonacac.cartas_zona_in.isEmpty)
    zonacac.add_card(card_cac)
    assert(zonacac.cartas_zona_in.contains(card_cac))
    interceptMessage[InvalidPosForCardException]("No se puede agregar una carta de distancia a la zona de cuerpo a cuerpo") {
      zonacac.add_card(card_dis)
    }
    interceptMessage[InvalidPosForCardException]("No se puede agregar una carta de asedio a la zona de cuerpo a cuerpo") {
      zonacac.add_card(card_ase)
    }
  }

  test("Una zona de combate entregara la suma de las fuerzas de las cartas que contiene"){
    zonadis.add_card(card_dis)
    val card_dis2 = new CartaDistancia("dis_2", 9)
    zonadis.add_card(card_dis2)
    assertEquals(zonadis.counter_strength(), 14)
    zonaase.add_card(card_ase)
    val card_ase2 = new CartaAsedio("ase_2", 3)
    zonaase.add_card(card_ase2)
    assertEquals(zonaase.counter_strength(), 10)
    zonacac.add_card(card_cac)
    val card_cac2 = new CartaCuerpoACuerpo("cac_2", 8)
    zonacac.add_card(card_cac2)
    assertEquals(zonacac.counter_strength(), 17)
  }


  //Test de Zona Clima
  test("Una Zona de Clima guarda una carta de clima y puede ser reemplazada"){
    zonaclima.replace_clima(card_em)
    assertEquals(zonaclima.cartas_clima_in, card_em)
    zonaclima.replace_clima(card_ni)
    assertEquals(zonaclima.cartas_clima_in, card_ni)
    zonaclima.replace_clima(card_lt)
    assertEquals(zonaclima.cartas_clima_in, card_lt)
  }
  test("Una Zona de Clima puede ser limpiada"){
    zonaclima.replace_clima(card_em)
    assertEquals(zonaclima.cartas_clima_in, card_em)
    zonaclima.clean_zone()
    assertEquals(zonaclima.cartas_clima_in, new CartaClimaDespejado("Init"))
  }
}
