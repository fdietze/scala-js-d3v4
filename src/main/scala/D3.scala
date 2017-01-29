package org.scalajs

import scalajs.js.`|`
import scalajs.js
import scala.scalajs.js.annotation._

package d3v4 {
  object d3

  @js.native
  trait BaseEvent extends js.Object {
    var `type`: String = js.native
    var sourceEvent: dom.Event = js.native
  }
}

package object d3v4 {
  // type Primitive = Double | String | Boolean

  implicit def d3toD3Force(d3t: d3.type): d3force.type = d3force
  implicit def d3toD3Zoom(d3t: d3.type): d3zoom.type = d3zoom
  implicit def d3toD3Drag(d3t: d3.type): d3drag.type = d3drag
  implicit def d3toD3Polygon(d3t: d3.type): d3polygon.type = d3polygon
  implicit def d3toD3Selection(d3t: d3.type): d3selection.type = d3selection

  implicit class SelectionExtensions[Datum](s: Selection[Datum]) {
    def nodeAs[T <: dom.EventTarget] = s.node().asInstanceOf[T]
  }
}
