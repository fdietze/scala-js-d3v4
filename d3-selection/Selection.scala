package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{native, Object, undefined}
import scala.scalajs.js.annotation._

package object selection {
  implicit def d3Selection(jq: d3): D3Selection = jq.asInstanceOf[D3Selection]

  @js.native
  trait D3Selection extends d3 {
    def event: Event = native
  }

  @native
  trait Event extends Object {
    def transform: Transform = native
    def x: Double = native
    def y: Double = native
  }
}
