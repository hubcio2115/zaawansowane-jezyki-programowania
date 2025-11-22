package Lab05

def swap[A](seq: Seq[A]): Seq[A] =
  seq
    .grouped(2)
    .flatMap {
      case Seq(head, tail) => Seq(tail, head)
      case Seq(head) => Seq(head)
    }
    .toSeq
