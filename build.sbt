name         := "scala-js-d3v4"
version      := "master-SNAPSHOT"
organization := "com.github.fdietze.scala-js-d3v4"

crossScalaVersions := Seq("2.12.15", "2.13.7", "3.1.0")
scalaVersion       := crossScalaVersions.value.last
scalacOptions --= Seq("-Xfatal-warnings") // overwrite sbt-tpolecat setting

enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "2.0.0",
)
Compile / npmDependencies ++= Seq(
  "d3" -> "5.9.2", // https://github.com/d3/d3/releases
)

useYarn := true

/* pgpSecretRing in Global := file("secring.gpg") */
/* pgpPublicRing in Global := file("pubring.gpg") */
/* pgpPassphrase in Global := Some("".toCharArray) */

/* organization in Global := "com.github.fdietze" */

/* pomExtra := { */
/*   <url>https://github.com/fdietze/scala-js-d3v4</url> */
/*   <licenses> */
/*     <license> */
/*       <name>MIT</name> */
/*       <url>http://opensource.org/licenses/MIT</url> */
/*     </license> */
/*   </licenses> */
/*   <scm> */
/*     <url>https://github.com/fdietze/scala-js-d3v4</url> */
/*     <connection>scm:git:git@github.com:fdietze/scala-js-d3v4.git</connection> */
/*   </scm> */
/*   <developers> */
/*     <developer> */
/*       <id>fdietze</id> */
/*       <name>Felix Dietze</name> */
/*       <url>https://github.com/fdietze</url> */
/*     </developer> */
/*   </developers> */
/* } */
