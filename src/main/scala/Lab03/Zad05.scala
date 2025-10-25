package Lab03

import scala.annotation.tailrec

def compute[A, B](l: List[Option[A]])(op1: A => B)(op2: (A, B) => B): Option[B] = l match {
  case Some(head) :: tail => computeRec(tail, op2, Some(op1(head)))
  case None :: tail       => computeRec(tail, op2, None)
  case Nil                => None
}

@tailrec
private def computeRec[A, B](
  l: List[Option[A]],
  op: (A, B) => B,
  acc: Option[B] = None
): Option[B] = l match {
  case Some(head) :: tail if acc.isDefined => computeRec(tail, op, Some(op(head, acc.get)))
  case None :: tail                        => computeRec(tail, op, acc)
  case _                                   => acc
}
