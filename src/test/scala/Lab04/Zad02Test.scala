package Lab04

class Zad02Test extends munit.FunSuite {
  test("correctly removes an element") {
    val input = List(1, 2, 3, 4, 5);
    val actual = remElem(input, 2);
    val expected = List(1, 2, 4, 5);

    assertEquals(actual, expected);
  }
}
