package cl.uchile.dcc
package gwent.Exceptions

class InvalidTypeModStrengthExceptionTest extends munit.FunSuite{
  private val message = "Test mensaje de error"
  private var exception: InvalidTypeModStrengthException = _

  override def beforeEach(context: BeforeEach): Unit = {
    exception = new InvalidTypeModStrengthException(message)
  }

  test("Test getMessege"){
    assertEquals(exception.getMessage, message)
  }
}
