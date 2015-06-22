// Mutable Collections
val m = Map("AAPL" -> 597, "MSFT" -> 40)
val n = m - "AAPL" + ("GOOG" -> 521)
println(m)

// Creating New Mutable Collections
val nums = collection.mutable.Buffer(1)
for (i <- 2 to 10) nums += i
println(nums)
val l = nums.toList

// Creating Mutable Collections from Immutable Ones
val b = m.toBuffer
b trimStart 1
b += ("GOOG" -> 521)
val n1 = b.toMap

b += ("GOOG" -> 521)
val l1 = b.toList
val s = b.toSet

// Using Collection Builders
val b1 = Set.newBuilder[Char]
b1 += 'h'
b1 ++= List('e', 'l', 'l', 'o')
val helloSet = b1.result()

// Arrays
val colors = Array("red", "green", "blue")
colors(0) = "purple"
colors
println("very purple: " + colors)
val files = new java.io.File(".").listFiles()
val scala = files map (_.getName) filter (_ endsWith "scala")
