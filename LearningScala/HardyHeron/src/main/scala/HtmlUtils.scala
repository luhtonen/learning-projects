/** Created by luhtonen on 01/07/15. */
object HtmlUtils {
  def removeMarkup(input: String) = {
    input
      .replaceAll("<script>.*</script>","")
      .replaceAll("""</?\w[^>]*>""","")
      .replaceAll("<.*>","")
  }
}
