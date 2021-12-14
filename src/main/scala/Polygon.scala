package d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._

// https://github.com/d3/d3-polygon
@JSImport("d3-polygon", JSImport.Namespace)
@js.native
object d3polygon extends js.Object {
  type Point   = js.Tuple2[Double, Double]
  type Polygon = js.Array[Point]

  def polygonArea(polygon: Polygon): Double                    = js.native
  def polygonCentroid(polygon: Polygon): Point                 = js.native
  def polygonHull(points: Polygon): Polygon | Null             = js.native
  def polygonContains(polygon: Polygon, point: Point): Boolean = js.native
  def polygonLength(polygon: Polygon): Boolean                 = js.native
}
