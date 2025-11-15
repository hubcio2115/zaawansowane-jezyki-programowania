package Lab04

def deStutter[A](seq: Seq[A]): Seq[A] =
  seq
    .drop(1)
    .reverse
    .foldLeft(Seq(seq.last)) { (acc, value) =>
      if (acc.head == value) acc
      else value +: acc
    }
