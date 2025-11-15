package Lab04

def sumOption[A: Numeric](seq: Seq[Option[A]]): Option[A] = {
  val first =
    seq.zipWithIndex.collectFirst((value, idx) => value match { case Some(x) => (x, idx) })
  if (first.isEmpty) { return None }

  val idx = first.get._2

  Some(
    seq
      .drop(idx + 1)
      .foldLeft(first.get._1)((acc, value) =>
        value match {
          case Some(x) => implicitly[Numeric[A]].plus(acc, x)
          case None    => acc
        }
      )
  )
}
