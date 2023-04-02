package cl.uchile.dcc
import gwent.Cartas

import scala.runtime.Nothing$

class CartasTest extends munit.FunSuite {
  var carta1: Cartas = _
  var carta2: Cartas = _
  var carta3: Cartas = _

  // Clasificacion de las cartas
  val as = "Asedio"
  val cc = "Cuerpo a cuerpo"
  val di = "Distancia"

  // Tipo de carta
  val un = "Unidad"
  val cl = "Clima"

  override def beforeEach(context: BeforeEach): Unit = {
    carta1 = Cartas(un,10,as,"Ninguno","Ninguno")
    carta2 = Cartas(cl,4,cc,"Ninguno","RM")

  }

  test("Una carta tiene una clasificacion especifico"){
    assertEquals(carta1.clasific, expected = "Unidad")  // una carta tiene un tipo
    assert(!carta1.clasific.equals(carta2.clasific))        // dos cartas pueden tener tipos diferentes
    assertEquals(carta1.clasific, carta1.clasific)          // una carta comparada consigo misma
    assertEquals(carta2.clasific, (new Cartas("Clima",8,"Distancia","Ninguno","Ninguno")).clasific) // generar una carta con el mismo tipo de otra
  }
  test("Una carta tiene un valor de fuerza"){
    assertEquals(carta1.fuerza, expected = 10)              // ua carta tiene un nivel de fuerza definido
    assert(!carta2.fuerza.equals(carta1.fuerza))            // dos cartas pueden tener distinto nivel de fuerza
    assertEquals(carta1.fuerza, (new Cartas("Unidad",10,"Asedio","Ninguno","Ninguno")).fuerza)
  }
  test("Una carta tiene un tipo en particular"){
    assertEquals(carta1.tipo,expected = "Asedio")           // unacarta tiene un tipo de unidad en particular
    assert(!carta1.tipo.equals(carta2.tipo))                // dos cartas pueden tener tipos distintos
  }
  test("Las cartas climaticas tienen un clima en especifico"){
    assert(!carta1.clima_tipo.equals("RM"))                 // una carta de unidad no puede tener clima
    assert(carta2.clima_tipo.equals(carta1.clima_tipo))     // dos cartas de unidad no tienen un clima
  }
  test("Las cartas de unidad tienen una o ninguna habilidad en especial"){
    assertEquals(carta1.habil, expected = "Ninguno")        // una carta puede no tener habilidad
    assertEquals(carta2.habil, expected = "RM")             // una carta puede tener una habilidad definida
    assert(!carta1.habil.equals(carta2.habil))              // dos cartas tienen habilidades distintas
  }
}
