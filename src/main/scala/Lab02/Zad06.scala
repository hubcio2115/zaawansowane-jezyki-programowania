package Lab02

import scala.annotation.tailrec

def worth(tab1: Array[Int], tab2: Array[Int])(pred: (Int, Int) => Boolean)(
  op: (Int, Int) => Int
): Option[Int] =
  worthRec(tab1, tab2, pred, op)

@tailrec
private def worthRec(
  tab1: Array[Int],
  tab2: Array[Int],
  pred: (Int, Int) => Boolean,
  op: (Int, Int) => Int
): Option[Int] = {
  if (tab1.isEmpty || tab2.isEmpty) {
    return None
  }

  if (pred(tab1.head, tab2.head)) {
    return Some(op(tab1.head, tab2.head))
  }

  worthRec(tab1.tail, tab2.tail, pred, op)
}
