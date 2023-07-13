package cl.uchile.dcc
package gwent.Exceptions

/** 
 * Exception que se lanza cuando se realiza una transicion invalida en el juego.
 * @param message Mensaje de error.
 */
class InvalidTransitionException(message: String) extends Exception(message)
