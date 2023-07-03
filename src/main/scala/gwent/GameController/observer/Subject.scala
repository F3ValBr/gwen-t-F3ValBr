package cl.uchile.dcc
package gwent.GameController.observer

import gwent.GameController.observer.Observer

trait Subject[T] {
  def addObserver(observer: Observer[T]): Unit
  def notifyObservers(value: T): Unit
}
