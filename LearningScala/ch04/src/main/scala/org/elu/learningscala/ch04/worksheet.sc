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

