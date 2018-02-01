package d3v4

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
  var event: dom.Event with BaseEvent = js.native
  def mouse(container: dom.EventTarget): js.Array[Double] = js.native
}

@js.native
trait BaseSelection[Datum, T <: BaseSelection[Datum, T]] extends BaseDom[Datum, T] {
  def append(`type`: String): T = js.native
  def append(`type`: js.Function0[dom.EventTarget]): T = js.native
  def append(`type`: js.Function1[Datum, dom.EventTarget]): T = js.native

  def on(typenames: String, listener: ListenerFunction0): T = js.native
  def on(typenames: String, listener: ListenerFunction1): T = js.native

  def data(): js.Array[Datum] = js.native
  def data[NewDatum <: Datum](data: js.Array[NewDatum]): Update[NewDatum] = js.native
  //TODO: d3 doc says that key can be a ThisFunction with this as the current node. It Doesn't work here...
  def data[NewDatum <: Datum](data: js.Array[NewDatum], key: ValueFunction0): Update[NewDatum] = js.native
  def data[NewDatum <: Datum](data: js.Array[NewDatum], key: ValueFunction1): Update[NewDatum] = js.native
  def data[NewDatum <: Datum](data: js.Array[NewDatum], key: ValueFunction2): Update[NewDatum] = js.native
  def data[NewDatum <: Datum](data: js.Array[NewDatum], key: ValueFunction3): Update[NewDatum] = js.native

  def each[E <: CurrentDomElement](function: ListenerFunction[E]): Unit = js.native

  def size():Int = js.native
}

@js.native
trait BaseDom[Datum, T <: BaseDom[Datum, T]] extends js.Object with DatumFunctionTypes[Datum] {
  def style[E <: CurrentDomElement](name: String, value: ValueFunction[E] | Any): T = js.native

  def attr(name: String, value: String): T = js.native
  def attr(name: String, value: Double): T = js.native
  def attr(name: String, value: Boolean): T = js.native
  def attr(name: String, value: ValueFunction1): T = js.native

  def text(): String = js.native
  def text(value: String): T = js.native
  def text(value: ValueFunction0): T = js.native
  def text(value: ValueFunction1): T = js.native

  def html(): String = js.native
  def html(value: String): T = js.native
  def html(value: ValueFunction0): T = js.native
  def html(value: ValueFunction1): T = js.native

  def call(func: js.Function, args: js.Any*): T = js.native
  def remove(): T = js.native
}

@js.native
trait Selection[Datum] extends BaseSelection[Datum, Selection[Datum]] {
  def select[SelData](selector: String): Selection[SelData] = js.native
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
  def append(`type`: js.Function0[dom.EventTarget]): Selection[Datum] = js.native
  def append(`type`: js.Function1[Datum, dom.EventTarget]): Selection[Datum] = js.native

  def append(name: js.Function3[Datum, Double, Double, dom.EventTarget]): Selection[Datum] = js.native
}
