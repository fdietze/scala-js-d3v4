package d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._
import org.scalajs.dom
import d3._

// https://github.com/d3/d3-drag
@JSImport("d3-drag", JSImport.Namespace)
@js.native
object d3drag extends js.Object {
  def drag[Datum](): DragBehavior[Datum] = js.native

  @js.native
  trait DragEvent extends BaseEvent {
    var x: Double  = js.native
    var y: Double  = js.native
    var dx: Double = js.native
    var dy: Double = js.native
  }

  @js.native
  trait DragBehavior[Datum] extends js.Function1[Selection[Datum], Unit] {
    def on(typenames: String, listener: ListenerFunction0): DragBehavior[Datum]                                = js.native
    def on(typenames: String, listener: ListenerFunction1[Datum]): DragBehavior[Datum]                         = js.native
    def on(typenames: String, listener: ListenerFunction2[Datum]): DragBehavior[Datum]                         = js.native
    def on[E <: CurrentDom](typenames: String, listener: ListenerThisFunction2[E, Datum]): DragBehavior[Datum] =
      js.native

    type DragSubject = js.Object // {def x:Double; def y:Double}
    def subject(subject: ValueFunction2[Datum, DragSubject]): DragBehavior[Datum] = js.native

    def subject[E <: CurrentDom](subject: ValueThisFunction0[E, DragSubject]): DragBehavior[Datum]        = js.native
    def subject[E <: CurrentDom](subject: ValueThisFunction1[E, Datum, DragSubject]): DragBehavior[Datum] = js.native
    def subject[E <: CurrentDom](subject: ValueThisFunction2[E, Datum, DragSubject]): DragBehavior[Datum] = js.native

    def clickDistance(distance: Double): DragBehavior[Datum] = js.native
    def clickDistance(): Double                              = js.native
  }
}
