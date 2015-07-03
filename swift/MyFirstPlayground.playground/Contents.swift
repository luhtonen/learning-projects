//: Playground - noun: a place where people can play

import UIKit

var str = "Hello, playground"
println("Hello, World!")

// Declaring Variables and Constants
var greeting1: String = "Hello world"
var greeting2 = "Hello world"

let eAcute1 = "é"
println(_stdlib_getDemangledTypeName(eAcute1))
let eAcute2: Character = "é"
println(_stdlib_getDemangledTypeName(eAcute2))

var red, green, blue, alpha: Double // All values are of type Double
var firstName, lastName: String, birthYear, birthMonth, birthDay: Int
// firstName and lastName are of type String; birthYear, birthMonth and birthDay are of type Int

// Declaring Values
let pi1 = 3.14159 // pi is inferred to be of type Double
let pi2: Float = 3.14159 // pi is explicitly declared as Float

let x = -1
let y: UInt = 1_000_000
let π = 3.14159
let a: Character = "ⓐ"
let greeting = "Hello"
let 👍 = true

let eAcute3 = "\u{E9}"
let eAcute4 = "\u{65}\u{301}"
println(eAcute3 == eAcute4)

let string1 = "The e acute character is \u{E9}"
let string2: String = "The e acute character is \u{65}\u{301}"
println(string1 == string2)

// Numeric Literals
let oneTwentyDouble = 1.2e2
let negativeOneTwenty = -1.2e2
let binary15 = 0b1111
let negativeBinary15 = -0b1111
let octal15 = 0o17
let negativeOctal15 = -0o17
let hex15 = 0xf
let negativeHex15 = -0xf
let hexSixty = 0xfp2
let hexThreePointSevenFive = 0xfp-2
let hexFifteenPointFive = 0xf.8p0

// nil and Optional
var myConditionalInt: Int?
myConditionalInt = 1
myConditionalInt = nil

var myInt1: Int? = 1
var myInt2: Int? = 2
let sum = myInt1! + myInt2!

var myInt3: Int!
myInt3 = 1
let myInt4: Int! = 2
let sum2 = myInt3 + myInt4

