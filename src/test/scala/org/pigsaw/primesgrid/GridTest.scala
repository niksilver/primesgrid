package org.pigsaw.primesgrid

import org.scalatest.FlatSpec
import org.scalatest.ShouldMatchers

/**
 * Created by Nik on 15 Sep 2015.
 */
class GridTest extends FlatSpec with ShouldMatchers{

  "apply" should "give the product as appropriate" in {
    val g = new Grid(Seq(7,5,4,9))
    g(0,3) should equal (7*9)
    g(1,2) should equal (5*4)
    g(3,1) should equal (9*5)
  }
}
