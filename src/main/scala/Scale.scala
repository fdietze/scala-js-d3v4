package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._

// https://github.com/d3/d3-scale

@JSImport("d3-scale", JSImport.Namespace)
@js.native
object d3scale extends js.Object {
  def scaleLinear(): LinearScale = js.native
  def scaleLog(): LogScale = js.native
  def scaleTime(): TimeScale = js.native
}

@js.native
trait Scale extends js.Object

@js.native
trait ContinuousScale[S <: ContinuousScale[S]] extends Scale {
  def apply(value: Double): Double = js.native
  def invert(value: Double): Double = js.native
  def domain(domain: js.Array[Double]): S = js.native
  def range(range: js.Array[Double]): S = js.native
}

@js.native
trait LogScale extends ContinuousScale[LogScale] {
  def base(base: Double): LogScale = js.native
}

@js.native
trait LinearScale extends ContinuousScale[LinearScale] {
}

@js.native
trait TimeScale extends ContinuousScale[TimeScale] {
  def apply(value: js.Date): Double = js.native
  def domain(domain: js.Array[js.Date]): TimeScale = js.native
}
