package Lab02

import scala.annotation.tailrec

def value(n: Int): Int = fibRec(n)

@tailrec
private def fibRec(n: Int, a: Int = 1, b: Int = 1): Int = {
  if (n <= 0) return a
  fibRec(n - 1, b, b + a)
}
