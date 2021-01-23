import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * @see [[https://github.com/d3/d3-hierarchy]]
 * @since January, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
@JSImport("d3-hierarchy", JSImport.Namespace)
@js.native
object d3hierarchy extends js.Object {

  /** @see [[https://github.com/d3/d3-hierarchy#hierarchy]] */
  def hierarchy[Datum](data: Datum): Node[Datum] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#hierarchy]] */
  def hierarchy[Datum](data: Datum, children: js.Function1[Datum, js.Array[Datum]]): Node[Datum] = js.native

  @js.native
  trait Node[Datum] extends js.Object {
    def data: Datum = js.native
    def depth: Int = js.native
    def height: Int = js.native
    def parent: Node[Datum] = js.native
  }

}
