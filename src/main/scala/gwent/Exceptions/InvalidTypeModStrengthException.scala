package cl.uchile.dcc
package gwent.Exceptions

/**
 * Exception lanzada cuando se intenta modificar la fuerza de una carta con un tipo de modificador de fuerza inválido.
 * @param message Mensaje de error.
 */
class InvalidTypeModStrengthException (message: String) extends Exception(message)
