name in ThisBuild := "scala-js-d3v4"
version in ThisBuild := "0.1.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.12.1"
crossScalaVersions in ThisBuild := Seq("2.10.6", "2.11.8", "2.12.1")

lazy val root = project.in(file(".")).
  aggregate(ModuleProjectsPlugin.extraProjects.map(Project.projectToRef): _*).
  settings(
    publish := {},
    publishLocal := {}
  )

organization in Global := "com.github.fdietze"

//TODO: which licence for scala-js-facades?
