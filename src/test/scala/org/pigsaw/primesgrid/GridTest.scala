package org.pigsaw.primesgrid

import org.scalatest.FlatSpec
import org.scalatest.ShouldMatchers

/**
 * Created by Nik on 15 Sep 2015.
 */
class GridTest extends FlatSpec with ShouldMatchers{

  def cross[T](s1: Seq[T], s2: Seq[T]): Seq[(T,T)] = for { i <- s1; j <- s2 } yield (i, j)

  "apply" should "give the product as appropriate" in {
    val g = new Grid(Seq(7,5,4,9))
    g(0,3) should equal (7*9)
    g(1,2) should equal (5*4)
    g(3,1) should equal (9*5)
  }

  "textAt" should "be spaces followed by the right number" in {
    val g = new Grid(Seq(7,5,4,9))
    g.textAt(0,3) should startWith (" ")
    g.textAt(0,3).trim should equal ((7*9).toString)
    cross(0 to 3, 0 to 3).foreach { c =>
      val (i, j) = c
      val prod = g(i, j)
      g.textAt(i, j) should startWith (" ")
      g.textAt(i, j).trim should equal (prod.toString)
    }
  }

}
