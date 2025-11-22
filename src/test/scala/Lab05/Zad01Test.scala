package Lab05

class Zad01Test extends munit.FunSuite {
  test("correctly counts unique characters") {
    val input = "sphinx of black quartz judge my vow"

    val actual = countChars(input)
    val expected = 26

    assertEquals(actual, expected)
  }
}
