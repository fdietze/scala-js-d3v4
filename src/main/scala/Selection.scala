package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._
import org.scalajs.dom

// https://github.com/d3/d3-selection
@JSImport("d3-selection", JSImport.Namespace)
@js.native
object d3selection extends js.Object {
  def select(selector: String): Selection[dom.EventTarget] = js.native
  def select(node: dom.EventTarget): Selection[dom.EventTarget] = js.native
  var event: dom.Event | BaseEvent = js.native
  def mouse(container: dom.raw.HTMLElement | dom.raw.SVGElement): js.Array[Double] = js.native
}

@js.native
trait BaseSelection[Datum, T <: BaseSelection[Datum, T]] extends BaseDom[Datum, T] {
  def append(name: String): T = js.native

  def on(typenames: String, listener: ListenerFunction0, capture: Boolean = false): T = js.native

  def data[NewDatum <: Datum](data: js.Array[NewDatum], key: js.Function1[Datum, String]): Update[NewDatum] = js.native
}

@js.native
trait BaseDom[Datum, T <: BaseDom[Datum, T]] extends js.Object {
  type CurrentDom = dom.EventTarget
  type Index = Int
  type Group = js.UndefOr[Int]

  // type DatumThisFunction3[Return] = js.ThisFunction3[CurrentDom, Datum, Index, Group, Return]
  // type DatumThisFunction2[Return] = js.ThisFunction2[CurrentDom, Datum, Index, Return]
  // type DatumThisFunction1[Return] = js.ThisFunction1[CurrentDom, Datum, Return]
  // type DatumThisFunction0[Return] = js.ThisFunction0[CurrentDom, Return]

  type ValueFunction3[Return] = js.Function3[Datum, Index, Group, Return]
  type ValueFunction2[Return] = js.Function2[Datum, Index, Return]
  type ValueFunction1[Return] = js.Function1[Datum, Return]
  type ValueFunction0[Return] = js.Function0[Return]

  type ListenerFunction3 = ValueFunction3[Any]
  type ListenerFunction2 = ValueFunction2[Any]
  type ListenerFunction1 = ValueFunction1[Any]
  type ListenerFunction0 = ValueFunction0[Any]

  def style(name: String, value: String): T = js.native
  def style[R](name: String, value: ValueFunction1[R]): T = js.native

  def attr(name: String, value: String): T = js.native
  def attr(name: String, value: Double): T = js.native
  def attr(name: String, value: Boolean): T = js.native

  def text(): String = js.native
  def text(value: String): T = js.native
  def text[R](value: ValueFunction0[R]): T = js.native
  def text[R](value: ValueFunction1[R]): T = js.native

  def call(func: js.Function, args: js.Any*): T = js.native
  def remove(): T = js.native
}

@js.native
trait Selection[Datum] extends BaseSelection[Datum, Selection[Datum]] {
  def selectAll[SelData](selector: String): Selection[SelData] = js.native
  def node(): dom.EventTarget = js.native
}

@js.native
trait Update[Datum] extends BaseSelection[Datum, Update[Datum]] {
  def enter(): Enter[Datum] = js.native
  def exit(): Selection[Datum] = js.native
}

@js.native
trait Enter[Datum] extends js.Object {
  def append(name: String): Selection[Datum] = js.native

  def append(name: js.Function3[Datum, Double, Double, dom.EventTarget]): Selection[Datum] = js.native
}
