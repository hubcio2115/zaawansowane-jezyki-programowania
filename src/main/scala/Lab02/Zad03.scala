package Lab02

import scala.annotation.tailrec

def binToDec(bin: Int) = {
  val binStr = bin.toBinaryString
  val reversedBinStr = binStr.reverse

  binToDecRec(reversedBinStr)
}

@tailrec
private def binToDecRec(binStr: String, i: Int = 0, acc: Int = 0): Int = {
  if (binStr.isEmpty) return acc

  val pow = math.pow(Integer.parseInt(binStr.head.toString), i).toInt
  binToDecRec(binStr.tail, i + 1, acc + pow)
}
