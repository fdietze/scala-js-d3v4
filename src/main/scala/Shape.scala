package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._

// https://github.com/d3/d3-shape
@JSImport("d3-shape", JSImport.Namespace)
@js.native
object d3shape extends js.Object {
  def pie():PieGenerator = js.native
  def arc():ArcGenerator = js.native
  def line(): LineGenerator = js.native
  def curveCatmullRomClosed: CurveCatmullRomFactory = js.native
}

@js.native
trait BaseLineGenerator[G <: BaseLineGenerator[G]] extends js.Object {
  def curve(curve:CurveFactory):G = js.native
}

@js.native
trait LineGenerator extends BaseLineGenerator[LineGenerator] {
  def apply(data:js.Array[js.Array[Double]]):String = js.native
}

@js.native
trait CurveFactory extends js.Object {
}

@js.native
trait CurveCatmullRomFactory extends CurveFactory {
  def alpha(alpha:Double):CurveCatmullRomFactory = js.native
}


@js.native
trait PieGenerator extends js.Object {
  def value(value:Double):PieGenerator = js.native
  def padAngle(angle:Double):PieGenerator = js.native
  def apply[Datum](data: js.Array[Datum]): js.Array[PieArcDatum[Datum]] = js.native
}

@js.native
trait PieArcDatum[Datum] extends ArcDatum {
def data: Datum = js.native
def value: Double = js.native
def index: Int = js.native
def startAngle: Double = js.native
def endAngle: Double = js.native
def padAngle: Double = js.native
}

@js.native
trait ArcDatum extends js.Object

@js.native
trait BaseArcGenerator[G <: BaseArcGenerator[G]] extends js.Object {
  def innerRadius(radius:Double):G = js.native
  def outerRadius(radius:Double):G = js.native
  def cornerRadius(radius:Double):G = js.native
}

@js.native
trait ArcGenerator extends BaseArcGenerator[ArcGenerator] {
  def apply[T <: ArcDatum](arguments:T):String = js.native
  def centroid[T <: ArcDatum](arguments:T):js.Array[Double] = js.native
}

@js.native
trait ArcGeneratorWithContext extends BaseArcGenerator[ArcGeneratorWithContext] {
  def apply[T <: ArcDatum](arguments:T):Unit = js.native
}
