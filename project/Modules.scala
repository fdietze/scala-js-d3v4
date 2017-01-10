import sbt._
import Keys._
import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

case class Module(
  name: String,
  version: String,
  dependencies: Seq[String] = Nil
) {
  def subProject = {
    Project(s"scala-js-d3v4-$name", file(s"d3-$name"))
      .enablePlugins(ScalaJSPlugin)
      .settings(
        jsDependencies += "org.webjars.npm" % "d3-selection" % version
          / s"d3-$name.js" minified s"d3-$name.min.js"
          dependsOn (dependencies.map(m => s"d3-$m.js"): _*)
      )
  }
}

object ModuleProjectsPlugin extends AutoPlugin {
  val modules = (
    Module("array", "1.0.2") ::
    Module("axis", "1.0.4") ::
    Module("brush", "1.0.3") ::
    Module("chord", "1.0.3") ::
    Module("collection", "1.0.2") ::
    Module("color", "1.0.2") ::
    Module("dispatch", "1.0.2") ::
    Module("drag", "1.0.2") ::
    Module("dsv", "1.0.3") ::
    Module("ease", "1.0.2", dependencies = List("ease")) ::
    Module("force", "1.0.4", dependencies = List("selection")) ::
    Module("format", "1.0.2") ::
    Module("geo", "1.4.0") ::
    Module("geo-projection", "0.2.16") ::
    Module("hierarchy", "1.0.3") ::
    Module("interpolate", "1.1.2") ::
    Module("layout-timeline", "1.0.2") ::
    Module("path", "1.0.3") ::
    Module("plugins-dist", "3.2.0") ::
    Module("polygon", "1.0.2") ::
    Module("quadtree", "1.0.2") ::
    Module("queue", "3.0.3") ::
    Module("random", "1.0.2") ::
    Module("request", "1.0.3") ::
    Module("scale", "1.0.4") ::
    Module("selection", "1.0.3") ::
    Module("shape", "1.0.4") ::
    Module("time", "1.0.4") ::
    Module("time-format", "2.0.3") ::
    Module("timer", "1.0.3") ::
    Module("transition", "1.0.3") ::
    Module("voronoi", "1.1.0") ::
    Module("zoom", "1.1.1") ::
    Nil
  )
  val base = Project(s"scala-js-d3v4", file(s"scala-js-d3v4"))
    .enablePlugins(ScalaJSPlugin)
  override def extraProjects = base :: (modules map (_.subProject))
}
