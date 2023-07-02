package cl.uchile.dcc
package gwent.GameController

trait Subject {
  def addObserver(observer: Observer): Unit
  def notifyObservers(value: Any): Unit
}
