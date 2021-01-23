import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportAll, JSImport}
import d3hierarchy.Hierarchy

/**
 * @see [[https://github.com/d3/d3-hierarchy]]
 * @since January, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
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

  @js.native
  trait Hierarchy[Datum] extends js.Object {

    def data: Datum = js.native
    def depth: Int = js.native
    def height: Int = js.native
    def parent: Hierarchy[Datum] = js.native
    def children: js.Array[Hierarchy[Datum]] = js.native
    //def value: ??? = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_ancestors]] */
    def ancestors(): js.Array[Hierarchy[Datum]] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_descendants]] */
    def descendants(): js.Array[Hierarchy[Datum]] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_leaves]] */
    def leaves(): js.Array[Hierarchy[Datum]] = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_find]] */
    //def find(filter: ???): js.UndefOr[Node[Datum]] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_path]] */
    def path(target: Hierarchy[Datum]): js.Array[Hierarchy[Datum]] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_links]] */
    def links(): js.Array[Hierarchy[Datum]] = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_sum]] */
    //def sum(value: ???): js.Array[Node[Datum]] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_count]] */
    def count(): Int = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_sort]] */
    def sort(compare: js.Function2[Hierarchy[Datum], Hierarchy[Datum], Int]): Hierarchy[Datum] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_each]] */
    def each(function: js.Function1[Hierarchy[Datum], Unit]):Hierarchy[Datum] = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_each]] */
    //def each(function: js.Function1[Node[Datum], Unit], that: ???):Node[Datum] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_eachAfter]] */
    def eachAfter(function: js.Function1[Hierarchy[Datum], Unit]):Hierarchy[Datum] = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_eachAfter]] */
    //def eachAfter(function: js.Function1[Node[Datum], Unit], that: ???):Node[Datum] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_eachBefore]] */
    def eachBefore(function: js.Function1[Hierarchy[Datum], Unit]):Hierarchy[Datum] = js.native

    ///** @see [[https://github.com/d3/d3-hierarchy#node_eachBefore]] */
    //def eachBefore(function: js.Function1[Node[Datum], Unit], that: ???):Node[Datum] = js.native

    /** @see [[https://github.com/d3/d3-hierarchy#node_copy]] */
    def copy(): Hierarchy[Datum] = js.native

  }

}

/** @see [[https://github.com/d3/d3-hierarchy#pack]] */
@JSExportAll
trait Pack[Datum] extends js.Function1[Hierarchy[Datum], Hierarchy[Datum]] {

  /** @see [[https://github.com/d3/d3-hierarchy#pack_radius]] */
  def radius(): Double = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack_radius]] */
  def radius(radius: js.Function1[Hierarchy[Datum], Double]): Pack[Datum] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack_radius]] */
  def radius(radius: Double): Pack[Datum] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack_size]] */
  def size(): js.Array[Int] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack_size]] */
  def size(size: js.Array[Int]): Pack[Datum] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack_padding]] */
  def padding(): js.Function1[Hierarchy[Datum], Double] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack_padding]] */
  def padding(padding: js.Function1[Hierarchy[Datum], Double]): Pack[Datum] = js.native

  /** @see [[https://github.com/d3/d3-hierarchy#pack_padding]] */
  def padding(padding:  Double): Pack[Datum] = js.native

}
