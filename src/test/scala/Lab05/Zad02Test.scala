package Lab05

class Zad02Test extends munit.FunSuite {
  test("correctly swaps values that neighbour each other") {
    val input = Seq(1, 2, 3, 4, 5)

    val actual = swap(input)
    val expected = Seq(2, 1, 4, 3, 5)

    assertEquals(actual, expected)
  }
}
