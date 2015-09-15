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

  it should "reject a decimal" in {
    val it = Seq("aa", "9.9", "101").iterator
    def inputs() = { it.next }
    val g = new PrimesGrid(inputs())
    g.size should equal (101)
  }

  "asText" should "give the grid or primes as text" in {
    val g = new PrimesGrid({ "4" })
    val text = g.asText
    val lines = text.lines.toList
    lines(0) should equal (" 1  2  3  5")
    lines(1) should equal (" 2  4  6 10")
    lines(2) should equal (" 3  6  9 15")
    lines(3) should equal (" 5 10 15 25")
  }

}
