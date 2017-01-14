package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{native, Object, undefined, `|`}
import scala.scalajs.js.annotation._
import org.scalajs.dom

@js.native
trait d3 extends js.Object

@js.native
object d3 extends d3

@js.native
trait BaseEvent extends js.Object {
  var `type`: String = js.native
  var sourceEvent: dom.Event = js.native
}
