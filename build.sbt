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
