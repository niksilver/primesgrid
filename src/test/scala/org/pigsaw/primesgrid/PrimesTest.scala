package org.pigsaw.primesgrid

import org.scalatest.{FlatSpec, ShouldMatchers}

/**
 * Created by Nik on 15 Sep 2015.
 */
class PrimesTest extends FlatSpec with ShouldMatchers {

  "sieve" should "include the first item in the seive" in {
    val nums = Stream(7, 9, 20)
    Primes.sieve(nums).head should equal (7)
  }

  it should "list the first nums of the stream if they aren't factors" in {
    val nums = Stream(7, 9, 20)
    Primes.sieve(nums).take(3).toList should equal (List(7, 9, 20))
  }

  it should "filter out at least one factor if there is one" in {
    val nums = Stream(3, 4, 5, 6, 7)
    Primes.sieve(nums).toList should equal (List(3, 4, 5, 7))
  }

  it should "give a good list of primes from 2" in {
    val nums = Stream.from(2)
    Primes.sieve(nums).take(5).toList should equal (List(2, 3, 5, 7, 9))
  }

  "Primes.all" should "give all primes from 1" in {
    Primes.all.take(7).toList should equal (List(1, 2, 3, 5, 7, 9, 11))
  }
}
