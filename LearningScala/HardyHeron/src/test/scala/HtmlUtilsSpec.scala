import org.scalatest._

/** Created by luhtonen on 01/07/15. */
class HtmlUtilsSpec extends FlatSpec with ShouldMatchers {

  "The Html Utils object" should "remove single element" in {
    HtmlUtils.removeMarkup("</br>") should equal("")
  }

  it should "remove paired element" in {
    HtmlUtils.removeMarkup("<b>Hi</b>") should equal("Hi")
  }

  it should "have no effect on empty string" in {
    val empty = true
    HtmlUtils.removeMarkup("").isEmpty should be(empty)
  }

  it should "remove embedded elements" in {
    HtmlUtils.removeMarkup("<body><p>Hi</p></body>") should equal("Hi")
  }

  it should "remove JavaScript withing script element" in {
    HtmlUtils.removeMarkup("<script>console.log('Hi')</script><p>Hi</p>") should equal("Hi")
  }
}
