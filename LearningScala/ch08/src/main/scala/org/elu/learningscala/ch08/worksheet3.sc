// Packages
// Accessing Packaged Classes
val d = new java.util.Date

import java.util.Date
val d1 = new Date

println("Your new UUID is " + {import java.util.UUID; UUID.randomUUID()})

// import collection.mutable._
// this imports all classes from collection.mutable package
import collection.mutable.{Queue,ArrayBuffer}
val b = new ArrayBuffer[String]
b += "Hello"
val q = new Queue[Int]
q.enqueue(3, 4, 5)
val pop = q.dequeue()
println(q)

val q1 = new Queue[Int]()
val b1 = new ArrayBuffer[String]
val m = Map(1 -> 2)
