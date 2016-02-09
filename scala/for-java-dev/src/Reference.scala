/** Created by luhtonen on 09/02/16. */
class Reference[T] {
  private var contents: T = _

  def set(value: T) { contents = value }
  def get: T = contents
}
