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

list.remove 2
list -= "Lauri"
list.each { println it }

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
