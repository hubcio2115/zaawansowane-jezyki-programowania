package Lab03

import scala.annotation.tailrec

def compress[T](list: List[T]): List[(T, Int)] = compressRec(list)

@tailrec
def compressRec[T](list: List[T], acc: List[(T, Int)] = List()): List[(T, Int)] =
  (list, acc) match {
    case (char :: Nil, head :+ tail) =>
      if (tail._1 == char) {
        return acc :+ (char, tail._2 + 1)
      }

      acc :+ (char, 1)

    case (char :: next, head :+ tail) =>
      if (tail._1 == char) {
        return compressRec(next, head :+ (char, tail._2 + 1))
      }

      compressRec(next, acc :+ (char, 1))

    case (char :: next, Nil) =>
      compressRec(next, acc :+ (char, 1))

    case _ => acc
  }
