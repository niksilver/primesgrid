package org.pigsaw.primesgrid

import java.text.ParseException

import scala.annotation.tailrec

/**
 * A square grid of primes.
 * @param input  A function that will give a string representing the size of
 *               the grid. It will be tried repeatedly until its value can
 *               represent a positive integer.
 */
class PrimesGrid(input: => String) {

  /** The size of the grid.
    */
  def size: Int = {
    val repeatInput = Stream.continually(input)
    def isNumber(s: String) = s.matches("[0-9]+")
    def okayNumber(s: String) = {
      val n = BigInt(s)
      n >= 1 && n <= Integer.MAX_VALUE
    }
    val numOpt = repeatInput find { s => isNumber(s) && okayNumber(s) }
    Integer.parseInt(numOpt.get)
  }

  /**
   * The grid as multi-line text.
   */
  def asText: String = {
    val g = new Grid(Primes.all.take(size))
    g.asText
  }
}

object PrimesGrid {

  /** Application entry point, where size of grid is taken
    * from standard input, and the grid is sent to standard output.
    */
  def main(args: Array[String]): Unit = {
    println("Enter an integer of 1 or more...")
    val grid = new PrimesGrid({ io.StdIn.readLine() })
    println(grid.asText)
  }
}