package cl.uchile.dcc
import gwent.Cartas

/** CartasTest es el testeo de la clase Cartas, de acuerdo a una serie de casos
 * 
 * Se crean 3 variables del tipo Cartas, para realizar los tests correspondientes
 * Se asignan valores auxiliares para el caso que se necesite hacer algun testeo
 * de forma mas sencilla
 * 
 * @author Felipe Valdebenito Bravo
 *  */
class CartasTest extends munit.FunSuite {
  var carta1: Cartas = _
  var carta2: Cartas = _
  var carta3: Cartas = _

  // Clasificacion de las cartas
  val asd = "Asedio"
  val cac = "Cuerpo a cuerpo"
  val dis = "Distancia"

  // Tipo de carta
  val uni = "Unidad"
  val cli = "Clima"

  override def beforeEach(context: BeforeEach): Unit = {
    carta1 = Cartas("Unidad",20,"Asedio","RM")
    carta2 = Cartas("Clima","Escarcha Mordiente")
    carta3 = Cartas("Unidad")
  }

  test("Una carta tiene una clasificacion especifico"){
    assertEquals(carta1.clasific, expected = "Unidad")       // una carta tiene un tipo
    assert(!carta1.clasific.equals(carta2.clasific))         // dos cartas pueden tener tipos diferentes
    assertEquals(carta1.clasific, carta1.clasific)           // una carta comparada consigo misma
    assertEquals(carta2.clasific, new Cartas("Clima","Niebla Impenetrable").clasific) // generar una carta con el mismo tipo de otra
  }
  test("Una carta tiene un valor de fuerza"){
    assertEquals(carta1._fuerza, expected = 20)              // ua carta tiene un nivel de fuerza definido
    assert(!carta2._fuerza.equals(carta1._fuerza))           // dos cartas pueden tener distinto nivel de fuerza
    assertEquals(carta1._fuerza, new Cartas("Unidad",20,"Asedio","EM")._fuerza)
  }
  test("Una carta tiene un tipo en particular"){
    assertEquals(carta1._tipo,expected = "Asedio")           // unacarta tiene un tipo de unidad en particular
    assert(!carta1._tipo.equals(carta2._tipo))               // dos cartas pueden tener tipos distintos
  }
  test("Las cartas climaticas tienen un clima en especifico"){
    assert(!carta1._climatipo.equals("Escarcha Mordiente"))                  // una carta de unidad no puede tener clima
    assertNotEquals(carta2._climatipo,new Cartas("Clima","Lluvia Torrencial")._climatipo) // dos cartas de clima pueden tener climas distintos
    assertEquals(carta2._climatipo,new Cartas("Clima","Escarcha Mordiente")._climatipo)   // dos cartas pueden tener un mismo clima
  }
  test("Las cartas de unidad tienen una o ninguna habilidad en especial"){
    assertEquals(carta1._habilidad, expected = Some("RM"))        // una carta puede no tener habilidad
    assertEquals(carta2._habilidad, expected = None)              // una carta puede tener una habilidad definida
    assert(!carta1._habilidad.equals(carta2._habilidad))          // dos cartas tienen habilidades distintas
  }
}
