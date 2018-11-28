/* Define self Value */
class Dollars(val amount: Int) extends AnyVal {
  override def toString() = "$" + amount
}


object Dollars {
  def main(args: Array[String]) = {
    val money = new Dollars(10000)
    println(money)
  }
}
