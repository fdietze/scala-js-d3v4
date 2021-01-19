import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation._

/** @see [[https://github.com/d3/d3-transition]] */
@JSImport("d3-transition", JSImport.Namespace)
@js.native
object d3transition extends js.Object {

  /** @see [[https://github.com/d3/d3-transition#transition]] */
  def transition(): Transition[dom.EventTarget] = js.native

  /** @see [[https://github.com/d3/d3-transition#transition]] */
  def transition(name: String): Transition[dom.EventTarget] = js.native

  /** @see [[https://github.com/d3/d3-transition#transition_duration]] */
  def duration(value: Double): Transition[dom.EventTarget] = js.native

  @js.native
  trait Transition[Datum] extends js.Object {

    /** @see [[https://github.com/d3/d3-transition#transition_duration]] */
    def duration(value: Double): Transition[Datum] = js.native

  }

}
