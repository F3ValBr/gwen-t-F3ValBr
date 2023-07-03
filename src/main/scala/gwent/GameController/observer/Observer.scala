package cl.uchile.dcc
package gwent.GameController.observer

import gwent.GameController.observer.Subject

trait Observer[T] {
  def update(observable: Subject[T], value: T): Unit
}
