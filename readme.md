[![](https://jitpack.io/v/fdietze/scala-js-d3v4.svg)](https://jitpack.io/#fdietze/scala-js-d3v4)

# ScalaJS facade types for D3 version 4
* Heavily inspired by [spaced/scala-js-d3](https://github.com/spaced/scala-js-d3)
* D3 modules are imported automatically by bundler when needed.

## Usage
* Set up [Scalajs-Bundler](https://scalacenter.github.io/scalajs-bundler/) for your project.
* In your `build.sbt`:
  ```scala
  resolvers += "jitpack" at "https://jitpack.io"
  libraryDependencies += "com.github.fdietze" % "scala-js-d3v4" % "master-SNAPSHOT"
  ```
* Use d3 like you know it from JavaScript (http://devdocs.io/d3~4):

  ```scala
  import org.scalajs.d3v4._

  d3.___
  ```

* Contribute missing facades as pull requests.
* Don't hesitate to open new Issues.

## Facade writing guidelines
* Ref types involving null don't need a union type with Null. Provide wrapper methods mapping to Option.
* Prefer overloading in most cases. But use union types to avoid combinatorial explosion.
