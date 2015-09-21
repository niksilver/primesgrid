package org.pigsaw.primesgrid

import java.text.ParseException

import scala.annotation.tailrec

/**
 * A square grid of primes.
 * @param input  A function that will give a string representing the size of
 *               the grid. It will be tried repeatedly until its value can
 *               represent a positive integer.
 */
// input: => String
//   means "parameter named input, which is a function returning a String
//   (with no parameters itself).
// That's different from:
// input: String
//   which means "parameter named input which is a String"
// input: (Int) => String
//   which means "parameter named input which is a function that takes an
//   Int and returns a String.
class PrimesGrid(input: => String) {

  /** The size of the grid.
    */
  def size: Int = {
    // A potentially infinite stream of inputs, each time getting
    // a string.
    val repeatInput = Stream.continually(input)
    // Function asking: Is `s` a series of digits?
    def isNumber(s: String) = s.matches("[0-9]+")
    // Function asking: Is `s` at least one, and at most
    // the biggest Int possible? We use BigInt to parse the
    // string `s` because it might be too big for an Integer.
    // But in this implementation it will parse because we're
    // only going to call this function is it's already passed
    // this inNumber test.
    def okayNumber(s: String) = {
      val n = BigInt(s)
      n >= 1 && n <= Integer.MAX_VALUE
    }
    // Find a (String) input that passes both the above tests.
    val numOpt = repeatInput find { s => isNumber(s) && okayNumber(s) }
    // The function `find` can't guarantee it will always find what it's
    // looking for in any given sequence, so it return not an String, but
    // an Option[String]. That's an important type in Scala. It means it's
    // either a Some[String] or special value None. That's interpreted as
    // "a container with a String, or nothing". But with our implementation
    // we know that if we've got this far then it will have got Some[String]
    // so we can extract the string from from the container with the `get` method.
    // Then we need to parse it, as we know it's a valid integer.
    Integer.parseInt(numOpt.get)
  }

  /**
   * The grid as multi-line text.
   */
  // We'll create a primes grid as a product grid, but with the
  // input sequence as a series of primes. Method Primes.all
  // is an infinite stream, so we're careful only to take the first
  // `size` elements.
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