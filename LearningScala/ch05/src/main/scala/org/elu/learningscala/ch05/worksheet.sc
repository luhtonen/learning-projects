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

