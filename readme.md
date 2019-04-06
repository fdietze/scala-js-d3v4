[![](https://jitpack.io/v/fdietze/scala-js-d3v4.svg)](https://jitpack.io/#fdietze/scala-js-d3v4)

# ScalaJS facade types for D3 version 5
* Heavily inspired by [spaced/scala-js-d3](https://github.com/spaced/scala-js-d3)
* D3 modules are imported automatically by bundler when needed.

## Usage
* Set up [Scalajs-Bundler](https://scalacenter.github.io/scalajs-bundler/) for your project.
* In your `build.sbt`:
  ```scala
  resolvers += "jitpack" at "https://jitpack.io"
  libraryDependencies += "com.github.fdietze" % "scala-js-d3v4" % "master-SNAPSHOT"
  ```

  When using [JitPack](https://jitpack.io), it is often more useful to point to a specific commit, to make your builds reproducible:

  ```scala
  libraryDependencies += "com.github.fdietze" % "scala-js-d3v4" % "08fc8de"
  ```

  Like that you can try the latest features from specific commits on `master`, other branches or PRs.


* Use d3 like you know it from JavaScript (http://devdocs.io/d3~4):

  ```scala
  import d3v4._

  d3.___
  ```

* Contribute missing facades as pull requests. Most of the time this can be done in a few lines of code. You get a good overview of what exists and what is missing when looking at [src/main/scala](https://github.com/fdietze/scala-js-d3v4/tree/master/src/main/scala). Each File corresponds to a module in d3: https://devdocs.io/d3~4. To add a new module, simply create a new file and implement the facades you need. Finally add an implicit to your module in [D3.scala](https://github.com/fdietze/scala-js-d3v4/blob/master/src/main/scala/D3.scala#L38).
* Don't hesitate to open new Issues.

## Facade writing guidelines
* Ref types involving null don't need a union type with Null. Provide wrapper methods mapping to Option.
* Prefer overloading in most cases. But use union types to avoid combinatorial explosion.
