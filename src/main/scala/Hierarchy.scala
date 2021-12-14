package d3v4

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportAll, JSImport}

/** @see
  *   [[https://github.com/d3/d3-hierarchy]]
  * @since January,
  *   2021
  * @author
  *   <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
  */
@JSImport("d3-hierarchy", JSImport.Namespace)
@js.native
object d3hierarchy extends js.Object {

  /** @see [[https://github.com/d3/d3-hierarchy#hierarchy]] */
  def hierarchy[Datum](data: Datum): Hierarchy[Datum] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#hierarchy]] */
  def hierarchy[Datum](data: Datum, children: js.Function1[Datum, js.Array[Datum]]): Hierarchy[Datum] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack]] */
  def pack[Datum](): Pack[Datum] = js.native

  /** @see [[hierarchy]] */
  @js.native
  trait Hierarchy[Datum] extends js.Object {

    def data: Datum                               = js.native
    def depth: js.UndefOr[Int]                    = js.native
    def height: js.UndefOr[Int]                   = js.native
    def parent: js.UndefOr[this.type]             = js.native
    def children: js.UndefOr[js.Array[this.type]] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_ancestors]] */
    def ancestors(): js.Array[this.type] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_descendants]] */
    def descendants(): js.Array[this.type] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_leaves]] */
    def leaves(): js.Array[this.type] = js.native

    // /** @see [[https://github.com/d3/d3-hierarchy#node_find]] */
    // def find(filter: ???): ??? = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_path]] */
    def path(target: Datum): js.Array[this.type] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_links]] */
    def links(): js.Array[this.type] = js.native

    // /** @see [[https://github.com/d3/d3-hierarchy#node_sum]] */
    // def sum(value: ???): ??? = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_count]] */
    def count(): Int = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_sort]] */
    def sort(compare: js.Function2[this.type, this.type, Int]): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_each]] */
    def each(function: js.Function1[this.type, Unit]): this.type = js.native

    // /** @see [[https://github.com/d3/d3-hierarchy#node_each]] */
    // def each(function: js.Function1[this.type, Unit], that: ???): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_eachAfter]] */
    def eachAfter(function: js.Function1[this.type, Unit]): this.type = js.native

    // /** @see [[https://github.com/d3/d3-hierarchy#node_eachAfter]] */
    // def eachAfter(function: js.Function1[this.type, Unit], that: ???): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_eachBefore]] */
    def eachBefore(function: js.Function1[this.type, Unit]): this.type = js.native

    // /** @see [[https://github.com/d3/d3-hierarchy#node_eachBefore]] */
    // def eachBefore(function: js.Function1[this.type, Unit], that: ???): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_copy]] */
    def copy(): this.type = js.native

  }

  @js.native
  trait Packed extends js.Object { self: Hierarchy[_] =>
    def x: js.UndefOr[Double] = js.native
    def y: js.UndefOr[Double] = js.native
    def r: js.UndefOr[Double] = js.native
  }

  /** @see
    *   [[pack]]
    * @see
    *   [[https://github.com/d3/d3-hierarchy#pack]]
    */
  @js.native
  trait Pack[Datum] extends js.Function1[Hierarchy[Datum], Hierarchy[Datum] with Packed] {

    /** @see [[https://github.com/d3/d3-hierarchy#pack_radius]] */
    def radius(): Double = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#pack_radius]] */
    def radius(radius: js.Function1[Hierarchy[Datum], js.UndefOr[Double]]): this.type = js.native

    // /** @see [[https://github.com/d3/d3-hierarchy#pack_radius]] */
    // def radius(radius: Double): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#pack_size]] */
    def size(): js.Array[Int] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#pack_size]] */
    def size(size: js.Array[Int]): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#pack_padding]] */
    def padding(): js.Function1[Hierarchy[Datum], Double] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#pack_padding]] */
    def padding(padding: js.Function1[Hierarchy[Datum], Double]): this.type = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#pack_padding]] */
    def padding(padding: Double): this.type = js.native

  }

}
