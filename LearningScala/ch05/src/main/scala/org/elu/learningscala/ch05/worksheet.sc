// Function Types and Values
def double(x: Int): Int = x * 2
double(5)

val myDouble: (Int) => Int = double
myDouble(5)

val myDoubleCopy = myDouble
myDoubleCopy(5)

val myDouble2 = double _
val amount = myDouble2(20)

def max(a: Int, b: Int) = if (a > b) a else b
val maximize: (Int, Int) => Int = max
maximize(50, 30)

def logStart() = "=" * 50 + "\nStarting NOW\n" + "=" * 50
val start: () => String = logStart
println(start())

// Higher-Order Functions
def safeStringOp(s: String, f: String => String) = {
  if (s != null) f(s) else s
}
def reverser(s: String) = s.reverse
safeStringOp(null, reverser)
safeStringOp("Ready", reverser)

// Function Literals
val doubler = (x: Int) => x * 2
val doubled = doubler(22)

val greeter = (name: String) => s"Hello, $name"
val hi = greeter("World")

val maximize2 = (a:Int, b: Int) => if(a > b) a else b

val start2 = () => "=" * 50 + "\nStarting NOW\n" + "=" * 50
println(start2())

safeStringOp(null, (s: String) => s.reverse)
safeStringOp("Ready", (s: String) => s.reverse)

safeStringOp(null, s => s.reverse)
safeStringOp("Ready", s => s.reverse)

// Placeholder Syntax
val doubler2: Int => Int = _ * 2

safeStringOp(null, _.reverse)
safeStringOp("Ready", _.reverse)

def combination(x: Int, y: Int, f: (Int, Int) => Int) = f(x,y)
combination(23, 12, _ * _)

def tripleOp(x: Int, y: Int, z: Int, f: (Int, Int, Int) => Int) = f(x, y, z)
tripleOp(23, 92, 14, _ * _ + _)

def tripleOp2[A,B](a: A, b: A, c: A, f: (A, A, A) => B) = f(a,b,c)
tripleOp2[Int, Int](23, 92, 14, _ * _ + _)
tripleOp2[Int, Double](23, 92, 14, 1.0 * _ / _ / _)
tripleOp2[Int, Boolean](23, 92, 14, _ > _ + _)
