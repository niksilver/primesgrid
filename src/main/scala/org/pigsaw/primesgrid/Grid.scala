package org.pigsaw.primesgrid

/**
 * Created by Nik on 15 Sep 2015.
 */
class Grid(s: Seq[Int]) {

  def apply(i: Int, j: Int) = s(i) * s(j)

  def textAt(i: Int, j: Int) = {
    val prod = apply(i, j).toString
    val diff = max.toString.length - prod.length
    (" " * diff) + prod
  }

  val max = (s map { x => x*x }).max
}
