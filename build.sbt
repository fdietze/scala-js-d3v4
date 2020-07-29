name := "scala-js-d3v4"
version := "master-SNAPSHOT"

crossScalaVersions := Seq("2.11.12", "2.12.12", "2.13.3")
scalaVersion in ThisBuild := crossScalaVersions.value.last

enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)

libraryDependencies ++= (
  "org.scala-js" %%% "scalajs-dom" % "0.9.8" ::
  Nil
)
npmDependencies in Compile ++= (
  "d3" -> "5.9.2" :: // https://github.com/d3/d3/releases
  Nil
)

useYarn := true

// https://stackoverflow.com/questions/57115385/how-do-i-cross-compile-a-sbt-top-level-project-with-scalajs-0-6-and-1-0-0/57120136#57120136
scalacOptions ++= {
  if (scalaJSVersion.startsWith("0.6.")) Seq("-P:scalajs:sjsDefinedByDefault")
  else Nil
}

scalacOptions ++=
  "-encoding" :: "UTF-8" ::
  "-unchecked" ::
  "-deprecation" ::
  "-explaintypes" ::
  "-feature" ::
  "-language:_" ::
  // "-Xlint:_" ::
  // "-Ywarn-unused" ::
  Nil

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

scalacOptions ++= git.gitHeadCommit.value.map { headCommit =>
  val local = baseDirectory.value.toURI
  val remote = s"https://raw.githubusercontent.com/fdietze/scala-js-d3v4/${headCommit}/"
  s"-P:scalajs:mapSourceURI:$local->$remote"
}

Global / onChangedBuildSource := IgnoreSourceChanges
