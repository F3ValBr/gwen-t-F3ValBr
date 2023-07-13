package cl.uchile.dcc
package gwent.Exceptions

class InvalidPosForCardExceptionTest extends munit.FunSuite{
  private val message = "Test mensaje de error"
  private var exception: InvalidPosForCardException = _

  override def beforeEach(context: BeforeEach): Unit = {
    exception = new InvalidPosForCardException(message)
  }

  test("Test getMessege"){
    assertEquals(exception.getMessage, message)
  }
}
