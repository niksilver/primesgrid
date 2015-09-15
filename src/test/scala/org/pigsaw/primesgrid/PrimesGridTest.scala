package org.pigsaw.primesgrid

import org.scalatest._

/**
 * Created by Nik on 15 Sep 2015.
 */
class PrimesGridTest extends FlatSpec with ShouldMatchers {

  "size" should "give an Int if an Int is given immediately" in {
    def inputs() = { "123" }
    val g = new PrimesGrid(inputs())
    g.size should equal (123)
  }

  it should "given an Int if an Int is given eventually" in {
    val it = Seq("aa", "bb", "99").iterator
    def inputs() = { it.next }
    val g = new PrimesGrid(inputs())
    g.size should equal (99)
  }

  it should "reject an Int of 0" in {
    val it = Seq("aa", "0", "99").iterator
    def inputs() = { it.next }
    val g = new PrimesGrid(inputs())
    g.size should equal (99)
  }

  it should "reject an Int of less than zero" in {
    val it = Seq("aa", "-99", "101").iterator
    def inputs() = { it.next }
    val g = new PrimesGrid(inputs())
    g.size should equal (101)
  }
}
