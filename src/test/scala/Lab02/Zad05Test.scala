package Lab02
import Lab02.isOrdered

class Zad05Test extends munit.FunSuite {
  test("correctly returns a value for the given predicate") {
    val input = Array(1, 3, 3, 6, 8)
    val predicate: (Int, Int) => Boolean = (_ <= _)

    val actual = isOrdered(input, predicate)
    val expected = true

    assertEquals(actual, expected)
  }

  test("correctly returns a value for the given predicate") {
    val input = Array(1, 3, 3, 6, 8)
    val predicate: (Int, Int) => Boolean = (_ < _)

    val actual = isOrdered(input, predicate)
    val expected = false

    assertEquals(actual, expected)
  }
}
