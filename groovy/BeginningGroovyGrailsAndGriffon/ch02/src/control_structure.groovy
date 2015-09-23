// Logical Branching
def x = 3.14
def result

switch (x) {
    case "foo":
        result = "String"
        break

    case [4, 5, 6]:
        result = "List"
        break

    case 12..30:
        result = "Range"
        break

    case Integer:
        result = "Integer"
        break

    case Number:
        result = "Number"
        break

    default:
        result = "Default"
}

assert result == "Number"
println result == "Number"

// Looping
for (i in 'Hello')
    println i
for (i in 0..10)
    println i
for (i in [1,2,3,4])
    println i

authors = [1:'Vishal', 2:'Jim', 3: 'Chris', 4:'Joseph']
for (entry in authors)
    println entry.key + ' ' + entry.value
