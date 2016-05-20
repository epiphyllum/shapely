package shapely

import org.scalatest.FunSpec

class NatSpec extends FunSpec {
  describe("A Nat") {
    it("can index an HList") {
      assert(("meaning of life" :: 42 :: HNil).nth(0) == "meaning of life")
      assert(("meaning of life" :: 42 :: HNil).nth(1) == 42)
    }
  }
}
