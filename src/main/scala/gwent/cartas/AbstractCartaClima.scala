package cl.uchile.dcc
package gwent.cartas

abstract class AbstractCartaClima(override val _name: String,
                                  override val _ability: String)
  extends CartaClima {

  private val em = "Escarcha Mordiente"
  private val ni = "Niebla Impenetrable"
  private val lt = "Lluvia Torrencial"
  private val cd = "Clima Despejado"

  override def del_strength(other: CartaUnidad): Unit = {
    if (_ability.contains(Some(em))) {

    }
  }
}
