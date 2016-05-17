package shapely

trait Poly { self =>

  final def at[A] = new {
    def apply[B](f: A => B): Case[A, B] = new Case[A, B] {
      def apply(a: A) = f(a)
    }
  }

  sealed trait Case[A, B] {
    def apply(a: A): B
  }

  def apply[A, B](a: A)(implicit C: this.Case[A, B]): B = C(a)

  def compose(p2: Poly): Poly = new Poly {
    println(implicitly[this.Case[Int, Int]])
    println(implicitly[p2.Case[Int, Int]])
    implicit def _compose[A, B, C](
        C1: self.Case[A, B], C2: p2.Case[B, C]): Case[A, C] = new Case[A, C] {
      def apply(a: A) = C2(C1(a))
    }
  }
}
