package Lab03

class Zad03Test extends munit.FunSuite {
  test("correctly groups elements") {
    val input = List('a', 'a', 'b', 'c', 'c', 'c', 'd', 'd', 'c')

    val actual = compress(input)
    val expected =
      List(
        ('a', 2),
        ('b', 1),
        ('c', 3),
        ('d', 2),
        ('c', 1)
      )

    assertEquals(actual, expected)
  }
}
