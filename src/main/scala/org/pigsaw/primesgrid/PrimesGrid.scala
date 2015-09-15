package org.pigsaw.primesgrid

import java.text.ParseException

import scala.annotation.tailrec

/**
 * Created by Nik on 15 Sep 2015.
 */
class PrimesGrid(input: => String) {

  def size: Int = {
    val repeatInput = Stream.iterate(input)( _ => input )
    def isNumber(s: String) = s.matches("[0-9]+")
    def okayNumber(s: String) = {
      val n = Integer.parseInt(s)
      n >= 1
    }
    val numOpt = repeatInput find { s => isNumber(s) && okayNumber(s) }
    Integer.parseInt(numOpt.get)
  }

  def asText: String = {
    val g = new Grid(Primes.all.take(size))
    g.asText
  }
}

object PrimesGrid {

  def main(args: Array[String]): Unit = {
    println("Enter an integer of 1 or more...")
    val grid = new PrimesGrid({ io.StdIn.readLine() })
    println(grid.asText)
  }
}