package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._

// https://github.com/d3/d3-polygon
@JSImport("d3-polygon", JSImport.Namespace)
@js.native
object d3polygon extends js.Object {
  def polygonHull(points: js.Array[js.Array[Double]]): js.Array[js.Array[Double]] | Null = js.native
}
