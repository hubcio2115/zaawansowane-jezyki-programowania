package Lab03

def compose[A, B, C](f: A => B)(g: B => C): A => C = (param: A) => g(f(param))

def prod[A, B, C, D](f: A => C, g: B => D): (A, B) => (C, D) =
  (param1: A, param2: B) => (f(param1), g(param2))

def lift[A, B, T](op: (T, T) => T)(f: A => T, g: B => T): (A, B) => T =
  (param1: A, param2: B) => op(f(param1), g(param2))

type MSet[A] = A => Int

def sum[A](s1: MSet[A], s2: MSet[A]): MSet[A] =
  (a: A) => lift[A, A, Int](_ + _)(s1, s2)(a, a)

def diff[A](s1: MSet[A], s2: MSet[A]): MSet[A] =
  (a: A) =>
    lift[A, A, Int] { (a, b) =>
      if (a < b) b - a
      else a - b
    }(s1, s2)(a, a)

def mult[A](s1: MSet[A], s2: MSet[A]): MSet[A] =
  (a: A) =>
    lift[A, A, Int]((a, b) =>
      if (a < b) a
      else b
    )(s1, s2)(a, a)
