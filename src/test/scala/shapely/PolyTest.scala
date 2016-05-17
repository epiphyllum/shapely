package shapely

object PolyTest extends App {
  object square extends Poly {
    implicit val is = at[Int] { i => i * i }
    implicit val fs = at[Float] { f => f * f }
    implicit val ds = at[Double] { d => d * d }
  }

  object double extends Poly {
    implicit val is = at[Int] { i => i * 2 }
    implicit val fs = at[Float] { f => f * 2 }
    implicit val ds = at[Double] { d => d * 2 }
  }

  def main(args: Array[String]):Unit = {
    println(square.compose(double))
  }
}
