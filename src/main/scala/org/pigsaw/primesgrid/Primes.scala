package org.pigsaw.primesgrid

/**
 * Created by Nik on 15 Sep 2015.
 */
object Primes {

  def from(start: Int): Stream[Int] = start #:: from(start+1)
}
