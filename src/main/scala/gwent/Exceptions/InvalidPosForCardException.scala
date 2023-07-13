package cl.uchile.dcc
package gwent.Exceptions

/**
 * Exception lanzada cuando se intenta jugar una carta arrojandola a una seccion invalida del tablero
 * @param message Mensaje de error
 */
class InvalidPosForCardException(message: String) extends Exception(message)
