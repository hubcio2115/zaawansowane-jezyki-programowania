package Lab02
import Lab02.value

class Zad04Test extends munit.FunSuite {
  test("returns correct fibonacci numbers") {
    val fibNums = List(1, 1, 2, 3, 5, 8, 13, 21, 34, 55)

    (0 to 9 by 1).foreach { n =>
      val actual = value(n)
      val expected = fibNums(n)

      assertEquals(actual, expected)
    }
  }
}
