package Lab04

class Zad05Test extends munit.FunSuite {
  test("correctly removes repeating values") {
    val input = Seq(1, 1, 2, 4, 4, 4, 1, 3)

    val actual = deStutter(input)
    val expected = Seq(1, 2, 4, 1, 3)

    assertEquals(actual, expected)
  }
}
