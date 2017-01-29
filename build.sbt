name := "scala-js-d3v4"
version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.1"
crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.1")

enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)

libraryDependencies ++= (
  "org.scala-js" %%% "scalajs-dom" % "0.9.1" ::
  Nil
)
npmDependencies in Compile ++= (
  "d3-array" -> "1.0.2" ::
  "d3-axis" -> "1.0.4" ::
  "d3-brush" -> "1.0.3" ::
  "d3-chord" -> "1.0.3" ::
  "d3-collection" -> "1.0.2" ::
  "d3-color" -> "1.0.2" ::
  "d3-dispatch" -> "1.0.2" ::
  "d3-drag" -> "1.0.2" ::
  "d3-dsv" -> "1.0.3" ::
  "d3-ease" -> "1.0.2" ::
  "d3-force" -> "1.0.4" ::
  "d3-format" -> "1.0.2" ::
  "d3-geo" -> "1.4.0" ::
  "d3-geo-projection" -> "0.2.16" ::
  "d3-hierarchy" -> "1.0.3" ::
  "d3-interpolate" -> "1.1.2" ::
  "d3-layout-timeline" -> "1.0.2" ::
  "d3-path" -> "1.0.3" ::
  "d3-plugins-dist" -> "3.2.0" ::
  "d3-polygon" -> "1.0.2" ::
  "d3-quadtree" -> "1.0.2" ::
  "d3-queue" -> "3.0.3" ::
  "d3-random" -> "1.0.2" ::
  "d3-request" -> "1.0.3" ::
  "d3-scale" -> "1.0.4" ::
  "d3-selection" -> "1.0.3" ::
  "d3-shape" -> "1.0.4" ::
  "d3-time" -> "1.0.4" ::
  "d3-time-format" -> "2.0.3" ::
  "d3-timer" -> "1.0.3" ::
  "d3-transition" -> "1.0.3" ::
  "d3-voronoi" -> "1.1.0" ::
  "d3-zoom" -> "1.1.1" ::
  Nil
)

scalacOptions ++=
  "-encoding" :: "UTF-8" ::
  "-unchecked" ::
  "-deprecation" ::
  "-explaintypes" ::
  "-feature" ::
  "-language:_" ::
  "-Xlint:_" ::
  "-Ywarn-unused" ::
  Nil

organization in Global := "com.github.fdietze"

pgpSecretRing in Global := file("secring.gpg")
pgpPublicRing in Global := file("pubring.gpg")
pgpPassphrase in Global := Some("".toCharArray)

organization in Global := "com.github.fdietze"

pomExtra := {
  <url>https://github.com/fdietze/scala-js-d3v4</url>
  <licenses>
    <license>
      <name>Apache 2</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/fdietze/scala-js-d3v4</url>
    <connection>scm:git:git@github.com:fdietze/scala-js-d3v4.git</connection>
  </scm>
  <developers>
    <developer>
      <id>fdietze</id>
      <name>Felix Dietze</name>
      <url>https://github.com/fdietze</url>
    </developer>
  </developers>
}
