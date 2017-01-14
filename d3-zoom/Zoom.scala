package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{native, Object, undefined, `|`}
import scala.scalajs.js.annotation._
import org.scalajs.dom

// https://github.com/d3/d3-zoom
package object zoom {
  implicit def d3Zoom(jq: d3): D3Zoom = jq.asInstanceOf[D3Zoom]

  @js.native
  trait D3Zoom extends d3 {
    def zoomIdentity: Transform = native
  }

  @native
  trait Transform extends Object {
    override def toString: String = native
    def applyX(x: Double | js.UndefOr[Double]): Double = native
    def applyY(x: Double | js.UndefOr[Double]): Double = native
    def apply(point: js.Array[Double]): js.Array[Double] = native
    def invertX(x: Double | js.UndefOr[Double]): Double = native
    def invertY(x: Double | js.UndefOr[Double]): Double = native
    def invert(point: js.Array[Double]): js.Array[Double] = native
    def x: Double = native
    def y: Double = native
    def k: Double = native
    def translate(x: Double | js.UndefOr[Double], y: Double | js.UndefOr[Double]): Transform
    def scale(k: Double | js.UndefOr[Double]): Transform
  }

  @js.native
  trait ZoomEvent extends BaseEvent {
    def transform: Transform = native
  }
}
