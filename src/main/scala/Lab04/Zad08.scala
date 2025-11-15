package Lab04

def median(seq: Seq[(String, Double)]): Double = {
  val sorted = seq.sortBy((name, score) => score).map((_, value) => value)

  val middle = sorted.length / 2

  if (sorted.length % 2 == 1) {
    return sorted.apply(middle)
  }

  (sorted.apply(middle) + sorted.apply(middle + 1)) / 2
}
