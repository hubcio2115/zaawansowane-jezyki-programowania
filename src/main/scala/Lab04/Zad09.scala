package Lab04

def minMax(seq: Seq[(String, Double)]): Option[(String, String)] = {
  val min = seq.minBy((_, score) => score)
  val max = seq.maxBy((_, score) => score)

  Some((max._1, min._1))
}
