// https://www.scala-js.org/news/2018/02/01/announcing-scalajs-1.0.0-M3/#cross-building-for-scalajs-06x-and-1x
val scalaJSVersion = Option(System.getenv("SCALAJS_VERSION")).getOrElse("0.6.28")
addSbtPlugin("org.scala-js" % "sbt-scalajs" % scalaJSVersion)
val bundlerVersion = if (scalaJSVersion.startsWith("0.6.")) "0.15.0" else "0.15.0"
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % bundlerVersion)

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.6")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.2")

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "1.0.0")
