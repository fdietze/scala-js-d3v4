package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{native, Object, undefined}
import scala.scalajs.js.annotation._

// https://github.com/d3/d3-zoom
package object zoom {
  implicit def d3Zoom(jq: d3): D3Zoom = jq.asInstanceOf[D3Zoom]

  @js.native
  trait D3Zoom extends d3 {
    def zoomIdentity: Transform = native
  }
}
