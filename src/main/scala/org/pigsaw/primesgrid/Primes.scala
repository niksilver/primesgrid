package org.pigsaw.primesgrid

/**
 * Static functions for primes.
 */
object Primes {

  /** Given a stream of `nums`, return only those that are not
    * a factor of any others in the stream.
    */
  def sieve(nums: Stream[Int]): Stream[Int] =
    // A Stream is a possibly infinite series of values. (In this case
    // we'll be dealing with a Stream of Ints.) Each value of a Stream is
    // only calculated as needed, so it's usually specified with a
    // function that says how to calculate the values.
    // The #:: is the cons operator for a Stream. The left hand value
    // is the head of the Stream, and the right hand value is a function
    // that specifies how to generate the tail of the Stream.
    // This recursive function `sieve` returns a value that's explained like this:
    // The head of `sieve` is the head of nums, and the rest of `sieve` is
    // the rest of nums, but include only those of its values which are not
    // a factor of that first value (nums.head).
    nums.head #:: (nums.tail filter { _ % nums.head != 0})

  /** All primes, starting at 1. */
  // Stream.from(n) is a standard Stream function that gives all integers
  // from n onwards.
  // The `sieve` function will eliminate every single integer if it's
  // fed the value 1, so "all primes" is set at 1 followed by
  // the sieve of all integers from 2 onwards.
  val all = 1 #:: sieve(Stream.from(2))
}
