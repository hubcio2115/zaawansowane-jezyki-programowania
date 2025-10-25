package Lab03

class Zad05Test extends munit.FunSuite {
  test("correctly computes the value from a given inputs and operators") {
    val input = List(Some(1), None, Some(2), None, Some(3), Some(4))

    val actual = compute(input)(_ + 0)(_ + _)
    val expected = Some(10)

    assertEquals(actual, expected)
  }
}
