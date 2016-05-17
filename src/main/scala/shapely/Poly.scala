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
}
