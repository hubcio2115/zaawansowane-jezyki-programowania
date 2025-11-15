package Lab04

def subSeq[A](seq: Seq[A], startIndex: Int, endIndex: Int): Seq[A] =
  seq.drop(startIndex).take(endIndex)
