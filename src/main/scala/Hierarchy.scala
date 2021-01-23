package d3v4

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportAll, JSImport}

/**
 * @see [[https://github.com/d3/d3-hierarchy]]
 * @since January, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
@JSImport("d3-hierarchy", JSImport.Namespace)
@js.native
object d3hierarchy extends js.Object {

  /** @see [[https://github.com/d3/d3-hierarchy#hierarchy]] */
  def hierarchy[N <: HierarchyNode](data: N): Hierarchy[N] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#hierarchy]] */
  def hierarchy[N <: HierarchyNode](data: N, children: js.Function1[N, js.Array[N]]): Hierarchy[N] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack]] */
  def pack[N <: HierarchyNode with PackNode](): Pack[N] = js.native

  /** @see [[hierarchy]] */
  @js.native
  trait Hierarchy[N <: HierarchyNode] extends js.Object {

    /** @see [[https://github.com/d3/d3-hierarchy#node_ancestors]] */
    def ancestors(): js.Array[N] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_descendants]] */
    def descendants(): js.Array[N] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_leaves]] */
    def leaves(): js.Array[N] = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_find]] */
    //def find(filter: ???): js.UndefOr[N] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_path]] */
    def path(target: N): js.Array[N] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_links]] */
    def links(): js.Array[N] = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_sum]] */
    //def sum(value: ???): js.Array[N] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_count]] */
    def count(): Int = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_sort]] */
    def sort(compare: js.Function2[N, N, Int]): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_each]] */
    def each(function: js.Function1[N, Unit]): this.type = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_each]] */
    //def each(function: js.Function1[N, Unit], that: ???): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_eachAfter]] */
    def eachAfter(function: js.Function1[N, Unit]): this.type = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_eachAfter]] */
    //def eachAfter(function: js.Function1[N, Unit], that: ???): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_eachBefore]] */
    def eachBefore(function: js.Function1[N, Unit]): this.type = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_eachBefore]] */
    //def eachBefore(function: js.Function1[N, Unit], that: ???): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_copy]] */
    def copy(): this.type = js.native

  }

  /**
   * @see [[pack]]
   * @see [[https://github.com/d3/d3-hierarchy#pack]]
   */
  @js.native
  trait Pack[N <: HierarchyNode with PackNode] extends js.Function1[N, N] {

    /** @see [[https://github.com/d3/d3-hierarchy#pack_radius]] */
    def radius(): Double = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#pack_radius]] */
    def radius(radius: js.Function1[N, Double]): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#pack_radius]] */
    def radius(radius: Double): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#pack_size]] */
    def size(): js.Array[Int] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#pack_size]] */
    def size(size: js.Array[Int]): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#pack_padding]] */
    def padding(): js.Function1[N, Double] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#pack_padding]] */
    def padding(padding: js.Function1[N, Double]): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#pack_padding]] */
    def padding(padding: Double): this.type = js.native

  }

}

@JSExportAll
trait HierarchyNode {

  //def data: js.UndefOr[Datum]
  //def data_=(newData:js.UndefOr[Datum] ): Unit

  def depth: js.UndefOr[Int]
  def depth_=(newDepth: js.UndefOr[Int]): Unit

  def height: js.UndefOr[Int]
  def height_=(newHeight: js.UndefOr[Int]): Unit

  def parent: js.UndefOr[this.type]
  def parent_=(newParent: js.UndefOr[this.type]): Unit

  def children: js.UndefOr[js.Array[this.type]]
  def children_=(newChildren: js.UndefOr[js.Array[this.type]]): Unit

  //def value: ???
  //def value_=(newValue: ???): Unit

}

trait HierarchyNodeImpl extends HierarchyNode {
  //override var data = js.undefined
  override var depth: js.UndefOr[Int] = js.undefined
  override var height: js.UndefOr[Int] = js.undefined
  override var parent: js.UndefOr[this.type] = js.undefined
  override var children: js.UndefOr[js.Array[this.type]] = js.undefined
}

@JSExportAll
trait PackNode {

  def x: js.UndefOr[Double]

  def x_=(newX: js.UndefOr[Double]): Unit

  def y: js.UndefOr[Double]

  def y_=(newY: js.UndefOr[Double]): Unit

  def r: js.UndefOr[Double]

  def r_=(newR: js.UndefOr[Double]): Unit

}

trait PackNodeImpl extends PackNode {
  override var x: js.UndefOr[Double] = js.undefined
  override var y: js.UndefOr[Double] = js.undefined
  override var r: js.UndefOr[Double] = js.undefined
}
