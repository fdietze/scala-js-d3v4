package d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._

// https://github.com/d3/d3-axis

@JSImport("d3-axis", JSImport.Namespace)
@js.native
object d3axis extends js.Object {
  def axisBottom(scale: Scale): AxisGenerator = js.native
}

@js.native
trait AxisGenerator extends js.Function {
}
