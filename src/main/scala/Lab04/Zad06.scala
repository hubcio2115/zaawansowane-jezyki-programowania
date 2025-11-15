package Lab04

def isOrdered[A](seq: Seq[A])(pred: (A, A) => Boolean): Boolean = {
  val first = seq.sliding(2, 2).filter(value => value.length == 2).toList
  val second = seq.drop(1).sliding(2, 2).filter(value => value.length == 2).toList

  first.forall(value => pred(value.head, value(1))) &&
  second.forall(value => pred(value.head, value(1)))
}
