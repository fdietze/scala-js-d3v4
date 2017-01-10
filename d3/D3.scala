package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{native, Object, undefined}
import scala.scalajs.js.annotation._

@js.native
trait d3 extends js.Object

@js.native
object d3 extends d3

//TODO: move where?
@native
trait Transform extends Object {
  override def toString: String = native
  def applyX(x: Double): Double = native
  def applyY(x: Double): Double = native
  def invertX(x: Double): Double = native
  def invertY(x: Double): Double = native
  def x: Double = native
  def y: Double = native
  def k: Double = native
  def translate(x: Double, y: Double): Transform
  def scale(k: Double): Transform
}
