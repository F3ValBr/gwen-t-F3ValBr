package cl.uchile.dcc
package gwent.testtypes

import gwent.tablero.subdivisiones_combate.{ZonaAsedio, ZonaCuerpoACuerpo, ZonaDistancia}

import cl.uchile.dcc.gwent.Exceptions.InvalidPosForCardException
import cl.uchile.dcc.gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}

class TableroTest extends munit.FunSuite{
  var zonadis: ZonaDistancia = _
  var zonaase: ZonaAsedio = _
  var zonacac: ZonaCuerpoACuerpo = _

  override def beforeEach(context: BeforeEach): Unit = {
    zonadis = new ZonaDistancia()
    zonaase = new ZonaAsedio()
    zonacac = new ZonaCuerpoACuerpo()
  }

  test("Una Zona de cartas de distancia puede añadir cartas de distancia, pero no de otro tipo"){
    val card_dis = new CartaDistancia("dis_1",5)
    val card_ase = new CartaAsedio("ase_1",5)
    val card_cac = new CartaCuerpoACuerpo("cac_1",5)
    assert(zonadis.cartas_zona_in.isEmpty)
    zonadis.add_card(card_dis)
    assert(zonadis.cartas_zona_in.contains(card_dis))
    println(zonadis.cartas_zona_in)
    interceptMessage[InvalidPosForCardException]("No se puede agregar una carta de asedio a la zona de distancia"){
      zonadis.add_card(card_ase)
    }
    println(zonadis.cartas_zona_in)
  }
}
