// 1. Write a new Centigrade-to-Fahrenheit conversion (using the formula (x * 9/5) + 32), saving each step of the conversion into separate values. What do you expect the type of each value will be?
val x = 17
val multiplier = 9/5f
val result = x * multiplier
val finalResult = result + 32

// 2. Modify the Centigrade-to-Fahrenheit formula to return an integer instead of a floating-point number.
finalResult.toInt

// 3. Using the input value 2.7255, generate the string “You owe $2.73.” Is this doable with string interpolation?
val input = 2.7255
f"You owe ${"$"}$input%.2f."

// 4. Is there a simpler way to write the following?
val flag: Boolean = false
val result1: Boolean = (flag == false)
// Answer:
val result2: Boolean = !flag

// 5. Convert the number 128 to a Char, a String, a Double, and then back to an Int. Do you expect the original amount to be retained? Do you need any special con‐ version functions for this?
val i = 128
val c: Char = i.toChar
c.toInt
val s: String = i.toString
s.toInt
val d: Double = i.toDouble
d.toInt

// 6. Using the input string “Frank,123 Main,925-555-1943,95122” and regular expres‐ sion matching, retrieve the telephone number. Can you convert each part of the telephone number to its own integer value? How would you store this in a tuple?
val person = "Frank,123 Main,925-555-1943,95122"
val pattern = """.*Main,([\d.-]+),.*""".r
val pattern(phone) = person
val numbers = phone.split("-").map(_.toInt)
