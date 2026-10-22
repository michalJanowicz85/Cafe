import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class CafeSpec extends AnyWordSpec with Matchers {

  "Cafe" should {
    "calculate the correct bill" in {
      Cafe.totalBill(List(Cola, Cola, CheeseSandwich)) shouldBe 3.3
      Cafe.totalBill(List(Coffee, SteakSandwich)) shouldBe 6.6
    }
    "will not add service charge if only drinks ordered" in {
      Cafe.totalBill(List(Cola,Cola)) shouldBe 1
      Cafe.totalBill(List(Cola,Coffee)) shouldBe 1.5
    }
    "apply 10% of service charge for cold food" in {
      Cafe.totalBill(List(CheeseSandwich)) shouldBe 2.2
    }

    "round the bill to 2 decimals" in {
      Cafe.totalBill(List(TestCaseFood)) shouldBe 2.4  // actual 2.3988
    }
    "apply 20% of service charge for hot food" in {
      Cafe.totalBill(List(SteakSandwich)) shouldBe 5.4
    }
    "max service charge is £20.00" in {
      Cafe.totalBill(List.fill(40)(SteakSandwich)) shouldBe 200
    }
  }
}
