package d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._

// https://github.com/d3/d3-scale

@JSImport("d3-scale", JSImport.Namespace)
@js.native
object d3scale extends js.Object {
  def scaleLinear(): LinearScale                           = js.native
  def scaleLog(): LogScale                                 = js.native
  def scaleTime(): TimeScale                               = js.native
  def scaleBand[T,R](): BandScale[T,R]                     = js.native
  def scaleOrdinal[T,R](values: js.Array[String]): OrdinalScale[T,R] = js.native
  def schemeCategory10: js.Array[String]                   = js.native
  def schemeCategory20: js.Array[String]                   = js.native
  def schemeCategory20b: js.Array[String]                  = js.native
  def schemeCategory20c: js.Array[String]                  = js.native

  @js.native
  trait Scale extends js.Object

  @js.native
  trait ContinuousScale[S <: ContinuousScale[S]] extends Scale {
    def apply(value: Double): Double            = js.native
    def invert(value: Double): Double           = js.native
    def domain(domain: js.Array[Double]): S     = js.native
    def range(range: js.Array[Double]): S       = js.native
    def rangeRound(range: js.Array[Double]): S  = js.native
  }

  @js.native
  trait LogScale extends ContinuousScale[LogScale] {
    def base(base: Double): LogScale = js.native
  }

  @js.native
  trait LinearScale extends ContinuousScale[LinearScale] {}

  @js.native
  trait TimeScale extends ContinuousScale[TimeScale] {
    def apply(value: js.Date): Double                = js.native
    def domain(domain: js.Array[js.Date]): TimeScale = js.native
  }

  @js.native
  trait OrdinalScale[T,R] extends Scale {
    def domain(values: js.Array[T]): this.type    = js.native
    def domain(): js.Array[T]                     = js.native
    def range(): this.type                        = js.native
    def range(range: js.Array[R]): this.type      = js.native
    def apply(string: String): js.Any             = js.native
  }

  @js.native
  trait BandScale[T,R] extends OrdinalScale[T,R] {
    def apply(value: T): js.Any                           = js.native
    def bandwidth(): Double                               = js.native
    def rangeRound(range: js.Array[R]): this.type         = js.native
    def padding(padding: Double): this.type               = js.native
  }
}
