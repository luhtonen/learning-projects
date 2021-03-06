//: Playground - noun: a place where people can play

import UIKit

var hasSomething: String? = "Hey there!"
if let message = hasSomething {
    "Message was legit: \(message)"
} else {
    "There was no message!"
}

hasSomething
// String? = "Hey there!"
hasSomething!
// String = "Hey there!"

var hasNothing: String?
hasNothing
// prints nil
// hasNothing!
// fatal error: unexpectedly found nil while unwrapping an Optional value

var someString = "hi there"
someString
println(someString)

var hasAnotherSomething: String! = "Hey there!"
hasAnotherSomething

let purchaseEndpoint = ("buy", "POST", "/buy/", true)
purchaseEndpoint.1
purchaseEndpoint.2

let purchaseEndpoint1 = (name: "buy", httpMethod: "POST", URL: "/buy/", useAuth: true)
purchaseEndpoint1.httpMethod

let answer = 42
let gamma = 0.5772156649015

var someInt = 5
Double(someInt) + 3.141
Float(someInt) + 3.141

typealias Text = String
var hello:Text = "Hi there"

// Controls
for var i = 0; i < 5; ++i {
    println("Hello there number \(i)")
}

class Tire {var air = 0}
var tires = [Tire]()
for i in 1...4 {
    tires.append(Tire())
}
println("We have \(tires.count) tires")

tires = [Tire]()
for i in 1..<4 {
    tires.append(Tire())
}
println("We have \(tires.count) tires")

tires = [Tire]()
for _ in 1...4 {
    tires.append(Tire())
}
println("We have \(tires.count) tires")

for tire in tires {
    tire.air = 100
}

for char in "abc" {
    println(char)
}
