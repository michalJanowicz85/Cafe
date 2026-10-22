import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class CafeSpec extends AnyWordSpec with Matchers {

  "Cafe" should {
    "calculate the correct bill" in {
      Cafe.totalBill(List(Cola, Cola, CheeseSandwich)) shouldBe 3 // 0.5 + 0.5 + 2.0 = 3
      Cafe.totalBill(List(Coffee, SteakSandwich)) shouldBe 5.5   // 2 + 4.5 == 6.5
    }
  }
}
