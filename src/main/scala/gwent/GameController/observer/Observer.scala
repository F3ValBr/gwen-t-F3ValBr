package cl.uchile.dcc
package gwent.GameController.observer

import gwent.GameController.observer.Subject

/** 
 * Interfaz que define el comportamiento de un observador.
 * @tparam T Tipo de dato que se observa.
 *
 * @author Felipe Valdebenito Bravo
 * @version 1.0
 * @since 1.0
 */
trait Observer[T] {
  
  /** 
   * Actualiza el valor del observador.
   * @param observable Sujeto que se observa.
   * @param value Valor del sujeto que se observa.
   */
  def update(observable: Subject[T], value: T): Unit
}
