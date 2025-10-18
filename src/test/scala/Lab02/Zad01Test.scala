package Lab02
import Lab02.reverse

class Zad01Test extends munit.FunSuite {
  test("function reverses the string correctly") {
    val actual = reverse("hello")
    val expected = "olleh"

    assertEquals(actual, expected)
  }
}
