package Lab04

def diff[A](seq: Seq[A], seq2: Seq[A]): Seq[A] =
  seq.zip(seq2).filter(value => value._1 != value._2).map(value => value._1);
