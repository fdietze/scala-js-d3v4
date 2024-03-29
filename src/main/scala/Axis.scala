package d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._
import d3._

// https://github.com/d3/d3-axis

@JSImport("d3-axis", JSImport.Namespace)
@js.native
object d3axis extends js.Object {
  def axisTop(scale: Scale): Axis    = js.native
  def axisRight(scale: Scale): Axis  = js.native
  def axisBottom(scale: Scale): Axis = js.native
  def axisLeft(scale: Scale): Axis   = js.native

  @js.native
  trait Axis extends js.Function {
    def apply(context: Selection[_]): Unit                 = js.native
    def scale(): Scale                                     = js.native
    def scale(scale: Scale): Axis                          = js.native
    def ticks(count: Int): Axis                            = js.native
    def ticks(count: Int, specifier: String): Axis         = js.native
    def ticks(interval: Interval): Axis                    = js.native
    def ticks(interval: Interval, specifier: String): Axis = js.native
    def ticks(arguments: js.Object*): Axis                 = js.native
    def tickArguments(): js.Array[js.Any]                  = js.native
    def tickArguments[T](arguments: js.Array[T]): Axis     = js.native
    def tickValues(): js.Array[js.Any]                     = js.native
    def tickValues[T](values: js.Array[T]): Axis           = js.native
    def tickFormat(): js.Array[js.Any]                     = js.native
    def tickFormat(format: js.Object): Axis                = js.native
    def tickSize(): Int                                    = js.native
    def tickSize(size: Int): Axis                          = js.native
    def tickSizeInner(): Int                               = js.native
    def tickSizeInner(size: Int): Axis                     = js.native
    def tickSizeOuter(): Int                               = js.native
    def tickSizeOuter(size: Int): Axis                     = js.native
    def tickPadding(): Int                                 = js.native
    def tickPadding(size: Int): Axis                       = js.native
  }
}
