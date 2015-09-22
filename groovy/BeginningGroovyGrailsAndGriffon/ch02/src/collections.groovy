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

