package Lab02

import scala.annotation.tailrec

def reverse(str: String): String =
  reverseRec(str)

@tailrec
private def reverseRec(str: String, acc: String = ""): String = {
  if (str.isEmpty) return acc
  reverseRec(str.tail, str.head + acc)
}
