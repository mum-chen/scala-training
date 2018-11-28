import scala.collection.mutable

val big = new java.math.BigInteger("12345")

val greetStrings = new Array[String](3)
greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "world!\n"

for (i <- 0 to 2)
  print(greetStrings(i))

/* or
val greetStrings Array[String] = new Array[String](3)
*/

/*
0 to 2 same as (0).to(2)
*/

val greetStrings2: Array[String] = new Array[String](3)

greetStrings2.update(0, "Hello")
greetStrings2.update(1, ", ")
greetStrings2.update(2, "World!!!\n")

for (i <- (0).to(2))
  print(greetStrings2.apply(i))

val numNames = Array("zero", "one", "two")

numNames.foreach(arg => print(arg + " "))
println("!")


println("Demo for list")
val oneTwo = List(1, 2)
val threeFour = List(3, 4)
val oneTwoThreeFour = oneTwo :: threeFour
println(oneTwo + " and " + threeFour + " wrer not mutated.")
println("Thus, " + oneTwoThreeFour + " is a new list.")

val twoThree = List(2, 3)
val oneTwoThree = 1 :: twoThree
println(oneTwoThree)

val oneTwoThree2 = 1 :: 2 :: 3 :: Nil /* Nil for empty list */
println(oneTwoThree2)


println("Demo for tuple")

val pair = (99, "Luftballons")
println(pair._1)
println(pair._2)

println("Demo for set & map")
/* the var is necessary */
var jetSet = Set("Boeing", "Airbus")
jetSet += "Lear"
println(jetSet.contains("Lear"))

/* the val is accetable */
val movieSet = mutable.Set("Hitch", "Poltergeist")
movieSet += "Shrek"
println(movieSet)

val treasureMap = mutable.Map[Int, String]()
treasureMap += (1 -> "Go to island.")
treasureMap += (2 -> "Find big X on ground.")
treasureMap += (3 -> "Dig.")
println(treasureMap(2)

val romanNumeral = Map(1 -> "I", 2 -> "II")
println(romanNumeral)
