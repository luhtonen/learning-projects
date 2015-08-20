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
//let (purchaseName, purchaseMethod, purchaseURL, _) = purchaseEndpoint1

                                                                                                let theAnswerToLifeTheUniverseAndEverything = 42
let gamma = 0.5772156649015328606051209008240243104215933593992
