package Lab04

// Implement Numeric[A] for Payment
case class Payment(amount: Int)

object Payment {
  implicit object PaymentNumeric extends Numeric[Payment] {
    def plus(a: Payment, b: Payment): Payment = Payment(a.amount + b.amount)

    def minus(a: Payment, b: Payment): Payment = Payment(a.amount - b.amount)

    def times(a: Payment, b: Payment): Payment = Payment(a.amount * b.amount)

    def negate(a: Payment): Payment = Payment(-a.amount)

    def fromInt(n: Int): Payment = Payment(n)

    def toInt(a: Payment): Int = a.amount

    def toLong(a: Payment): Long = a.amount.toLong

    def toFloat(a: Payment): Float = a.amount.toFloat

    def toDouble(a: Payment): Double = a.amount.toDouble

    def compare(a: Payment, b: Payment): Int =
      a.amount.compare(b.amount)

    def parseString(str: String): Option[Payment] = Some(Payment(str.toInt))
  }
}
