package Lab04

class Zad07Test extends munit.FunSuite {
  test("correctly groups elements as (value, number of instances)") {
    val input = Seq('a', 'b', 'a', 'c', 'c', 'a');

    val actual = freq(input);
    val expected = Set(('a', 3), ('b', 1), ('c', 2));

    assertEquals(actual, expected);
  }
}
