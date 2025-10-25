package Lab03

import scala.annotation.tailrec

def isSub[T](l: List[T], lSub: List[T]): Boolean = isSubRec(l, lSub)

@tailrec
def isSubRec[T](l: List[T], lSub: List[T], acc: Boolean = true): Boolean =
  if (!acc) return false
  if (l.length < lSub.length) return false

  lSub match {
    case head :: tail =>
      if (isInSeq(l, head)) {
        return true
      }

      isSubRec(l, tail)

    case Nil => false
  }

@tailrec
def isInSeq[T](l: List[T], el: T): Boolean = l match {
  case head :: next if el == head => true
  case _ :: next                  => isInSeq(next, el)
  case _                          => false
}
