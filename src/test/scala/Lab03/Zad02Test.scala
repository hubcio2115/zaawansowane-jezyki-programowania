package Lab03

class Zad02Test extends munit.FunSuite {
  test("correctly sorts elements") {
    val a = List(1, 3, 5, 8)
    val b = List(2, 4, 6, 8, 10, 12)

    val actual = merge(a, b)((m, n) => m < n)
    val expected = List(1, 2, 3, 4, 5, 6, 8, 8, 10, 12)

    assertEquals(actual, expected)
  }
}
