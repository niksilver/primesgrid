package org.pigsaw.primesgrid

/**
 * Created by Nik on 15 Sep 2015.
 */
class Grid(s: Seq[Int]) {

  def apply(i: Int, j: Int) = s(i) * s(j)
}
