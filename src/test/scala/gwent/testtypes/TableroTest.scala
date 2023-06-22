package cl.uchile.dcc
package gwent.testtypes

import gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}
import gwent.Exceptions.{InvalidPosForCardException, InvalidTypeModStrengthException}
import gwent.cartas.cartaclima.{CartaClimaDespejado, CartaEscarchaMordiente, CartaLluviaTorrencial, CartaNieblaImpenetrable}
import gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}
import gwent.tablero.ZonaClima

import cl.uchile.dcc.gwent.cartas.cartaunidad.efectosU.{RefuerzoMoral, VinculoEstrecho}

class TableroTest extends munit.FunSuite{
  var zonadis: ZonaDistancia = _
  var zonaase: ZonaAsedio = _
  var zonacac: ZonaCuerpoACuerpo = _
  var zonaclima: ZonaClima = _

  val card_dis = new CartaDistancia("dis_1", 5)
  val card_ase = new CartaAsedio("ase_1", 7)
  val card_cac = new CartaCuerpoACuerpo("cac_1", 9)
  val cardcacx = new CartaCuerpoACuerpo("cac_x", 8)

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

  test("Creacion de una zona e igualdad con otra"){
    val zonadis2 = new ZonaDistancia()
    assert(zonadis == zonadis2)
    assert(zonadis != zonaase)
    zonadis2.add_card(card_dis)
    zonadis.add_card(card_dis)
    assert(zonadis == zonadis2)
  }

  test("El hashcode de una zona determinada es consistente con su correspondiente en equals"){
    val zonacact = new ZonaCuerpoACuerpo()
    zonacact.add_card(card_cac)
    zonacac.add_card(card_cac)
    assertEquals(zonacac.##, zonacact.##)

    val zonadist = new ZonaDistancia()
    zonadist.add_card(card_dis)
    zonadis.add_card(card_dis)
    assertEquals(zonadis.##, zonadist.##)

    val zonaaset = new ZonaAsedio()
    zonaaset.add_card(card_ase)
    zonaase.add_card(card_ase)
    assertEquals(zonaase.##, zonaaset.##)
  }

  test("Pueden haber dos zonas del mismo tipo con las mismas cartas"){
    val zonadis2 = new ZonaDistancia()
    val carddis2 = new CartaDistancia("dis_1", 5)
    zonadis2.add_card(card_dis)
    zonadis.add_card(card_dis)
    assertEquals(zonadis, zonadis2)
    zonadis2.add_card(carddis2)
    assertNotEquals(zonadis, zonadis2)
    zonadis.add_card(carddis2)
    assertEquals(zonadis, zonadis2)

    val zonaase2 = new ZonaAsedio()
    val cardase2 = new CartaAsedio("ase_1", 7)
    zonaase2.add_card(card_ase)
    zonaase.add_card(card_ase)
    assertEquals(zonaase, zonaase2)
    zonaase2.add_card(cardase2)
    assertNotEquals(zonaase, zonaase2)
    zonaase.add_card(cardase2)
    assertEquals(zonaase, zonaase2)

    val zonacac2 = new ZonaCuerpoACuerpo()
    val cardcac2 = new CartaCuerpoACuerpo("cac_1", 9)
    zonacac2.add_card(card_cac)
    zonacac.add_card(card_cac)
    assertEquals(zonacac, zonacac2)
    zonacac2.add_card(cardcac2)
    assertNotEquals(zonacac, zonacac2)
    zonacac.add_card(cardcac2)
    assertEquals(zonacac, zonacac2)
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

  test("Modificacion de fuerzas dado una carta con cierto efecto"){

    val card_ase2 = new CartaAsedio("ase_1", 5, new VinculoEstrecho())
    val card_ase3 = new CartaAsedio("ase_3", 3, new RefuerzoMoral())
    zonaase.mod_n_add_card(card_ase)
    zonaase.mod_n_add_card(card_ase2)
    assertEquals(zonaase.counter_strength(), 24)
    zonaase.mod_n_add_card(card_ase3)
    assertEquals(zonaase.counter_strength(), 29)

    val card_cac2 = new CartaCuerpoACuerpo("cac_1", 5)
    zonacac.mod_n_add_card(card_cac)
    zonacac.mod_n_add_card(card_cac2)
    assertEquals(zonacac.counter_strength(), 14)

    val card_dis2 = new CartaDistancia("dis_1", 3, new RefuerzoMoral())
    val card_disx = new CartaDistancia("dis_x", 7)
    zonadis.mod_n_add_card(card_dis)
    zonadis.mod_n_add_card(card_disx)
    zonadis.mod_n_add_card(card_dis2)
    assertEquals(zonadis.counter_strength(),17)
    val card_dis3 = new CartaDistancia("dis_3", 5, new VinculoEstrecho())
    zonadis.mod_n_add_card(card_dis3)
    assertEquals(zonadis.counter_strength(), 22)

    interceptMessage[InvalidTypeModStrengthException]("Fuerza de Carta Distancia no puede ser modificada por Carta de Asedio") {
      zonadis.mod_n_add_card(card_ase2)
    }
  }
}
