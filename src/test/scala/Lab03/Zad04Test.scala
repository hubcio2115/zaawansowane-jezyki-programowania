package Lab03

class Zad04Test extends munit.FunSuite {
  test("correctly identifies that all elements in one collection are contained in another") {
    val lSub = List('a', 'b', 'c')
    val l = List('b', 'o', 'c', 'i', 'a', 'n')

    val actual = isSub(l, lSub)
    assert(actual)
  }
}
