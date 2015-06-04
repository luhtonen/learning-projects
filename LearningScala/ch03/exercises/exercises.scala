// Exercises
// 1. Given a string name, write a match expression that will return the same 
// string if nonempty, or else the string “n/a” if it is empty. 
println("### Exercise 1")
val name = "Eduard"
name match {
    case "" => println("n/a")
    case _ => println(name)
}
val name = ""
name match {
    case "" => println("n/a")
    case _ => println(name)
}

// 2. Given a double amount, write an expression to return “greater” if it is 
// more than zero, “same” if it equals zero, and “less” if it is less than 
// zero. Can you write this with if..else blocks? How about with match 
// expressions?
// if .. else
println()
println("### Exercise 2")
val amount = 2.0
if (amount > 0) {
    println("greater") 
} else { 
    if (amount == 0) println("same")
    else println("less")
}

val amount = 0.0
if (amount > 0) {
    println("greater") 
} else { 
    if (amount == 0) println("same")
    else println("less")
}

val amount = -2.0
if (amount > 0) {
    println("greater") 
} else { 
    if (amount == 0) println("same")
    else println("less")
}

// match
val amount = 2.0
amount match {
    case a if a > 0 => println("greater")
    case a if a == 0 => println("same")
    case a if a < 0 => println("less")
}

val amount = 0.0
amount match {
    case a if a > 0 => println("greater")
    case a if a == 0 => println("same")
    case a if a < 0 => println("less")
}

val amount = -2.0
amount match {
    case a if a > 0 => println("greater")
    case a if a == 0 => println("same")
    case a if a < 0 => println("less")
}

// 3. Write an expression to convert one of the input values cyan, magenta, 
// yellow to their six-char hexadecimal equivalents in string form. What can 
// you do to handle error conditions?
println()
println("### Exercise 3")
val color = "cyan"
color match {
    case "cyan" => "#00ffff"
    case "magenta" => "#ff00ff"
    case "yellow" => "#ffff00"
    case _ => "Uknown color"
}

val color = "magenta"
color match {
    case "cyan" => "#00ffff"
    case "magenta" => "#ff00ff"
    case "yellow" => "#ffff00"
    case _ => "Uknown color"
}

val color = "yellow"
color match {
    case "cyan" => "#00ffff"
    case "magenta" => "#ff00ff"
    case "yellow" => "#ffff00"
    case _ => "Uknown color"
}

val color = "black"
color match {
    case "cyan" => "#00ffff"
    case "magenta" => "#ff00ff"
    case "yellow" => "#ffff00"
    case _ => "Unknown color"
}

// 4. Print the numbers 1 to 100, with each line containing a group of five 
// numbers. For example:
//       1, 2, 3, 4, 5,
//       6, 7, 8, 9, 10
//       ....
println()
println("### Exercise 4")
for (x <- 1 to 100) {
    print(s"$x, ")
    if (x % 5 == 0) println()
}

// 5. Write an expression to print the numbers from 1 to 100, except that for 
// multiples of 3, print “type,” and for multiples of 5, print “safe.” For 
// multiples of both 3 and 5, print “typesafe.”
println()
println("### Exercise 5")
for (x <- 1 to 100) {
    x match {
        case x if x % 3 == 0 && x % 5 == 0 => println("typesafe")
        case x if x % 3 == 0 => println("type")
        case x if x % 5 == 0 => println("safe")
        case _ => println(x)
    }
}

// 6. Can you rewrite the answer to exercise 5 to fit on one line? It
// probably won’t be easier to read, but reducing code to its shortest form
// is an art, and a good exercise to learn the language.
println()
println("### Exercise 6")
for (i <- 1 to 100; str = {if (i % 5 == 0 && i % 3 == 0) "typesafe" else if (i % 3 == 0) "type" else if (i % 5 == 0) "safe" else i }) println(str)
