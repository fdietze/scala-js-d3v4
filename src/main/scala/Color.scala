package d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._

// https://github.com/d3/d3-color
@JSImport("d3-color", JSImport.Namespace)
@js.native
object d3color extends js.Object {
  def lab(l: Double, a: Double, b: Double): Lab                  = js.native
  def lab(l: Double, a: Double, b: Double, opacity: Double): Lab = js.native
  def lab(specifier: String): Lab                                = js.native
  def lab(color: Color): Lab                                     = js.native

  def hcl(h: Double, c: Double, l: Double): Hcl                  = js.native
  def hcl(h: Double, c: Double, l: Double, opacity: Double): Hcl = js.native
  def hcl(specifier: String): Hcl                                = js.native
  def hcl(color: Color): Hcl                                     = js.native

  def rgb(r: Int, g: Int, b: Int): Rgb                           = js.native
  def rgb(r: Int, g: Int, b: Int, opacity: Int): Rgb             = js.native
  def rgb(specifier: String): Rgb                                = js.native
  def rgb(color: Color): Rgb                                     = js.native

  @js.native
  trait Rgb extends Color {
    def r: Int = js.native
    def g: Int = js.native
    def b: Int = js.native
    def a: Int = js.native
  }

  @js.native
  trait Lab extends Color {
    def l: Double = js.native
    def a: Double = js.native
    def b: Double = js.native
  }

  @js.native
  trait Hcl extends Color {
    def h: Double = js.native
    def c: Double = js.native
    def l: Double = js.native
  }

  @js.native
  trait Color extends js.Object {
    var opacity: Double             = js.native
    override def toString(): String = js.native
  }
}
