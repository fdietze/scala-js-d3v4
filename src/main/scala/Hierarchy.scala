import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * @see [[https://github.com/d3/d3-hierarchy]]
 * @since January, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
@JSImport("d3-hierarchy", JSImport.Namespace)
@js.native
object d3hierarchy extends js.Object {

  /** @see [[https://github.com/d3/d3-hierarchy#hierarchy]] */
  def hierarchy[Datum](data: Datum): Node[Datum] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#hierarchy]] */
  def hierarchy[Datum](data: Datum, children: js.Function1[Datum, js.Array[Datum]]): Node[Datum] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack]] */
  def pack[Datum](): Pack[Datum] = js.native

  @js.native
  trait Node[Datum] extends js.Object {

    def data: Datum = js.native
    def depth: Int = js.native
    def height: Int = js.native
    def parent: Node[Datum] = js.native
    def children: js.Array[Datum] = js.native
    //def value: ??? = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_ancestors]] */
    def ancestors(): js.Array[Node[Datum]] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_descendants]] */
    def descendants(): js.Array[Node[Datum]] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_leaves]] */
    def leaves(): js.Array[Node[Datum]] = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_find]] */
    //def find(filter: ???): js.UndefOr[Node[Datum]] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_path]] */
    def path(target: Node[Datum]): js.Array[Node[Datum]] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_links]] */
    def links(): js.Array[Node[Datum]] = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_sum]] */
    //def sum(value: ???): js.Array[Node[Datum]] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_count]] */
    def count(): Int = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_sort]] */
    def sort(compare: js.Function2[Node[Datum], Node[Datum], Int]): Node[Datum] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_each]] */
    def each(function: js.Function1[Node[Datum], Unit]):Node[Datum] = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_each]] */
    //def each(function: js.Function1[Node[Datum], Unit], that: ???):Node[Datum] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_eachAfter]] */
    def eachAfter(function: js.Function1[Node[Datum], Unit]):Node[Datum] = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_eachAfter]] */
    //def eachAfter(function: js.Function1[Node[Datum], Unit], that: ???):Node[Datum] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_eachBefore]] */
    def eachBefore(function: js.Function1[Node[Datum], Unit]):Node[Datum] = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_eachBefore]] */
    //def eachBefore(function: js.Function1[Node[Datum], Unit], that: ???):Node[Datum] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_copy]] */
    def copy(): Node[Datum] = js.native

  }

}

import d3hierarchy.Node

/** @see [[https://github.com/d3/d3-hierarchy#pack]] */
@JSExportAll
trait Pack[Datum] extends js.Function1[Node[Datum], Node[Datum]] {

  /** @see [[https://github.com/d3/d3-hierarchy#pack_radius]] */
  def radius(): Double = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack_radius]] */
  def radius(radius: js.Function1[Node[Datum], Double]): Pack[Datum] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack_radius]] */
  def radius(radius: Double): Pack[Datum] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack_size]] */
  def size(): js.Array[Int] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack_size]] */
  def size(size: js.Array[Int]): Pack[Datum] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack_padding]] */
  def padding(): js.Function1[Node[Datum], Double] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack_padding]] */
  def padding(padding: js.Function1[Node[Datum], Double]): Pack[Datum] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack_padding]] */
  def padding(padding:  Double): Pack[Datum] = js.native

}
