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
  def hierarchy[N <: HierarchyNode[N]](data: N): Hierarchy[N] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#hierarchy]] */
  def hierarchy[N <: HierarchyNode[N]](data: N, children: js.Function1[N, js.UndefOr[js.Array[N]]]): Hierarchy[N] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack]] */
  def pack[N <: HierarchyNode[N] with PackNode](): Pack[N] = js.native

  /** @see [[hierarchy]] */
  @js.native
  trait Hierarchy[N <: HierarchyNode[N]] extends js.Object {

    def data: N = js.native
    def depth: js.UndefOr[Int] = js.native
    def height: js.UndefOr[Int] = js.native
    def parent: js.UndefOr[this.type] = js.native
    def children: js.UndefOr[js.Array[this.type]] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_ancestors]] */
    def ancestors(): js.Array[this.type] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_descendants]] */
    def descendants(): js.Array[this.type] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_leaves]] */
    def leaves(): js.Array[this.type] = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_find]] */
    //def find(filter: ???): ??? = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_path]] */
    def path(target: N): js.Array[this.type] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_links]] */
    def links(): js.Array[this.type] = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_sum]] */
    //def sum(value: ???): ??? = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_count]] */
    def count(): Int = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_sort]] */
    def sort(compare: js.Function2[this.type, this.type, Int]): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_each]] */
    def each(function: js.Function1[this.type, Unit]): this.type = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_each]] */
    //def each(function: js.Function1[this.type, Unit], that: ???): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_eachAfter]] */
    def eachAfter(function: js.Function1[this.type, Unit]): this.type = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_eachAfter]] */
    //def eachAfter(function: js.Function1[this.type, Unit], that: ???): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_eachBefore]] */
    def eachBefore(function: js.Function1[this.type, Unit]): this.type = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_eachBefore]] */
    //def eachBefore(function: js.Function1[this.type, Unit], that: ???): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_copy]] */
    def copy(): this.type = js.native

  }

  /**
   * @see [[pack]]
   * @see [[https://github.com/d3/d3-hierarchy#pack]]
   */
  @js.native
  trait Pack[N <: HierarchyNode[N] with PackNode] extends js.Function1[Hierarchy[N], Hierarchy[N]] {

    /** @see [[https://github.com/d3/d3-hierarchy#pack_radius]] */
    def radius(): Double = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#pack_radius]] */
    def radius(radius: js.Function1[N, js.UndefOr[Double]]): this.type = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#pack_radius]] */
    //def radius(radius: Double): this.type = js.native

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
trait HierarchyNode[N <: HierarchyNode[N]] {

  //def data: js.UndefOr[Datum]
  //def data_=(newData:js.UndefOr[Datum] ): Unit

  def depth: js.UndefOr[Int]
  def depth_=(newDepth: js.UndefOr[Int]): Unit

  def height: js.UndefOr[Int]
  def height_=(newHeight: js.UndefOr[Int]): Unit

  def parent: js.UndefOr[N]
  def parent_=(newParent: js.UndefOr[N]): Unit

  def children: js.UndefOr[js.Array[N]]
  def children_=(newChildren: js.UndefOr[js.Array[N]]): Unit

  //def value: ???
  //def value_=(newValue: ???): Unit

}

trait HierarchyNodeImpl[N <: HierarchyNode[N]] extends HierarchyNode[N] {
  //override var data = js.undefined
  override var depth: js.UndefOr[Int] = js.undefined
  override var height: js.UndefOr[Int] = js.undefined
  override var parent: js.UndefOr[N] = js.undefined
  override var children: js.UndefOr[js.Array[N]] = js.undefined
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
