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

