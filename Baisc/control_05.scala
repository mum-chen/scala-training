import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

println("==== demo for if ===")
val filename = if (!args.isEmpty) args(0) else "default.txt"
println(filename)

println("==== demo for while ===")
def gcdLoop(x: Long, y: Long): Long = {
  var a = x
  var b = y
  while (a != 0) {
    val temp = a
    a = b % a
    b = temp
  }
  b
}

def getInput(): Unit = {
  var line = ""
  do {
    line = readLine()
    println("Read: " + line)
  } while (line != "")
}

def greet() = { println("hi") }

println(gcdLoop(10, 5))
//getInput()
println(() == greet())

println("==== demo for for ===")
val filesHere = (new java.io.File(".")).listFiles

for (file <- filesHere)
  println(file)

for (i <- 1 to 4)
  println("Iteration " + i)

for (i <- 1 until 4)
  println("Iteration " + i)

println("demo for filter")
for (file <- filesHere if file.isFile if file.getName.endsWith(".scala"))
  println(file)

def fileLines(file: java.io.File) =
  scala.io.Source.fromFile(file).getLines().toList

def grep(pattern: String) =
  for {
    file <- filesHere
    if file.getName.endsWith(".scala")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(pattern)
  } println(file + ": " + trimmed)

grep(".*gcd.*")

def scalaFiles =
  for {
    file <- filesHere
    if file.getName.endsWith(".scala")
  } yield file


val forLineLengths =
  for {
    file <- filesHere
    if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(".*for.*")
  } yield trimmed.length


println("==== demo for try ===")
def half(n: Int) =
  if (n % 2 == 0)
    n / 2
  else
    throw new RuntimeException("n must be even")

assert(half(2) == 1)

// println(half(1))

try {
  val f = new FileReader("input.txt")
} catch {
  case ex: FileNotFoundException => println("not found")
  case ex: IOException => println("else")
} finally {
  println("end of try")
}


def try_f1(): Int = try return 1 finally return 2
def try_f2(): Int = try 1 finally 2
assert(try_f1() == 2)
assert(try_f2() == 1)

println("==== demo for match ===")
val firstArg = if (args.length > 0) args(0) else ""

firstArg match {
  case "slat" => println("pepper")
  case "chips" => println("salasa")
  case "eggs" => println("bacon")
  case _ => println("huh?")
}

/* The match is also a expression. It can return value */
val friend =
  firstArg match {
    case "slat" => "pepper"
    case "chips" => "salasa"
    case "eggs" => "bacon"
    case _ => "huh?"
  }
println(friend)
