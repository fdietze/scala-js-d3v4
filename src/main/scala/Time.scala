package d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._

// https://github.com/d3/d3-time

@JSImport("d3-time", JSImport.Namespace)
@js.native
object d3time extends js.Object {
  def timeDay: Interval = js.native
  def timeMonday: Interval = js.native
  def timeMonth: Interval = js.native
}

@js.native
trait Interval extends js.Object {
  def apply(d: js.Date): js.Date = js.native
  def floor(d: js.Date): js.Date = js.native
  def round(d: js.Date): js.Date = js.native
  def ceil(d: js.Date): js.Date = js.native
  def offset(date: js.Date, step: Double): js.Date = js.native
  def range(start: js.Date, stop: js.Date, step: Double): js.Array[js.Date] = js.native
}
