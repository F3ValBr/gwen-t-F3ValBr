package cl.uchile.dcc
package gwent.Exceptions

class InvalidTransitionExceptionTest extends munit.FunSuite {
  private val message = "Test mensaje de error"
  private var exception: InvalidTransitionException = _

  override def beforeEach(context: BeforeEach): Unit = {
    exception = new InvalidTransitionException(message)
  }

  test("Test getMessege") {
    assertEquals(exception.getMessage, message)
  }
}
