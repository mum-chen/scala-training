import scala.io.Source

def widthOfLength(s: String) = s.length.toString.length

def print_file_1(name: String) = {
  for (line <- Source.fromFile(name).getLines())
    println(line.length + " | " + line)
}

def print_file_2(name: String) = {
  val lines = Source.fromFile(args(0)).getLines().toList
  /*
  var maxWidth = 0
  for (line <- lines) {
    maxWidth = maxWidth.max(widthOfLength(line))
  }
  */
  val longestLine = lines.reduceLeft((a, b) => if (a.length > b.length) a else b)
  val maxWidth = widthOfLength(longestLine)

  for (line <- lines) {
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    println(padding + line.length + " | " + line)
  }
}

if (args.length > 0) {
  print_file_2(args(0))
} else {
  Console.err.println("Please enter filename")
}
