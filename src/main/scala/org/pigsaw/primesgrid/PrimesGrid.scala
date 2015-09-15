package org.pigsaw.primesgrid

import java.text.ParseException

import scala.annotation.tailrec

/**
 * Created by Nik on 15 Sep 2015.
 */
class PrimesGrid(input: => String) {

  def size: Int = {
    @tailrec
    def repeatInput: Int = {
      try {
        val num = Integer.parseInt(input)
        if (num <= 0) throw new NumberFormatException
        num
      } catch {
        case e: NumberFormatException => repeatInput
      }
    }
    repeatInput
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