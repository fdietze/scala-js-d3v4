package d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._
import org.scalajs.dom
import d3._

// https://github.com/d3/d3-array
@JSImport("d3-array", JSImport.Namespace)
@js.native
object d3array extends js.Object {
  def extent[T](array: js.Array[T]): js.Array[T]                                  = js.native
  def extent[T, R](array: js.Array[T], accessor: js.Function1[T, R]): js.Array[R] = js.native
}
