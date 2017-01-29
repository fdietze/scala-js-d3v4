# ScalaJS facade types for D3 version 4
* Heavily inspired by [spaced/scala-js-d3](https://github.com/spaced/scala-js-d3)

# Facade writing guidelines
* Ref types involving null don't need a union type with Null. Provide wrapper methods mapping to Option.
* Prefer overloading in most cases. But use union types to avoid combinatorial explosion.
