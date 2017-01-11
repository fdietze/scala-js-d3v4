package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{native, Object, undefined, `|`}
import scala.scalajs.js.annotation._

// https://github.com/d3/d3-polygon
package object polygon {
  implicit def d3Polygon(jq: d3): D3Polygon = jq.asInstanceOf[D3Polygon]

  @js.native
  trait D3Polygon extends d3 {
    def polygonHull(points: js.Array[js.Array[Double]]): js.Array[js.Array[Double]] | Null = native
  }
}
