package shapely

import org.scalatest.FunSpec

class NatSpec extends FunSpec {
  describe("A Nat") {
    it("should be initialized correctly (using macros)") {
      println(Nat.fromInt(3).type)
    }
  }
}
