package Lab02
import Lab02.isPrime

class Zad02Test extends munit.FunSuite {
  test("function identifies primes correctly") {

    val primes = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
      73, 79, 83, 89, 97)

    (0 to 100 by 1).foreach { n =>
      primes.find(p => p == n) match {
        case Some(x) => assert(isPrime(n) == true);
        case None    => assert(isPrime(n) == false)
      }
    }
  }
}
