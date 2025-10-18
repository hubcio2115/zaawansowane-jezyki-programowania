package Lab02

import scala.annotation.tailrec

def isPrime(n: Int): Boolean = {
  if (n < 2) return false
  if (n == 2) return true
  if (n % 2 == 0) return false

  val sqrt = Math.sqrt(n)
  isPrimeTailRec(n, sqrt)
}

@tailrec
private def isPrimeTailRec(n: Int, end: Double, curr: Int = 3): Boolean = {
  if (curr > end) return true
  if (n % curr == 0) return false

  isPrimeTailRec(n, end, curr + 2)
}
