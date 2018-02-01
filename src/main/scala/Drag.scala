package d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._
import org.scalajs.dom

// https://github.com/d3/d3-drag
@JSImport("d3-drag", JSImport.Namespace)
@js.native
object d3drag extends js.Object {
  def drag[Datum](): DragBehavior[Datum] = js.native
}

@js.native
trait DragEvent extends BaseEvent {
  var x: Double = js.native
  var y: Double = js.native
  var dx: Double = js.native
  var dy: Double = js.native
}

@js.native
trait DragBehavior[Datum] extends js.Function1[Selection[Datum], Unit] with DatumFunctionTypes[Datum] {
  def on[E <: CurrentDomElement](typenames: String, listener: ListenerFunction[E]): DragBehavior[Datum] = js.native

  def clickDistance(distance: Double): DragBehavior[Datum] = js.native
  def clickDistance(): Double = js.native
}
