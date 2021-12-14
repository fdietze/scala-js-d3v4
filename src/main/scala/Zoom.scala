package d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._
import org.scalajs.dom
import d3._

// https://github.com/d3/d3-zoom
@JSImport("d3-zoom", JSImport.Namespace)
@js.native
object d3zoom extends js.Object {
  def zoomIdentity: Transform            = js.native
  def zoom[Datum](): ZoomBehavior[Datum] = js.native

  @js.native
  trait Transform extends js.Object {
    def x: Double                   = js.native
    def y: Double                   = js.native
    def k: Double                   = js.native
    override def toString(): String = js.native

    def scale(k: Double | js.UndefOr[Double]): Transform
    def translate(x: Double | js.UndefOr[Double], y: Double | js.UndefOr[Double]): Transform
    def apply(point: js.Array[Double]): js.Array[Double]            = js.native
    def applyX(x: Double | js.UndefOr[Double]): Double              = js.native
    def applyY(x: Double | js.UndefOr[Double]): Double              = js.native
    def invert(point: js.Array[Double]): js.Array[Double]           = js.native
    def invertX(x: Double | js.UndefOr[Double]): Double             = js.native
    def invertY(x: Double | js.UndefOr[Double]): Double             = js.native
    def rescaleX[S <: ContinuousScale[S]](x: ContinuousScale[S]): S = js.native
    def rescaleY[S <: ContinuousScale[S]](y: ContinuousScale[S]): S = js.native
  }

  @js.native
  trait ZoomEvent extends BaseEvent {
    def transform: Transform = js.native
  }

  @js.native
  trait ZoomBehavior[Datum] extends js.Function1[Selection[Datum], Unit] {
    def on(typenames: String, listener: ListenerFunction0): ZoomBehavior[Datum]   = js.native
    def scaleExtent(extent: js.Array[Double]): ZoomBehavior[Datum]                = js.native
    def scaleExtent(): js.Array[Double]                                           = js.native
    def transform(selection: Selection[Datum], transform: Transform): Transform   = js.native
    def transform(transition: Transition[Datum], transform: Transform): Transform = js.native
    def translateBy(selection: Selection[Datum], x: Double, y: Double): Transform = js.native
    def scaleBy(selection: Selection[Datum], k: Double): Transform                = js.native
    def scaleTo(selection: Selection[Datum], k: Double): Transform                = js.native
    def clickDistance(distance: Double): ZoomBehavior[Datum]                      = js.native
    def clickDistance(): Double                                                   = js.native
  }
}
