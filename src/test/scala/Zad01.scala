package Lab01.Zad01
import Lab01.Zad01.findPrimarySums

class Zad01Test extends munit.FunSuite {
  test("lists correct components up until 8") {
    val actual = findPrimarySums(8)
    val expected = List((2, 2), (3, 3), (3, 5))

    assertEquals(actual, expected)
  }
}
