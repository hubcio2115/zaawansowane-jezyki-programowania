package Lab04

def freq[A](seq: Seq[A]): Set[(A, Int)] =
  seq.groupBy(value => value).map((k, value) => (k, value.length)).toSet
