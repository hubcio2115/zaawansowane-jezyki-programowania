/** Zadanie 1. Napisz program, który pobierze od użytkownika liczbę n oraz wyświetli informację, czy
  * każda naturalna liczba parzysta większa od 2 i mniejsza równa od n, czyli czy każda liczba
  * parzysta z przedziału (2, n], jest sumą dwóch liczb pierwszych.
  *
  * Dodatkowo na ekranie powinny zostać wypisane wszystkie te podziały.
  *
  * Przykład: Dla: n = 8
  *
  * Wyświetlenie może wyglądać w następujący sposób:
  *
  * 2 + 2 = 4
  *
  * 3 + 3 = 6
  *
  * 3 + 5 = 8
  */
package Lab01.Zad01

import scala.annotation.tailrec
import Lab02.isPrime

def Zad01(): Unit = {
  print("Dla: n = ")
  val n = scala.io.StdIn.readInt()
  val pairs = findPrimarySums(n)

  pairs.foreach { case (a, b) => println(s"$a + $b = ${a + b}") }
}

def findPrimarySums(n: Int): List[(Int, Int)] =
  (4 to n by 2).foldLeft(List()) { (acc, target) =>
    acc ++ findPrimeSumPairs(target, 2)
  }

@tailrec
private def findPrimeSumPairs(
  n: Int,
  curr: Int,
  acc: List[(Int, Int)] = List()
): List[(Int, Int)] = {
  val end = n / 2

  if (curr > end) return acc
  if (isPrime(curr) && isPrime(n - curr))
    return findPrimeSumPairs(n, curr + 1, acc :+ (curr, n - curr))

  findPrimeSumPairs(n, curr + 1, acc)
}
