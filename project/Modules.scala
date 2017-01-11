import sbt._
import Keys._
import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

import collection.breakOut

case class Module(
  name: String,
  jsVersion: String,
  dependencies: Seq[String] = Nil
) {
  lazy val project = {
    Project(s"scala-js-d3v4-$name", file(s"d3-$name"))
      .enablePlugins(ScalaJSPlugin)
      .dependsOn(ModuleProjectsPlugin.base)
      .settings(
        version := jsVersion, // TODO: should the facade version reflect the js version?

        jsDependencies += "org.webjars.npm" % s"d3-$name" % jsVersion
          / s"d3-$name.js" minified s"d3-$name.min.js"
          dependsOn (dependencies.map(m => s"d3-$m.js"): _*),

        scalacOptions ++= (
          "-unchecked" ::
          "-deprecation" ::
          "-feature" ::
          "-language:implicitConversions" ::
          Nil
        )
      )
  }
  lazy val projectRef = Project.projectToRef(project)
}

object ModuleProjectsPlugin extends AutoPlugin {
  //TODO: how to declare dependencies?
  // - project.dependsOn ?
  // - jsDependencies( dependsOn ) ?
  val modules = (
    // https://github.com/d3/d3/blob/master/API.md
    // http://www.webjars.org/npm
    Module("array", "1.0.2") ::
    Module("axis", "1.0.4") ::
    Module("brush", "1.0.3") ::
    Module("chord", "1.0.3") ::
    Module("collection", "1.0.2") ::
    Module("color", "1.0.2") ::
    Module("dispatch", "1.0.2") ::
    Module("drag", "1.0.2") ::
    Module("dsv", "1.0.3") ::
    Module("ease", "1.0.2") ::
    Module("force", "1.0.4", dependencies = List("selection")) ::
    Module("format", "1.0.2") ::
    Module("geo", "1.4.0") ::
    // TODO: Module("geo-projection", "0.2.16") :: // strange webjar dependencies: esutils, estraverse, esprima
    Module("hierarchy", "1.0.3") ::
    Module("interpolate", "1.1.2") ::
    //TODO: Module("layout-timeline", "1.0.2") :: // different js file names: d3.layout.timeline.js, no minified
    Module("path", "1.0.3") ::
    // TODO: Module("plugins-dist", "3.2.0") ::
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

  // The base project contains only the native d3 object and trait, which other modules extend via implicits
  val base = Project(s"scala-js-d3v4", file(s"d3"))
    .enablePlugins(ScalaJSPlugin)

  val findModule: Map[String, Module] = modules.map(m => m.name -> m)(breakOut)

  val moduleProjectsWithDeps: List[Project] = modules.map { module =>
    val dependencies = module.dependencies.map(d => findModule(d).projectRef)
    dependencies.foldLeft(module.project)((project, dep) => project.dependsOn(dep))
  }

  override def extraProjects = base :: moduleProjectsWithDeps
}
