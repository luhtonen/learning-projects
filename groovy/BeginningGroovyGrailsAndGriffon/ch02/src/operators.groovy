// Spread Operator
def map = [1: "Arno", 2: "Lauri", 3: "Kristian", 4: "Karoliina"]
def keys = [1, 2, 3, 4]
def values = ["Arno", "Lauri", "Kristian", "Karoliina"]
println "map = ${map}"
assert map*.key == keys
assert map*.value == values
println "map*.key = ${map*.key}"
println "map*.value = ${map*.value}"

// Elvis Operator
class User {
    String firstName
}
println "==="
user = new User()
def firstName1 = user.firstName == null ? "unknown" : user.firstName
def firstName2 = user.firstName ?: "unknown"
println "firstName1 = ${firstName1}"
println "firstName2 = ${firstName2}"

// Safe Navigation/Dereference Operator
println "==="
User user1
if (user1 != null) {
    println "Java FirstName = ${user1.firstName}"
}
println "Groovy FirstName = ${user1?.firstName}"

// Field Operator
println "==="
class Todo {
    String name
    def getName() {
        println "Getting Name"
        name
    }
}
def todo = new Todo(name: 'Jim')
println todo.name
println todo.@name

// Method Closure Operator
println "==="
def list = ["Arno", "Lauri", "Kristian"]
// each takes a closure
list.each { println it }
String printName(String name) {
    println name
}
// & causes the method to be accepted as a closure
list.each(this.&printName)

// Diamond Operator
println "==="
List<List<String>> list1 = new ArrayList<List<String>>()
List<List<String>> list2 = new ArrayList<>()
