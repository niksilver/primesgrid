package org.pigsaw.primesgrid

/**
 * Static functions for primes.
 */
object Primes {

  /** Given a stream of `nums`, return only those that are not
    * a factor of any others in the stream.
    */
  def sieve(nums: Stream[Int]): Stream[Int] =
    nums.head #:: (nums.tail filter { _ % nums.head != 0})

  /** All primes, starting at 1. */
  val all = 1 #:: sieve(Stream.from(2))
}
