package Lab04

class Zad08Test extends munit.FunSuite {
  test("calculated median correctly") {
    val input =
      Seq(("Hubert", 5.0), ("Zofia", 4.0), ("Krystian", 2.0), ("Szymon", 4.0), ("Ala", 1.0));

    val actual = median(input);
    val expected = 4.0;

    assertEquals(actual, expected);
  }
}
