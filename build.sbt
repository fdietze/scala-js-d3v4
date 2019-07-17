name := "scala-js-d3v4"
version := "master-SNAPSHOT"

crossScalaVersions := Seq("2.10.7", "2.11.12", "2.12.8")
scalaVersion in ThisBuild := crossScalaVersions.value.last

enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)

libraryDependencies ++= (
  "org.scala-js" %%% "scalajs-dom" % "0.9.7" ::
  Nil
)
npmDependencies in Compile ++= (
  "d3" -> "5.9.2" :: // https://github.com/d3/d3/releases
  Nil
)

useYarn := true

scalacOptions ++=
  "-encoding" :: "UTF-8" ::
  "-unchecked" ::
  "-deprecation" ::
  "-explaintypes" ::
  "-feature" ::
  "-language:_" ::
  // "-Xlint:_" ::
  // "-Ywarn-unused" ::
  "-P:scalajs:sjsDefinedByDefault" ::
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
      <name>MIT</name>
      <url>http://opensource.org/licenses/MIT</url>
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
