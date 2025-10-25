package Lab03

import scala.annotation.tailrec

def divide[T](list: List[T]): (List[T], List[T]) = divideRec(list)

@tailrec
private def divideRec[T](
  list: List[T],
  i: Int = 0,
  acc: (List[T], List[T]) = (List(), List())
): (List[T], List[T]) = list match {
  case head :: Nil =>
    if (i % 2 == 0) {
      return (acc._1 :+ head, acc._2)
    }

    (acc._1, acc._2 :+ head)

  case head :: tail =>
    if (i % 2 == 0) {
      return divideRec(tail, i + 1, (acc._1 :+ head, acc._2))
    }

    divideRec(tail, i + 1, (acc._1, acc._2 :+ head))

  case _ => acc
}
