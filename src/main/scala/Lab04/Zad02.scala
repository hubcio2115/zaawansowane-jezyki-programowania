package Lab04

def remElem[A](seq: Seq[A], k: Int): Seq[A] =
  seq.zipWithIndex.filter((_, i) => i != k).map((el, _) => el);
