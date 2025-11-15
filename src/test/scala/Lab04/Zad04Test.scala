package Lab04;

class Zad04Test extends munit.FunSuite {
  test("correctly sums up actual values") {
    val input = Seq(Some(5.4), Some(-2.0), Some(1.0), None, Some(2.6));

    val actual = sumOption(input);
    val expected = 7.0;

    assertEquals(actual.get, expected)
  }
}
