package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{native, Object, undefined, `|`}
import scala.scalajs.js.annotation._
import org.scalajs.dom

// https://github.com/d3/d3-drag
package object drag {
  implicit def d3Drag(jq: d3): D3Drag = jq.asInstanceOf[D3Drag]

  @js.native
  trait D3Drag extends d3 {
  }

  @js.native
  trait DragEvent extends BaseEvent {
    var x: Double = js.native
    var y: Double = js.native
    var dx: Double = js.native
    var dy: Double = js.native
  }
}
