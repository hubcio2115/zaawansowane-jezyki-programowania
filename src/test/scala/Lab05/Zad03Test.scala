package Lab05;

class Zad03Test extends munit.FunSuite {
  test("mastermind correctly counts scores for a game") {
    val code = Seq(1, 3, 2, 2, 4, 5)
    val move = Seq(2, 1, 2, 4, 7, 2)

    val actual = score(code)(move)
    val expected = (1, 3)

    assertEquals(actual, expected)
  }
}
