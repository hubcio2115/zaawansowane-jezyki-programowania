package Lab04

class Zad01Test extends munit.FunSuite {
  test("correctly returns a subsection") {
    val input = List(1, 3, 5, 6, 7)
    val actual = subSeq(input, 1, 3)
    val expected = List(3, 5, 6)

    assertEquals(actual, expected)
  }
}
