package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{native, Object, undefined, `|`}
import scala.scalajs.js.annotation._
import org.scalajs.dom

// https://github.com/d3/d3-selection
package object selection {
  implicit def d3Selection(jq: d3): D3Selection = jq.asInstanceOf[D3Selection]

  @js.native
  trait D3Selection extends d3 {
    var event: dom.Event | BaseEvent = native
    def mouse(container: dom.raw.HTMLElement | dom.raw.SVGElement): js.Array[Double]
  }

}
