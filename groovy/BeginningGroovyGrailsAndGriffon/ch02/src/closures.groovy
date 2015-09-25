def closureVar = { println 'Hello world' }
println "closure is not called yet!"
println ""
closureVar.call()

closureVar = { param -> println "Hello ${param}" }
closureVar.call('world')
closureVar('implicit world')

def sayHello = { str1, str2 = "default world" -> println "${str1} ${str2}" }
sayHello("Hello", "world")
sayHello("Hello")

def sum = { list -> return list.sum() }
assert sum([2, 2]) == 4
println sum([2, 2])

sum = { list -> list.sum() }
assert sum([2, 2]) == 4
println sum([2, 2])

def myCount = 5
def incByMyCount = { num -> num + myCount }
println incByMyCount(10)

// Implicit variables: it
def clos = { println "Hello ${it}" }
clos.call('world')

// this, owner and delegate
class Class1 {
    def closure = {
        println '--- in closure ---'
        println this.class.name
        println owner.class.name
        println delegate.class.name
        def nestedClosure = {
            println '--- in nested closure ---'
            println this.class.name
            println owner.class.name
            println delegate.class.name
        }
        nestedClosure()
    }
}

def clos1 = new Class1().closure
clos1()
println ''
println '=== changing the delegate ==='
clos1.delegate = this
clos1()
println ''

def closure2 = {
    println '--- closure outside the class (in the script) ---'
    println this.class.name
    println owner.class.name
    println delegate.class.name
}
closure2()

// Explicit Declaration of Closure
Closure clos2 = { println it }
clos2('hello from closure')

// Reusing the Method as a Closure
def list = ["Arno", "Lauri", "Kristian", "Karoliina"]
list.each { println it }
println "==="

String printName(String name) {
    println name
}

list.each(this.&printName)

println '==='
def sayHi = { println it }
list.each(sayHi)

// Closures and Collections
// any
println '==='
def anyElement = [1, 2, 3, 4, 5].any { element -> element > 2 }
assert anyElement
println anyElement

// collect
println '==='
def doubled = [1, 2, 3, 4].collect { element -> element * 2 }
assert doubled == [2, 4, 6, 8]
println doubled

// each
println '==='
[1, 2, 3].each { println it }

// every
println '==='
def allElements1 = [1, 2, 3, 4].every { element -> element > 1 }
assert !allElements1
println "allElements1 ${allElements1}"

def allElements2 = [2, 3, 4, 5].every { element -> element > 1 }
assert allElements2
println "allElements2 ${allElements2}"

// find
println '==='
def foundElement = [1, 2, 3, 4].find { element -> element > 2 }
assert foundElement == 3
println "foundElement = ${foundElement}"

// Closures as Map Keys and Values
key1 = { println "closure as key" }
map1 = [(key1): 100]

println '==='
println map1.get(key1)
println map1[key1]

map1 = [key1: { println "closure as value" }]
map1.key1()

// Currying Closure
println '==='
def add = { x, y -> return x + y }
assert add(1, 2) == 3
println add(1, 2)

def newAdd = add.curry(1)
assert newAdd(2) == 3
println "newAdd(2) = ${newAdd(2)}"

// Closure Trampoline
println '==='
def factorial
factorial = { n, BigInteger acc = 1 ->
    n == 1 ? acc : factorial.trampoline(n - 1, n * acc)
}.trampoline()
println "factorial(1000) = ${factorial(1000)}"

// Closure Memoization
println '==='
closure = { param1, param2 -> sleep(100); param1 + param2 }
memoizedClosure = closure.memoize()
def testTime(param1, param2) {
    begin = System.currentTimeMillis()
    memoizedClosure(param1, param2)
    timeElapsed = System.currentTimeMillis()
    println "param1 = $param1, param2 = $param2, time: ${timeElapsed - begin} ms."
}
testTime(1, 2)
testTime(3, 4)
testTime(1, 2)
