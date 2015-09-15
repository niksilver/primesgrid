package org.pigsaw.primesgrid

import org.scalatest.{FlatSpec, ShouldMatchers}

/**
 * Created by Nik on 15 Sep 2015.
 */
class PrimesTest extends FlatSpec with ShouldMatchers {

  "Primes.from(1)" should "give the first 7 numbers, from 1" in {
    Primes.from(1).take(7).toSeq should equal (Seq(1,2,3,4,5,6,7))
  }
}
