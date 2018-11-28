
println("Version 1")
var i = 0
while (i < args.length) {
  println(args(i))
  i += 1
}

println("Version 2")
args.foreach(arg => print(arg))

println("Version 3")
args.foreach((arg: String) => print(arg))

println("Version 4")
args.foreach(println)

println("Version 5")
for (arg <- args)
  println(arg)
