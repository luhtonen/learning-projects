// Traits
trait HtmlUtils {
  def removeMarkup(input: String) = {
    input
      .replaceAll( """</?\w[^>]*>""", "")
      .replaceAll("<.*>", "")
  }
}
class Page(val s: String) extends HtmlUtils {
  def asPlainText = removeMarkup(s)
}
new Page("<html><body><h1>Introduction</h1></body></html>").asPlainText

trait SafeStringUtils {
  // Returns a trimmed version of the string wrapped in an Option,
  // or None if the trimmed string is empty.
  def trimToNone(s: String): Option[String] = {
    Option(s) map (_.trim) filterNot(_.isEmpty)
  }
}
class Page1(val s: String) extends SafeStringUtils with HtmlUtils {
  def asPlainText: String = {
    trimToNone(s) map removeMarkup getOrElse "n/a"
  }
}
new Page1("<html><body><h1>Introduction</h1></body></html>").asPlainText
new Page1(" ").asPlainText
new Page1(null).asPlainText

trait Base { override def toString = "Base" }
class A extends Base { override def toString = "A->" + super.toString }
trait B extends Base { override def toString = "B->" + super.toString }
trait C extends Base { override def toString = "C->" + super.toString }
class D extends A with B with C { override def toString = "D->" + super.toString }
new D()


class RGBColor(val color: Int) {
  def hex = f"$color%06X"
}
val green = new RGBColor(255 << 8).hex
trait Opaque extends RGBColor { override def hex = s"${super.hex}FF"}
trait Sheer extends RGBColor { override def hex = s"${super.hex}33"}
class Paint(color: Int) extends RGBColor(color) with Opaque
class Overlay(color: Int) extends RGBColor(color) with Sheer
val red = new Paint(128 << 16).hex
val blue = new Overlay(192).hex

// Self Types
class A1 {
  def hi = "hi"
}
trait B1 { self: A1 =>
  override def toString = "B: " + hi
}
//class C1 extends B1
// this class definition cause the following error
//<console>:9: error: illegal inheritance;
//  self-type C1 does not conform to B1's selftype B1 with A1
//       class C1 extends B1
//                        ^
class C1 extends A1 with B1
new C1()

class TestSuite(suiteName: String) {
  def start() {}
}
trait RandomSeeded { self: TestSuite =>
  def randomStart(): Unit = {
    util.Random.setSeed(System.currentTimeMillis())
    self.start()
  }
}
class IdSpec extends TestSuite("ID Tests") with RandomSeeded {
  def testId(): Unit = {
    println(util.Random.nextInt != 1)
  }
  override def start(): Unit = {
    testId()
  }
  println("Starting...")
  randomStart()
}
new IdSpec()

// Instantiation with Traits
class A2
trait B2 {self: A2 => }
val a = new A2 with B2

class User(val name: String) {
  def suffix = ""
  override def toString = s"$name$suffix"
}
trait Attorney { self: User =>
  override def suffix = ", esq."
}
trait Wizard { self: User =>
  override def suffix = ", Wizard"
}
trait Reverser {
  override def toString = super.toString.reverse
}
val h = new User("Harry P") with Wizard
val g = new User("Ginny W") with Attorney
val l = new User("Luna L") with Wizard with Reverser
