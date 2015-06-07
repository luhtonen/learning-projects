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
