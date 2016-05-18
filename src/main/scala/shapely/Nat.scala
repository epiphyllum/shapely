sealed trait Nat

case object Zero0 extends Nat

final case class Succ[N <: Nat](n: N) extends Nat
