import scalajs.js.`|`
import scalajs.js
import scala.scalajs.js.annotation._
import org.scalajs.dom

package d3v4 {
  object d3

  @js.native
  trait BaseEvent extends js.Object {
    var `type`: String = js.native
    var sourceEvent: dom.Event = js.native
  }

}

package object d3v4 {
  // type Primitive = Double | String | Boolean
  //
  // type DatumThisFunction3[Return] = js.ThisFunction3[CurrentDomElement, Datum, Index, Group, Return]
  // type DatumThisFunction2[Return] = js.ThisFunction2[CurrentDomElement, Datum, Index, Return]
  // type DatumThisFunction1[Return] = js.ThisFunction1[CurrentDomElement, Datum, Return]
  // type DatumThisFunction0[Return] = js.ThisFunction0[CurrentDomElement, Return]

  type CurrentDomElement = dom.EventTarget
  type Index = Int
  type Group = js.UndefOr[Int]

  type ValueFunction0[Return] = js.Function0[Return]
  type ValueFunction1[Datum, Return] = js.Function1[Datum, Return]
  type ValueFunction2[Datum, Return] = js.Function2[Datum, Index, Return]
  type ValueFunction3[Datum, Return] = js.Function3[Datum, Index, Group, Return]

  type ListenerFunction0 = ValueFunction0[Unit]
  type ListenerFunction1[Datum] = ValueFunction1[Datum, Unit]
  type ListenerFunction2[Datum] = ValueFunction2[Datum, Unit]
  type ListenerFunction3[Datum] = ValueFunction3[Datum, Unit]

  type ValueThisFunction0[E <: CurrentDomElement, Return] = js.ThisFunction0[E, Return]
  type ValueThisFunction1[E <: CurrentDomElement, Datum, Return] = js.ThisFunction1[E, Datum, Return]
  type ValueThisFunction2[E <: CurrentDomElement, Datum, Return] = js.ThisFunction2[E, Datum, Index, Return]
  type ValueThisFunction3[E <: CurrentDomElement, Datum, Return] = js.ThisFunction3[E, Datum, Index, Group, Return]

  type ListenerThisFunction0[E <: CurrentDomElement] = ValueThisFunction0[E, Unit]
  type ListenerThisFunction1[E <: CurrentDomElement, Datum] = ValueThisFunction1[E, Datum, Unit]
  type ListenerThisFunction2[E <: CurrentDomElement, Datum] = ValueThisFunction2[E, Datum, Unit]
  type ListenerThisFunction3[E <: CurrentDomElement, Datum] = ValueThisFunction3[E, Datum, Unit]

  trait DatumFunctionTypes[Datum] extends js.Any {
    type ValueFunction0 = js.Function0[Any]
    type ValueFunction1 = js.Function1[Datum, Any]
    type ValueFunction2 = js.Function2[Datum, Index, Any]
    type ValueFunction3 = js.Function3[Datum, Index, Group, Any]

    type ValueThisFunction0[E <: CurrentDomElement] = js.ThisFunction0[E, Any]
    type ValueThisFunction1[E <: CurrentDomElement] = js.ThisFunction1[E, Datum, Any]
    type ValueThisFunction2[E <: CurrentDomElement] = js.ThisFunction2[E, Datum, Index, Any]
    type ValueThisFunction3[E <: CurrentDomElement] = js.ThisFunction3[E, Datum, Index, Group, Any]

    type ValueFunctions = ValueFunction0 | ValueFunction1 | ValueFunction2 | ValueFunction3
    type ValueThisFunctions[E <: CurrentDomElement] = ValueThisFunction0[E] | ValueThisFunction1[E] | ValueThisFunction2[E] | ValueThisFunction3[E]
    type ValueFunction[E <: CurrentDomElement] = ValueFunctions | ValueThisFunctions[E]


    type ListenerFunction0 = js.Function0[Unit]                      
    type ListenerFunction1 = js.Function1[Datum, Unit]               
    type ListenerFunction2 = js.Function2[Datum, Index, Unit]        
    type ListenerFunction3 = js.Function3[Datum, Index, Group, Unit] 

    type ListenerThisFunction0[E <: CurrentDomElement] = js.ThisFunction0[E, Unit]                     
    type ListenerThisFunction1[E <: CurrentDomElement] = js.ThisFunction1[E, Datum, Unit]              
    type ListenerThisFunction2[E <: CurrentDomElement] = js.ThisFunction2[E, Datum, Index, Unit]       
    type ListenerThisFunction3[E <: CurrentDomElement] = js.ThisFunction3[E, Datum, Index, Group, Unit]

    type ListenerFunctions = ListenerFunction0 | ListenerFunction1 | ListenerFunction2 | ListenerFunction3
    type ListenerThisFunctions[E <: CurrentDomElement] = ListenerThisFunction0[E] | ListenerThisFunction1[E] | ListenerThisFunction2[E] | ListenerThisFunction3[E]
    type ListenerFunction[E <: CurrentDomElement] = ListenerFunctions | ListenerThisFunctions[E]
  }

  implicit def d3toD3Axis(d3t: d3.type): d3axis.type = d3axis
  implicit def d3toD3Color(d3t: d3.type): d3color.type = d3color
  implicit def d3toD3Drag(d3t: d3.type): d3drag.type = d3drag
  implicit def d3toD3Force(d3t: d3.type): d3force.type = d3force
  implicit def d3toD3Polygon(d3t: d3.type): d3polygon.type = d3polygon
  implicit def d3toD3Scale(d3t: d3.type): d3scale.type = d3scale
  implicit def d3toD3Selection(d3t: d3.type): d3selection.type = d3selection
  implicit def d3toD3Shape(d3t: d3.type): d3shape.type = d3shape
  implicit def d3toD3Time(d3t: d3.type): d3time.type = d3time
  implicit def d3toD3Quadtree(d3t: d3.type): d3quadtree.type = d3quadtree
  implicit def d3toD3Zoom(d3t: d3.type): d3zoom.type = d3zoom

  implicit class SelectionExtensions[Datum](val s: Selection[Datum]) extends AnyVal {
    def nodeAs[T <: dom.EventTarget] = s.node().asInstanceOf[T]
  }

  implicit class SimulationExtensions[N <: SimulationNode](val s: Simulation[N]) extends AnyVal {
    def forceAs[F <: Force[N]](name: String) = s.force(name).asInstanceOf[F]
  }

  implicit def baseEventToZoomEvent(e:BaseEvent):ZoomEvent = e.asInstanceOf[ZoomEvent]
}
