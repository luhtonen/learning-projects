// Functions
def hi = "hi"
hi

def hi2: String = "hi"

def multiplier(x: Int, y: Int): Int = { x * y }
multiplier(6, 7)

def safeTrim(s: String): String = {
  if (s == null) return null
  s.trim()
}

// Procedures
def log(d: Double) = println(f"Got value $d%.2f")
def log2(d: Double) = println(f"Got value $d%.2f")
log(2.23535)
// following format is unofficially deprecated and shouldn't be used
def log_deprecated(d: Double) { println(f"Got value $d%.2f") }

// Functions with Empty Parentheses
def hi3(): String = "hi"
hi3()
hi3

// Function Invocation with Expression Blocks
def formatEuro(amt: Double) =f"€$amt%.2f"
formatEuro(3.4645)
formatEuro { val rate = 1.32; 0.235 + 0.7123 + rate * 5.32 }

// Recursive Functions
def power(x: Int, n: Int): Long = {
  if (n >= 1) x * power(x, n-1)
  else 1
}
power(2, 8)
power(2, 1)
power(2, 0)

@annotation.tailrec
def power_optimized(x: Int, n: Int, t: Int = 1): Int = {
  if (n < 1) t
  else power_optimized(x, n-1, x*t)
}
power_optimized(2, 8)

// Nested Functions
def max(a: Int, b: Int, c: Int) = {
  def max(x: Int, y: Int) = if (x > y) x else y
  max(a, max(b, c))
}
max(42, 181, 19)

// Calling Functions with Named Parameters
def greet(prefix: String, name: String) = s"$prefix $name"
val greeting1 = greet("Mr", "Brown")
val greeting2 = greet(name="Brown", prefix="Mr")

// Parameters with Default Values
def greet1(prefix: String = "", name: String) = s"$prefix$name"
val greeting3 = greet1(name = "Paul")
def greet2(name: String, prefix: String = "") = s"$prefix$name"
val greet4 = greet2("Ola")

// Vararg Parameters
def sum(items: Int*): Int = {
  var total = 0
  for (i <- items) total += i
  total
}
sum(10, 20, 30)
sum()

// Parameter Groups
def max(x: Int)(y: Int) = if (x > y) x else y
val larger = max(20)(39)

// Type Parameters
def identity[A](a: A): A = a
identity[String]("Hello")
identity[Double](2.717)
identity("Hello")
identity(2.717)
val s = identity("Hello")
val d = identity(2.717)
