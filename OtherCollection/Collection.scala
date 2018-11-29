import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, ArrayBuffer}
import scala.collection.immutable.TreeSet

object TestCollection {

  def hasUpperCase(s: String) = s.exists(_.isUpper)

  def main(args: Array[String]) {
    val fiveInts = new Array[Int](5)
    val fiveToOne = Array(5, 4, 3, 2, 1)
    fiveInts(0) = fiveToOne(4)

    val lbuf = new ListBuffer[Int]
    lbuf += 1
    lbuf += 2
    3 +=: lbuf
    println(lbuf)

    val abuf = new ArrayBuffer[Int]()
    abuf += 12
    abuf += 15
    11 +=: abuf
    println(abuf)

    assert(hasUpperCase("aaaa") == false)

    val text = "See Spot run. Run, Spot. Run!"
    val wordsArray = text.split("[ !,.]+")
    println(wordsArray)

    val words = mutable.Set.empty[String]
    for (word <- wordsArray)
      words += word.toLowerCase
    println(words)

    val colors = List("blue", "yellow")
    //val treeSet = TreeSet(colors) // error
    val treeSet = TreeSet[String]() ++ colors
    println(treeSet)
  }
}
