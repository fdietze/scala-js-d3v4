package org.scalajs.d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._
import org.scalajs.dom

// https://github.com/d3/d3-selection
@JSImport("d3-selection", JSImport.Namespace)
@js.native
object d3selection extends js.Object {
  def select(selector: String): Selection[dom.EventTarget] = js.native // TODO: Return type correct?
  def select(node: dom.EventTarget): Selection[dom.EventTarget] = js.native // TODO: Return type correct?
  var event: dom.Event | BaseEvent = js.native
  def mouse(container: dom.raw.HTMLElement | dom.raw.SVGElement): js.Array[Double] = js.native
}

@js.native
trait BaseSelection[Datum, T <: BaseSelection[Datum, T]] extends BaseDom[Datum, T] {
  def append(name: String): T = js.native

  def on(typenames: String, listener: ListenerFunction0): T = js.native
  def on(typenames: String, listener: ListenerFunction1): T = js.native

  def data[NewDatum <: Datum, R](data: js.Array[NewDatum], key: ValueFunction1[R]): Update[NewDatum] = js.native
  def data[NewDatum <: Datum](data: js.Array[NewDatum]): Update[NewDatum] = js.native
  def data():js.Array[Datum] = js.native

  def each[C <: CurrentDom](function:ListenerThisFunction1[C]):Unit = js.native
}

@js.native
trait BaseDom[Datum, T <: BaseDom[Datum, T]] extends js.Object {
  type ValueFunction3[Return] = js.Function3[Datum, Index, Group, Return]
  type ValueFunction2[Return] = js.Function2[Datum, Index, Return]
  type ValueFunction1[Return] = js.Function1[Datum, Return]
  type ValueFunction0[Return] = js.Function0[Return]

  type ListenerFunction3 = ValueFunction3[Any]
  type ListenerFunction2 = ValueFunction2[Any]
  type ListenerFunction1 = ValueFunction1[Any]
  type ListenerFunction0 = ValueFunction0[Any]

  type ValueThisFunction3[C <: CurrentDom, Return] = js.ThisFunction3[C, Datum, Index, Group, Return]
  type ValueThisFunction2[C <: CurrentDom, Return] = js.ThisFunction2[C, Datum, Index, Return]
  type ValueThisFunction1[C <: CurrentDom, Return] = js.ThisFunction1[C, Datum, Return]
  type ValueThisFunction0[C <: CurrentDom, Return] = js.ThisFunction0[C, Return]

  type ListenerThisFunction3[C <: CurrentDom]  = ValueThisFunction3[C, Any]
  type ListenerThisFunction2[C <: CurrentDom] = ValueThisFunction2[C, Any]
  type ListenerThisFunction1[C <: CurrentDom] = ValueThisFunction1[C, Any]
  type ListenerThisFunction0[C <: CurrentDom] = ValueThisFunction0[C, Any]

  def style(name: String, value: String): T = js.native
  def style[R](name: String, value: ValueFunction1[R]): T = js.native

  def attr(name: String, value: String): T = js.native
  def attr(name: String, value: Double): T = js.native
  def attr(name: String, value: Boolean): T = js.native
  def attr[R](name: String, value: ValueFunction1[R]): T = js.native

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
