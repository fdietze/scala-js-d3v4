package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{native, Object, undefined}
import scala.scalajs.js.annotation._

package object force {
  implicit def d3Force(jq: d3): D3Force = jq.asInstanceOf[D3Force]

  @js.native
  trait D3Force extends d3 {
    def forceSimulation[N](nodes: js.Array[N] = js.Array[N]()): Simulation[N] = native
    def forceCenter(x: Double = 0, y: Double = 0): Centering = native
    def forceX[N](x: Double = 0): PositioningX[N] = native
    def forceY[N](y: Double = 0): PositioningY[N] = native
    def forceManyBody[N](): ManyBody[N] = native
    def forceCollide[N](radius: Double = 1): Collision[N] = native
    def forceLink[L](links: js.Array[L] = js.Array[L]()): force.Link[L] = native
  }

  @native
  trait Simulation[N] extends Object {
    def force(name: String, force: Force): this.type = native
    def force[F <: Force](name: String): F = native
    def nodes(nodes: js.Array[N]): this.type = native
    def on(typenames: String, listener: js.Function0[Unit]): this.type = native
    def on(typenames: String): this.type = native
    def find(x: Double, y: Double, radius: Double = Double.PositiveInfinity): js.UndefOr[N] = native
    def alpha(alpha: Double): this.type = native
    def alphaTarget(target: Double): this.type = native
    def alphaTarget(): Double = native
    def restart(): this.type = native
  }

  @native
  trait Force extends Object {}

  @native
  trait Centering extends Object with Force {
    def x(x: Double): this.type = native
    def y(y: Double): this.type = native
    def x(): Double = native
    def y(): Double = native
  }

  @native
  trait PositioningX[N] extends Object with Force {
    def x(x: Double): this.type = native
    def strength(strength: Double): this.type = native
  }

  @native
  trait PositioningY[N] extends Object with Force {
    def y(y: Double): this.type = native
    def strength(strength: Double): this.type = native
  }

  @native
  trait ManyBody[N] extends Object with Force {
    def strength(strength: Double): this.type = native
  }

  @native
  trait Collision[N] extends Object with Force {
    def radius(radius: js.Function1[N, Double]): this.type = native
  }

  @native
  trait Link[L] extends Object with Force {
    def distance(distance: Double): this.type = native
    def strength(strength: js.Function1[L, Double]): this.type = native
    def links(links: js.Array[L]): this.type = native
  }

  @JSExportAll
  trait SimulationNode {
    def index: js.UndefOr[Int]
    def index_=(newIndex: js.UndefOr[Int])
    def x: js.UndefOr[Double]
    def x_=(newX: js.UndefOr[Double])
    def y: js.UndefOr[Double]
    def y_=(newY: js.UndefOr[Double])
    def vx: js.UndefOr[Double]
    def vx_=(newVX: js.UndefOr[Double])
    def vy: js.UndefOr[Double]
    def vy_=(newVX: js.UndefOr[Double])
    def fx: js.UndefOr[Double]
    def fx_=(newFX: js.UndefOr[Double])
    def fy: js.UndefOr[Double]
    def fy_=(newFX: js.UndefOr[Double])
  }

  @JSExportAll
  trait SimulationLink[S <: SimulationNode, T <: SimulationNode] {
    def index: js.UndefOr[Int]
    def index_=(newIndex: js.UndefOr[Int])

    var source: S = _
    var target: T = _
  }
}
