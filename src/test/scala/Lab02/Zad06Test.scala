package Lab02

class Zad06Test extends munit.FunSuite {
  test("should return Some for valid inputs") {
    val tab1 = Array(-1, 3, 2, -8, 5)
    val tab2 = Array(-3, 3, 3, 0, -4, 5)
    val pred: (Int, Int) => Boolean = _ < _
    val op: (Int, Int) => Int = _ + _

    val result = worth(tab1, tab2)(pred)(op)

    assert(result.contains(5))
  }

  test("should return None for non matching inputs") {
    val tab1 = Array(1, 2, 3)
    val tab2 = Array(4, 5, 6)
    val pred: (Int, Int) => Boolean = _ > _
    val op: (Int, Int) => Int = _ - _

    val result = worth(tab1, tab2)(pred)(op)
    assert(result.isEmpty)
  }
}
