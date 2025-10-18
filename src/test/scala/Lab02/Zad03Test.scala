package Lab02
import Lab02.binToDec

class Zad03Test extends munit.FunSuite {
  test("correctly converts a bin to decimal") {
    val bin = 0b01010
    val actual = binToDec(bin)
    val expected = 3

    assertEquals(actual, expected)
  }
}
