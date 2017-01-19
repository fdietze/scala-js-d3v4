package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{native, Object, undefined, `|`}
import scala.scalajs.js.annotation._

// https://github.com/d3/d3-force
package object force {
  implicit def d3Force(jq: d3): D3Force = jq.asInstanceOf[D3Force]

  @js.native
  trait D3Force extends d3 {
    def forceSimulation[N <: SimulationNode](nodes: js.Array[N] = js.Array[N]()): Simulation[N] = native
    def forceCenter[N <: SimulationNode](x: Double = 0, y: Double = 0): Centering[N] = native
    def forceX[N <: SimulationNode](x: Double = 0): PositioningX[N] = native
    def forceY[N <: SimulationNode](y: Double = 0): PositioningY[N] = native
    def forceManyBody[N <: SimulationNode](): ManyBody[N] = native
    def forceCollide[N <: SimulationNode](radius: Double = 1): Collision[N] = native
    def forceLink[N <: SimulationNode, L <: SimulationLink[_ <: N, _ <: N]](links: js.Array[L] = js.Array[L]()): force.Link[N, L] = native
  }

  @native
  trait Simulation[N <: SimulationNode] extends Object {
    def force(name: String, force: Force[N]): this.type = native
    def force[F <: Force[N]](name: String): F = native
    def nodes(nodes: js.Array[N]): this.type = native
    def nodes(): js.Array[N] = native
    def on(typenames: String, listener: js.Function0[Unit]): this.type = native
    def on(typenames: String): this.type = native
    def find(x: Double, y: Double, radius: Double = Double.PositiveInfinity): js.UndefOr[N] = native
    def alpha(alpha: Double): this.type = native
    def alpha(): Double = native
    def alphaTarget(target: Double): this.type = native
    def alphaTarget(): Double = native
    def alphaMin(min: Double): this.type = native
    def alphaMin(): Double = native
    def restart(): this.type = native
    def stop(): this.type = native
    def tick(): this.type = native
  }

  @native
  trait Force[N <: SimulationNode] extends Object {
    def initialize(nodes: js.Array[N]): Unit = native
  }

  @native
  trait Centering[N <: SimulationNode] extends Object with Force[N] {
    def x(x: Double): this.type = native
    def y(y: Double): this.type = native
    def x(): Double = native
    def y(): Double = native
  }

  @native
  trait PositioningX[N <: SimulationNode] extends Object with Force[N] {
    def x(x: Double): this.type = native
    def strength(strength: Double): this.type = native
  }

  @native
  trait PositioningY[N <: SimulationNode] extends Object with Force[N] {
    def y(y: Double): this.type = native
    def strength(strength: Double): this.type = native
  }

  @native
  trait ManyBody[N <: SimulationNode] extends Object with Force[N] {
    def strength(strength: Double): this.type = native
  }

  @native
  trait Collision[N <: SimulationNode] extends Object with Force[N] {
    def radius(radius: js.Function1[N, Double]): this.type = native
  }

  @native
  trait Link[N <: SimulationNode, L <: SimulationLink[_ <: N, _ <: N]] extends Object with Force[N] {
    def distance(distance: Double): this.type = native
    def distance(distance: js.Function1[L, Double]): this.type = native
    def strength(strength: Double): this.type = native
    def strength(strength: js.Function1[L, Double]): this.type = native
    def links(links: js.Array[L]): this.type = native
  }

  @ScalaJSDefined
  trait SimulationNode extends Object {
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

  trait SimulationNodeImpl extends SimulationNode {
    var index: js.UndefOr[Int] = js.undefined

    var x: js.UndefOr[Double] = js.undefined
    var y: js.UndefOr[Double] = js.undefined
    var vx: js.UndefOr[Double] = js.undefined
    var vy: js.UndefOr[Double] = js.undefined
    var fx: js.UndefOr[Double] = js.undefined
    var fy: js.UndefOr[Double] = js.undefined
  }

  @ScalaJSDefined
  trait SimulationLink[S <: SimulationNode, T <: SimulationNode] extends Object {
    def index: js.UndefOr[Int]
    def index_=(newIndex: js.UndefOr[Int])

    def source: S
    def target: T
  }

  trait SimulationLinkImpl[S <: SimulationNode, T <: SimulationNode] extends SimulationLink[S, T] {
    var index: js.UndefOr[Int] = js.undefined

    //     var source: S = _
    //     var target: T = _
  }
}
