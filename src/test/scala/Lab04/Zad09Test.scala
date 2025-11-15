package Lab04

class Zad09Test extends munit.FunSuite {
  test("calculates max and min scores") {
    val input =
      Seq(("Hubert", 5.0), ("Zofia", 4.0), ("Krystian", 2.0), ("Szymon", 4.0), ("Ala", 1.0));

    val actual = minMax(input);
    val expected = ("Hubert", "Ala");

    assertEquals(actual.get, expected);
  }
}
