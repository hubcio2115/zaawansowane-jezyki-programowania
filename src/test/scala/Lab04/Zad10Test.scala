package Lab04

class Zad10Test extends munit.FunSuite {
  test("correctly categorises threes into groups") {
    val actual = threeNumbers(10)
    val expected = Set((3, 4, 5), (4, 3, 5), (6, 8, 10), (8, 6, 10))

    assertEquals(actual, expected)
  }
}
