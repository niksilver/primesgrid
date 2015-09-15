package org.pigsaw.primesgrid

import org.scalatest.{FlatSpec, ShouldMatchers}

/**
 * Created by Nik on 15 Sep 2015.
 */
class PrimesTest extends FlatSpec with ShouldMatchers {

  "Primes.from(1)" should "give the first 7 numbers, from 1" in {
    Primes.from(1).take(7).toSeq should equal (Seq(1,2,3,4,5,6,7))
  }

  "Primes.seive" should "include the first item in the seive" in {
    val nums = Stream(7, 9, 20)
    Primes.seive(nums).head should equal (7)
  }

  it should "list the first nums of the stream if they aren't factors" in {
    val nums = Stream(7, 9, 20)
    Primes.seive(nums).take(3).toList should equal (List(7, 9, 20))
  }

  it should "filter out at least one factor if there is one" in {
    val nums = Stream(3, 4, 5, 6, 7)
    Primes.seive(nums).toList should equal (List(3, 4, 5, 7))
  }
}
