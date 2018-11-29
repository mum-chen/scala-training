import org.stairwaybook.simlulation._

object MySimulation extends CircuitSimulation {
  def InverterDely = 1
  def AndGateDely = 3
  def OrGateDely = 5

  def main(args: Array[String]) = {
    val input1, input2, sum, carry = new Wire
    probe("sum", sum)
    probe("carry", carry)

    halfAdder(input1, input2, sum, carry)
    input1 setSignal true
    run()

    input2 setSignal true
    run()
  }
}
