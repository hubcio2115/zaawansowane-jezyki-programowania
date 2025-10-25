package Lab03

import scala.annotation.tailrec

def merge[T](a: List[T], b: List[T])(predicate: (T, T) => Boolean): List[T] = mergeRec(a, b, predicate)

@tailrec
def mergeRec[T](a: List[T], b: List[T], predicate: (T, T) => Boolean, acc: List[T] = List()): List[T] =
  (a, b) match {
    case (Nil, _) => acc ++ b

    case (_, Nil) => acc ++ a

    case (headA :: tailA, headB :: Nil) =>
      if (predicate(headA, headB)) {
        return mergeRec(tailA, b, predicate, acc :+ headA)
      }

      (acc :+ headB) ++ a

    case (headA :: Nil, headB :: tailB) =>
      if (predicate(headA, headB)) {
        return (acc :+ headA) ++ b
      }

      mergeRec(a, tailB, predicate, acc :+ headB)

    case (headA :: tailA, headB :: tailB) =>
      if (predicate(headA, headB)) {
        return mergeRec(tailA, b, predicate, acc :+ headA)
      }

      mergeRec(a, tailB, predicate, acc :+ headB)

    case _ => acc
  }
