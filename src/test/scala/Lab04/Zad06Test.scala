package Lab04

class Zad06Test extends munit.FunSuite {
  test("returns false when predicate is not fulfilled") {
    val input = Seq(1, 2, 2, 4);

    val actual = isOrdered(input)(_ < _);
    assert(!actual);
  }

  test("returns true when predicate is fulfilled") {
    val input = Seq(1, 2, 2, 4);

    val actual = isOrdered(input)(_ <= _);
    assert(actual);
  }
}
