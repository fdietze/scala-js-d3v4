// https://www.scala-js.org/news/2018/02/01/announcing-scalajs-1.0.0-M3/#cross-building-for-scalajs-06x-and-1x
val scalaJSVersion = Option(System.getenv("SCALAJS_VERSION")).getOrElse("1.0.1")
addSbtPlugin("org.scala-js" % "sbt-scalajs" % scalaJSVersion)
val bundlerArtifact = if (scalaJSVersion.startsWith("0.6.")) "sbt-scalajs-bundler-sjs06" else "sbt-scalajs-bundler"
addSbtPlugin("ch.epfl.scala" % bundlerArtifact % "0.16.0")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.8.1")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "2.0.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "1.0.0")
