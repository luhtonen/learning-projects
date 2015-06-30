// Traits
trait HtmlUtls {
  def removeMarkup(input: String) = {
    input
      .replaceAll( """</?\w[^>]*>""", "")
      .replaceAll("<.*>", "")
  }
}
class Page(val s: String) extends HtmlUtls {
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
class Page1(val s: String) extends SafeStringUtils with HtmlUtls {
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
