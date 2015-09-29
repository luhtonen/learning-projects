// Expandos
def multiplier = new Expando()
multiplier.value = 5
multiplier.doubleIt = { -> multiplier.value = multiplier.value * 2 }
multiplier.doubleIt()
assert multiplier.value == 10
println multiplier.value

// ExpandoMetaClass
// Borrowing Methods from Other Classes
println "==="
class Author {
    String name
}
class Greet {
    def sayHello() {
        "hello edu"
    }
}
def hello = new Greet()
Author.metaClass.greet = hello.&sayHello // assign the sayHello() method to Author using ExpandoMetaclass
def author = new Author()
assert author.greet() == "hello edu"
println author.greet()

class Test {
    String name = "foo"
}
def newName = 'bar'
Test.metaClass."changeNameTo${newName}" = { -> delegate.name = 'bar' }
def m = new Test()
assert m.name == 'foo'
println m.name
m.changeNameTobar()
assert m.name == 'bar'
println m.name

// Adding Constructors
println "==="
class Book {
    String title
}
Book.metaClass.constructor << { String title -> new Book(title:title) }
def b = new Book('Beginning Groovy, Grails and Griffon')
assert 'Beginning Groovy, Grails and Griffon' == b.title
println b.title

// Adding Properties
println "==="
Book.metaClass.getAuthor << { -> "Vishal Layka" }
def b1 = new Book('Beginning Groovy, Grails and Griffon')
assert 'Beginning Groovy, Grails and Griffon' == b1.title
println b1.title
assert 'Vishal Layka' == b1.author
println b1.author

// Adding Methods on Interfaces
println "==="
List.metaClass.sizeDoubled = { -> delegate.size() *  2 }
def list = []
list << 1
list << 2
assert 4 == list.sizeDoubled()
println list.sizeDoubled()

// Adding or Overriding Instance Methods
println "==="
Book.metaClass.titleToUpperCase << { -> title.toUpperCase() }
def b2 = new Book(title:"Beginning Groovy, Grails and Griffon")
assert 'BEGINNING GROOVY, GRAILS AND GRIFFON' == b2.titleToUpperCase()
println b2.titleToUpperCase()

// Adding or Overriding Static Methods
println "==="
Book.metaClass.static.create << { String title -> new Book(title:title) }
def b3 = Book.create("Beginning Groovy, Grails and Griffon")
assert "Beginning Groovy, Grails and Griffon" == b3.title
println b3.title
