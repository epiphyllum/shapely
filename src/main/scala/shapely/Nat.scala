sealed trait Nat

case object Zero0 extends Nat

final case class Succ[N <: Nat](n: N) extends Nat

object Nat {

  def fromInt(i: Int): Nat = macro NatMacros.materialize

  def toInt[N <: Nat](implicit N: ToInt[N]): Int = N.value
}

@macrocompat.bundle
class NatMacros(val c: whitebox.Context) {
  import c.universe._

  def materialize(i: Tree): Tree = {
    def loop(n: Int, acc: Tree): Tree =
      if (n <= 0) acc else loop(n - 1, q"shapely.Succ($acc)")

    i match {
      case Literal(Constant(n: Int)) if n >= 0 =>
        loop(n, q"shapely.Zero")

      case _ =>
        c.abort(c.enclosingPosition, "not a natural number")
    }
  }
}
