package Lab04

class Zad03Test extends munit.FunSuite {
  test("correctly creates a diff sequence") {
    val input = Seq(1, 2, 3);
    val input2 = Seq(2, 2, 1, 3);

    val actual = diff(input, input2)
    val expected = Seq(1, 3);

    assertEquals(actual, expected)
  }
}
