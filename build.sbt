name := "scala-js-d3v4"
version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.1"
crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.1")

lazy val root = project.in(file(".")).
  aggregate(ModuleProjectsPlugin.extraProjects.map(Project.projectToRef): _*).
  settings(
    publish := {},
    publishLocal := {}
  )

organization in Global := "com.github.fdietze"

//TODO: which licence for scala-js-facades?
