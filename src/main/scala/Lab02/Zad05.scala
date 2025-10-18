package Lab02

import scala.annotation.tailrec

def isOrdered[T](input: Array[T], predicate: (T, T) => Boolean): Boolean =
  isOrderedRec(input.toList, predicate)

@tailrec
private def isOrderedRec[T](
  arr: List[T],
  predicate: (T, T) => Boolean,
  acc: Boolean = true
): Boolean = {
  if (!acc) return false

  arr match {
    case head :: tail :: Nil =>
      predicate(head, tail)

    case head :: second :: tail =>
      isOrderedRec(second +: tail, predicate, predicate(head, second))

    case _ => acc
  }
}
