package org.pigsaw.primesgrid

import java.text.ParseException

/**
 * Created by Nik on 15 Sep 2015.
 */
class PrimesGrid(input: => String) {

  def size: Int = {
    def repeatInput: Int = {
      try {
        Integer.parseInt(input)
      } catch {
        case e: NumberFormatException => repeatInput
      }
    }
    repeatInput
  }
}
