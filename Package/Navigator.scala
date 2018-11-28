package bobsrockets {
  package naviagtion {
    class Navigator {
      val map = new StarMap
    }

    class StarMap

    package tests {
      class NavigatorSuite
    }
  }

  class Ship {
    val nav = new naviagtion.Navigator
  }

  package fleets {
    class Fleet {
      def addShip() = { new Ship }
    }
  }
}
