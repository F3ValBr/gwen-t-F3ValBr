package cl.uchile.dcc
package gwent.GameController

trait Observer {
  def update(observable: Subject, value: Any): Unit
}
