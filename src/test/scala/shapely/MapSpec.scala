package shapely

import org.scalatest.FunSpec

class MapSpec extends FunSpec {
  describe("Mapping an HList") {
    val xs = 1 :: false :: "hey" :: HNil

    object transform extends Poly {
      implicit val is = at[Int] { _ + 3 }
      implicit val bs = at[Boolean] { !_ }
      implicit val ss = at[String] { _ + " there" }
    }

    it("should apply a Poly correctly") {
      assert(xs.map(transform) == 4 :: true :: "hey there" :: HNil)
    }
  }
}
