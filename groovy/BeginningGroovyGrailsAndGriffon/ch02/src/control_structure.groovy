// Logical Branching
def x = 3.14
def result = ""

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