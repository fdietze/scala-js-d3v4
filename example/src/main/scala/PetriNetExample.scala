import d3v4._

import scala.scalajs.js

// Adapted from https://github.com/kyouko-taiga/petri-js
object PetriNetExample {
  val TRANSITION_SIDE = 30
  val PLACE_RADIUS = math.sqrt(TRANSITION_SIDE * TRANSITION_SIDE / 2)
  def main(args: Array[String]): Unit = {
    val places = (0 to 2).map(i => Place(i.toString))
    val transitions = places.inits.toVector.dropRight(1).zipWithIndex.map { case (places, i) =>
      Transition(i.toString, i.toString, places.map(_ -> 1).toMap, places.map(_ -> 1).toMap)
    }
    val petriNet = new PetriNet("#petrinet", Model(places = places, transitions = transitions))
    petriNet.render()
  }

  type Marking = js.Map[Place, Int]
  case class Model(places: Seq[Place], transitions: Seq[Transition])
  trait Vertex extends SimulationNodeImpl {
    def id: String
  }

  case class Place(id: String) extends Vertex
  case class Transition(id: String, name: String, preconditions: Map[Place, Int], postconditions: Map[Place, Int])
      extends Vertex
  case class Arc(id: String, label: String, source: Vertex, target: Vertex) extends SimulationLinkImpl[Vertex, Vertex]

  /** Class representing a Petri Net simulator.
    *
    * This class holds the state of a Petri Net simulator, and renders its view. The semantics of the
    * underlying Petri Net model is customizable (see constructor), but defaults to Place/Transition
    * nets (see https://en.wikipedia.org/wiki/Petri_net).
    */
  class PetriNet(element: String, model: Model) {
    var marking: Marking = js.Map()

    /** Creates a Petri Net simulator.
      *
      * @param {HTMLElement} element - An SVG node the simulator will be rendered to.
      * @param {Object}      model   - The Petri Net model to simulate.
      * @param {Object}      options - Additional options
      */

    val svg = d3.select(element)
    val width = svg.node().getBoundingClientRect().width
    val height = svg.node().getBoundingClientRect().height

    // Build the arrow en marker. Note that arrows are drawn like that: ``-->-``. Hence we should draw
    // their source and target nodes over them, so as to hide the exceeding parts.
    this.svg
      .append("svg:defs")
      .selectAll("marker")
      .data(js.Array("end"))
      .enter()
      .append("svg:marker")
      .attr("id", "end")
      .attr("refX", TRANSITION_SIDE)
      .attr("refY", 4)
      .attr("markerWidth", 12)
      .attr("markerHeight", 12)
      .attr("orient", "auto")
      .append("svg:path")
      .attr("d", "M0,0 L0,8 L8,4 z")

    val arcsGroup = this.svg.append("g").attr("class", "arcs")
    val nodesGroup = this.svg.append("g").attr("class", "nodes")

    // Create the force simulation.
    val simulation = d3
      .forceSimulation()
      // TODO .force("link", d3.forceLink().id((d) => d.id).distance(50))
      .force("charge", d3.forceManyBody())
      .force("center", d3.forceCenter(width / 2, height / 2))
      .force("collide", d3.forceCollide[SimulationNode]().radius((_: SimulationNode) => TRANSITION_SIDE * 2.0))
      .on(
        "tick",
        () => {
          this.nodesGroup
            .selectAll[Vertex]("g")
            .attr("transform", (d) => s"translate(${d.x}, ${d.y})")
          this.arcsGroup
            .selectAll[Arc]("g line")
            .attr("x1", (d) => d.source.x)
            .attr("y1", (d) => d.source.y)
            .attr("x2", (d) => d.target.x)
            .attr("y2", (d) => d.target.y)
          this.arcsGroup
            .selectAll[Arc]("g text")
            .attr("x", (d) => (d.source.x.get + d.target.x.get) / 2)
            .attr("y", (d) => (d.source.y.get + d.target.y.get) / 2)
        }
      )

    def handleDragStart(d: Vertex) {
      if (d3.event.active == 0) {
        this.simulation.alphaTarget(0.3).restart()
      }
      d.fx = d.x
      d.fy = d.y

    }

    def handleDrag(d: Vertex) {
      d.fx = d3.event.x
      d.fy = d3.event.y

    }

    def handleDragEnd(d: Vertex) {
      if (d3.event.active == 0) {
        this.simulation.alphaTarget(0)
      }
      d.fx = null
      d.fy = null

    }

    def render() = {
      // Adapt places and transitions data to d3. The goal is to create an array that contains all
      // vertices and another that contains all edges, so that it'll be easier to handle them in the
      // force simulation later on.
      val vertices = js.Array(model.places.concat(model.transitions): _*)
      val edges = model.transitions
        .map((transition) => {
          val preconditions = transition.preconditions
            .map { case (place, label) =>
              Arc(
                id = s"${place.id}->${transition.id}",
                source = place,
                target = transition,
                label = label.toString
              )
            }
          val postconditions = transition.postconditions
            .map { case (place, label) =>
              Arc(
                id = s"${transition.id}->${place.id}",
                source = transition,
                target = place,
                label = label.toString
              )
            }
          preconditions ++ postconditions
        })
        .reduce(_ ++ _)
      // Draw new places and new transitions.
      var arcs = this.arcsGroup
        .selectAll[Arc]("g")
        .data(js.Array(edges.toSeq: _*), (d: Arc) => d.id)
      arcs.exit().remove()

      val arcsEnter = arcs
        .enter()
        .append("g")
        .attr("id", _.id)
      arcsEnter
        .append("line")
        .attr("stroke", "black")
        .attr("stroke-width", 1)
        .attr("marker-end", "url(#end)")
      arcsEnter
        .filter(_.label != "1")
        .append("text")
        .text(_.label)

      arcs = arcsEnter.merge(arcs)

      val nodes = this.nodesGroup
        .selectAll[Vertex]("g")
        .data(vertices, _.id)

      val nodesEnter = nodes
        .enter()
        .append("g")
        .attr("id", _.id)
        .attr(
          "class",
          _ match {
            case _: Place => "place"
            case _: Transition => "transition"
          }
        )
        .call(
          d3.drag[Vertex]()
            .on("start", handleDragStart _)
            .on("drag", handleDrag _)
            .on("end", handleDragEnd _)
        )

      val places = nodesEnter.filter(".place")
      places
        .append("circle")
        .attr("r", PLACE_RADIUS)
        .attr("fill", "rgb(255, 248, 220)")
        .attr("stroke", "rgb(224, 220, 191)")
        .attr("stroke-width", "3px")
      places
        .append("text")
        .attr("class", "marking")
        .attr("text-anchor", "middle")
        .attr("alignment-baseline", "central")
      places
        .append("text")
        .attr("text-anchor", "left")
        .attr("alignment-baseline", "central")
        .attr("dx", PLACE_RADIUS * 1.25)
        .text((place) => place.id)

      val transitions = nodesEnter
        .filter(".transition")
        .attr("cursor", "pointer")
      transitions
        .append("circle")
        .attr("r", PLACE_RADIUS)
        .attr("fill", "white")
      transitions
        .append("rect")
        .attr("width", TRANSITION_SIDE)
        .attr("height", TRANSITION_SIDE)
        .attr("x", -TRANSITION_SIDE / 2)
        .attr("y", -TRANSITION_SIDE / 2)
        .attr("fill", "rgb(220, 227, 255)")
        .attr("stroke", "rgb(169, 186, 255)")
        .attr("stroke-width", 3)
      transitions
        .append("text")
        .attr("text-anchor", "middle")
        .attr("alignment-baseline", "central")
        .text((transition) => transition.id)
      // Run the force simulation to space out places and transitions.
      this.simulation
        .nodes(vertices.map(_.asInstanceOf[SimulationNode]))
        .force("link", d3.forceLink(js.Array(edges.toSeq: _*)))

    }

  }
}
