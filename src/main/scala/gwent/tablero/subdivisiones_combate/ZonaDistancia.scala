package cl.uchile.dcc
package gwent.tablero.subdivisiones_combate

import gwent.tablero.{Tablero, ZonaCartasCombate}
import gwent.Exceptions.InvalidPosForCardException
import gwent.cartas.{Carta, CartaUnidad}
import gwent.cartas.cartaunidad.{CartaAsedio, CartaCuerpoACuerpo, CartaDistancia}

import java.util.Objects
import scala.collection.mutable.ListBuffer

/**
  * Clase que representa la zona de distancia del tablero
  * @param cartas_zona_in Lista de cartas que se encuentran en la zona de distancia
  */
class ZonaDistancia(cartas_zona_in: ListBuffer[CartaUnidad] = ListBuffer()) 
  extends AbstractZonaCombateJugador(cartas_zona_in) 
    with Equals {

  // Documentacion en el trait ZonaCartasCombate
  override def add_card_asedio(card: CartaAsedio): Unit = {
    throw new InvalidPosForCardException("No se puede agregar una carta de asedio a la zona de distancia")
  }

  // Documentacion en el trait ZonaCartasCombate
  override def add_card_cuerpo_a_cuerpo(card: CartaCuerpoACuerpo): Unit = {
    throw new InvalidPosForCardException("No se puede agregar una carta de cuerpo a cuerpo a la zona de distancia")
  }

  // Documentacion en el trait ZonaCartasCombate
  override def add_card_distancia(card: CartaDistancia): Unit = {
    card_adder(this.cartas_zona_in, card)
  }

  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[ZonaDistancia]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[ZonaDistancia]
      cartas_zona_in == other.cartas_zona_in
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[ZonaDistancia], cartas_zona_in)
  }
}
