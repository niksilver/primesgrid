package org.pigsaw.primesgrid

/**
 * Created by Nik on 15 Sep 2015.
 */
object Primes {

  def sieve(nums: Stream[Int]): Stream[Int] =
    nums.head #:: (nums.tail filter { _ % nums.head != 0})

  val all = 1 #:: sieve(Stream.from(2))
}
