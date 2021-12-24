package d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._

// https://github.com/d3/d3-force

@JSImport("d3-force", JSImport.Namespace)
@js.native
object d3force extends js.Object {
  def forceSimulation[N <: SimulationNode](nodes: js.Array[N] = js.Array[N]()): Simulation[N] = js.native
  def forceCenter[N <: SimulationNode](x: Double = 0, y: Double = 0): Centering[N]            = js.native
  def forceX[N <: SimulationNode](x: Double = 0): PositioningX[N]                             = js.native
  def forceY[N <: SimulationNode](y: Double = 0): PositioningY[N]                             = js.native
  def forceManyBody[N <: SimulationNode](): ManyBody[N]                                       = js.native
  def forceCollide[N <: SimulationNode](radius: Double = 1): Collision[N]                     = js.native
  def forceLink[N <: SimulationNode, L <: SimulationLink[_ <: N, _ <: N]](
      links: js.Array[L] = js.Array[L](),
  ): Link[N, L] = js.native

  @js.native
  trait Simulation[N <: SimulationNode] extends js.Object {
    def restart(): this.type = js.native
    def stop(): this.type    = js.native
    def tick(): this.type    = js.native

    def nodes(nodes: js.Array[N]): this.type = js.native
    def nodes(): js.Array[N]                 = js.native

    def alpha(alpha: Double): this.type         = js.native
    def alpha(): Double                         = js.native
    def alphaMin(min: Double): this.type        = js.native
    def alphaMin(): Double                      = js.native
    def alphaDecay(decay: Double): this.type    = js.native
    def alphaDecay(): Double                    = js.native
    def alphaTarget(target: Double): this.type  = js.native
    def alphaTarget(): Double                   = js.native
    def velocityDecay(decay: Double): this.type = js.native
    def velocityDecay(): Double                 = js.native

    def force(name: String, force: Force[N]): this.type = js.native
    def force(name: String): Force[N]                   = js.native

    def find(x: Double, y: Double): js.UndefOr[N]                 = js.native
    def find(x: Double, y: Double, radius: Double): js.UndefOr[N] = js.native

    def on(typenames: String, listener: js.ThisFunction0[Simulation[N], Any]): this.type = js.native
    def on(typenames: String, listener: ListenerFunction0): this.type                    = js.native
    def on(typenames: String): this.type                                                 = js.native
  }
  trait Force[N <: SimulationNode]      extends js.Object {
    def force(alpha: Double): Unit
    def initialize(nodes: js.Array[N]): Unit
  }

  @js.native
  trait ForceImpl[N <: SimulationNode] extends Force[N] {
    def force(alpha: Double): Unit           = js.native
    def initialize(nodes: js.Array[N]): Unit = js.native
  }

  @js.native
  trait Centering[N <: SimulationNode] extends ForceImpl[N] {
    def x(x: Double): this.type = js.native
    def y(y: Double): this.type = js.native
    def x(): Double             = js.native
    def y(): Double             = js.native
  }

  @js.native
  trait PositioningX[N <: SimulationNode] extends ForceImpl[N] {
    def x(x: Double): this.type               = js.native
    def strength(strength: Double): this.type = js.native
  }

  @js.native
  trait PositioningY[N <: SimulationNode] extends ForceImpl[N] {
    def y(y: Double): this.type               = js.native
    def strength(strength: Double): this.type = js.native
  }

  @js.native
  trait ManyBody[N <: SimulationNode] extends ForceImpl[N] {
    def strength(strength: Double): this.type                  = js.native
    def strength(strength: js.Function1[N, Double]): this.type = js.native
    def theta(theta: Double): this.type                        = js.native
    def theta(): Double                                        = js.native
    def distanceMin(distance: Double): this.type               = js.native
    def distanceMin(): Double                                  = js.native
    def distanceMax(distance: Double): this.type               = js.native
    def distanceMax(): Double                                  = js.native
  }

  @js.native
  trait Collision[N <: SimulationNode] extends ForceImpl[N] {
    def radius(radius: js.Function1[N, Double]): this.type = js.native
    def strength(strength: Double): this.type              = js.native
  }

  @js.native
  trait Link[N <: SimulationNode, L <: SimulationLink[_ <: N, _ <: N]] extends ForceImpl[N] {
    def distance(distance: Double): this.type                  = js.native
    def distance(distance: js.Function1[L, Double]): this.type = js.native
    def strength(strength: Double): this.type                  = js.native
    def strength(strength: js.Function1[L, Double]): this.type = js.native
    def links(links: js.Array[L]): this.type                   = js.native
  }

}

@JSExportAll
trait SimulationNode {
  def index: js.UndefOr[Int]
  def index_=(newIndex: js.UndefOr[Int]): Unit
  def x: js.UndefOr[Double]
  def x_=(newX: js.UndefOr[Double]): Unit
  def y: js.UndefOr[Double]
  def y_=(newY: js.UndefOr[Double]): Unit
  def vx: js.UndefOr[Double]
  def vx_=(newVX: js.UndefOr[Double]): Unit
  def vy: js.UndefOr[Double]
  def vy_=(newVX: js.UndefOr[Double]): Unit
  def fx: js.UndefOr[Double]
  def fx_=(newFX: js.UndefOr[Double]): Unit
  def fy: js.UndefOr[Double]
  def fy_=(newFX: js.UndefOr[Double]): Unit
}
trait SimulationNodeImpl extends SimulationNode {
  var index: js.UndefOr[Int] = js.undefined

  var x: js.UndefOr[Double]  = js.undefined
  var y: js.UndefOr[Double]  = js.undefined
  var vx: js.UndefOr[Double] = js.undefined
  var vy: js.UndefOr[Double] = js.undefined
  var fx: js.UndefOr[Double] = js.undefined
  var fy: js.UndefOr[Double] = js.undefined
}

@JSExportAll
trait SimulationLink[S <: SimulationNode, T <: SimulationNode] {
  def index: js.UndefOr[Int]
  def index_=(newIndex: js.UndefOr[Int]): Unit

  def source: S
  def target: T
}

trait SimulationLinkImpl[S <: SimulationNode, T <: SimulationNode] extends SimulationLink[S, T] {
  var index: js.UndefOr[Int] = js.undefined

  //     var source: S = _
  //     var target: T = _
}
