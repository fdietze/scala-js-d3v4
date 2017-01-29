package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._
import org.scalajs.dom

// https://github.com/d3/d3-drag
@JSImport("d3-drag", JSImport.Namespace)
@js.native
object d3drag extends js.Object {
}

@js.native
trait DragEvent extends BaseEvent {
  var x: Double = js.native
  var y: Double = js.native
  var dx: Double = js.native
  var dy: Double = js.native
}
