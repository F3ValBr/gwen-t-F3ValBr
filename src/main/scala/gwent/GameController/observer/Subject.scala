package cl.uchile.dcc
package gwent.GameController.observer

import gwent.GameController.observer.Observer

/**
 * Interfaz que define el comportamiento de un sujeto observable.
 * @tparam T Tipo de dato que se notifica a los observadores.
 *
 * @author Felipe Valdebenito Bravo
 * @version 1.0
 * @since 1.0
 */
trait Subject[T] {
  
  /**
   * Agrega un observador a la lista de observadores.
   * @param observer Observador a agregar.
   */
  def addObserver(observer: Observer[T]): Unit

  /**
   * Notifica a todos los observadores de un cambio.
   * @param value Valor que se notifica a los observadores.
   */
  def notifyObservers(value: T): Unit
}
