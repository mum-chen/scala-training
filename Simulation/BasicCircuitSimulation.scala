package org.stairwaybook.simlulation

abstract class BasicCircuitSimulation extends Simulation {
  def InverterDely: Int
  def AndGateDely: Int
  def OrGateDely: Int

  class Wire {
    private var sigVal = false
    private var actions: List[Action] = List()

    def getSignal = sigVal

    def setSignal(s: Boolean) =  {
      if (s != sigVal) {
        sigVal = s
        actions foreach (_ ())
      }
    }

    def addAction(a: Action) = {
      actions = a :: actions
      a()
    }
  }

  def inverter(input: Wire, output: Wire) = {
    def inverAction() = {
      val inpuSig = input.getSignal
      afterDelay(InverterDely) {
        output setSignal !inpuSig
      }
    }
    input addAction inverAction _
  }

  def andGate(a1: Wire, a2: Wire, output: Wire) = {
    def andAction() = {
      val a1Sig = a1.getSignal
      val a2Sig = a2.getSignal
      afterDelay(AndGateDely) {
        output setSignal (a1Sig & a2Sig)
      }
    }

    a1 addAction andAction _
    a2 addAction andAction _
  }

  def orGate(o1: Wire, o2: Wire, output: Wire) = {
    def orAction() = {
      val o1Sig = o1.getSignal
      val o2Sig = o2.getSignal
      afterDelay(OrGateDely) {
        output setSignal (o1Sig | o2Sig)
      }

    }
    o1 addAction orAction _
    o2 addAction orAction _
  }

  def probe(name: String, wire: Wire) = {
    def probeAction() = {
      println(name + " " + currentTime + " new-value" + wire.getSignal)
    }
    wire addAction probeAction _
  }
}
