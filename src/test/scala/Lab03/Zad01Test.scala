package Lab03

class Zad01Test extends munit.FunSuite {
  test("correctly categorizes elements on indices") {
    val input = List(1, 3, 5, 6, 7)
    val actual = divide(input)
    val expected = (List(1, 5, 7), List(3, 6))

    assertEquals(actual, expected)
  }
}
