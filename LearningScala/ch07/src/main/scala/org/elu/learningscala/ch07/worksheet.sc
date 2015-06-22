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
