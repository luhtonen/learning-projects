// Groovy Constructors
// Java style
class Test1 {
    def i
    def j

    Test1(i, j) {
        this.i = i
        this.j = j
    }
}

def test1 = new Test1(1, 2)
assert test1.i == 1
assert test1.j == 2
println "$test1.i $test1.j"

// Groovy style
class Test2 {
    def i = 0
    def j = 0
}

def test2 = new Test2(i: 1, j: 2)
assert test2.i == 1
assert test2.j == 2
println "$test2.i $test2.j"

def test3 = new Test2(j: 2, i: 1)
assert test3.i == 1
assert test3.j == 2
println "$test3.i $test3.j"

def test4 = new Test2(i: 1)
assert test4.i == 1
assert test4.j == 0
println "$test4.i $test4.j"

println '==='

class A {
    def list = []

    A() {
        list << "A constructed"
    }

    A(int i) {
        this()
        list << "A constructed with $i"
    }

    A(String s) {
        this(5)
        list << "A constructed with '$s'"
    }
}

def a1 = new A()
assert a1.list == ["A constructed"]
println a1.list

def a2 = new A(7)
assert a2.list.collect { it } == [
        "A constructed",
        "A constructed with 7"
]
println a2.list

def a3 = new A('test')
assert a3.list.collect { it } == [
        "A constructed",
        "A constructed with 5",
        "A constructed with 'test'"
]
println a3.list

// Inheritance
println '==='

class AB extends A {}

def b = new AB()
assert b in AB && b in A
println "b in BB ${b in AB} && b in A ${b in A}"
assert 1 in [1, 2, 3, 4]

class AA {
    int x
    int y

    String methodA(int n) { "value ${x = y = n}" }
}

class BA extends AA {
    String methodB(int n) { "value $n" }
}

def ba = new BA()
assert ba.methodB(10) == 'value 10'
println "ba.methodB(10) ${ba.methodB(10)}"
assert ba.methodA(20) == 'value 20'
println "ba.methodA(20) ${ba.methodA(20)}"
assert ba.x == 20
assert ba.y == 20
println "ba.x = ${ba.x}, ba.y = ${ba.y}"
ba.y = 5
assert ba.y == 5
assert ba.getY() == 5
println "ba.y = ${ba.y}"

println '==='

interface X {
    def x()
}

interface Y {
    def y()
}

abstract class AAA {
    def a() { println 1 }

    abstract b()
}

class BBB extends AAA implements X, Y {
    def x() { println 2 }

    def y() { println 3 }

    def b() { println 4 }
}

def bbb = new BBB()
bbb.a()
bbb.b()
bbb.x()
bbb.y()

println '==='

class AAAA {
    final a() { 11 }

    def b() { 12 }
}

final class BBBB extends AAAA {
    // def a() { 15 } method a is final and cannot be overridden
    def b() { 16 }
}
// class C extends BBBB class BBBB is final and cannot be extended

class B extends A {
    B() {
        list << "B constructed"
    }

    B(String s) {
        super(5)
        list << "B constructed with '$s'"
    }
}

def b1 = new B('Test')
println b1.list
assert b1.list.collect { it } == [
        "A constructed",
        "A constructed with 5",
        "B constructed with 'Test'"
]
def b2 = new B()
println b2.list
assert b2.list.collect { it } == [
        "A constructed",
        "B constructed"
]

// Polymorphism
println '==='
class Square {
    def display() {
        assert "length:${length} width:${width}" == "length:10 width:10"
    }
    def length
    def width
}
class Rectangle {
    def display() {
        assert "length:${length} width:${width}" == "length:10 width:12"
    }
    def length
    def width
}
def shapes = [new Square(length: 10, width: 10),
        new Rectangle(length: 10, width: 12)
]
shapes.each { item -> item.display() }
