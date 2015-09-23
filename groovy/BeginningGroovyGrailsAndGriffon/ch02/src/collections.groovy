// Arrays
def stringArray = new String[3]
println stringArray.length
stringArray[0] = "Arno"
println stringArray
stringArray[1] = "Lauri"
stringArray[2] = "Kristian"
println stringArray
println stringArray[1]
stringArray.each { println it }
println stringArray[-1..-3]

// Lists
def emptyList = []
println emptyList.class.name
println emptyList.size()

def list = ["Arno"]
list.add "Lauri"
list << "Kristian"
println list.size()

list.each { println it }

println list[1]
list[0] = "Karoliina"
println list.get(0)

list.set(0, "Arno")
println list.get(0)

println "==="
list.removeAt 2
list -= "Lauri"
list.each { println it }
println "==="

list.add "Lauri"
list += "Kristian"
list.each { println it }
println list[-1]

// Maps
def emptyMap = [:]
println emptyMap.getClass().name
println emptyMap.size()

def todos = ['a': 'Write the map section', 'b': 'Write the set section']
println todos.size()
println todos["a"]
println todos."a"
println todos.a
println todos.getAt("b")
println todos.get("b")
println todos.get("c", "unknown")
println todos

todos.d = "Write ranges section"
println todos.d
todos.put('e', 'Write strings section')
println todos.e
todos.putAt 'f', 'Write closure section'
println todos.f
todos[null] = 'Nothing Set'
println todos[null]

todos.each { println "Key: ${it.key}, Value: ${it.value}" }
todos.eachWithIndex { it, i -> println "${i} Key: ${it.key}, Value: ${it.value}" }
todos.values().each { println it }

// Ranges
def numRange = 0..9
println numRange.size()
numRange.each { print it }
println ""
println numRange.contains(5)

def alphaRange = 'a'..'z'
println alphaRange.size()
println alphaRange[1]

def exlusiveRange = 1..<10
println exlusiveRange.size()
exlusiveRange.each { print it }
println ""
println exlusiveRange.contains(10)

def reverseRange = 9..0
reverseRange.each { print it }
println ""

println "Java style for loop"
for (int i = 0; i <= 9; i++) {
    println i
}

println "Groovy style for loop"
for (i in 0..9) {
    println i
}

println "Groovy range loop"
(0..9).each { i ->
    println i
}

// Sets
def emptySet = [] as Set
println emptySet.class.name
println emptySet.size()

list = ["Arno", "Arno"]
def set = ["Arno", "Arno"] as Set
println "List size: ${list.size()}, Set size: ${set.size()}"
set.add "Lauri"
set << "Kristian"
println set

set.each { println it }

set.remove 2 // does not working, because Set is not ordered and don't have indexes
set -= "Lauri"
println "==="
set.each { println it }
println "==="
set.removeElement "Kristian"
set.each { println it }
println "==="
set += "Lauri"
set += "Kristian"
set.each { println it }
println "==="

// Convert set to list
list = set as List
println list.class.name
println set.asList().class.name
println set.toList().class.name