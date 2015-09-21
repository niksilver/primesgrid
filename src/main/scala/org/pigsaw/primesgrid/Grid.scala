package org.pigsaw.primesgrid

/**
 * A multiplication grid. The numbers in the first row and the
 * first column are specified; all the other cell values are
 * calculated.
 * @param s  The integers in the first row and column of the grid.
 */
class Grid(s: Seq[Int]) {

  /** The value at row `i` column `j`.
    */
  // Scala has syntactic sugar as follows:
  // The `apply` method of a class can be omitted as a name
  // when calling it. So instead of saying g.apply(i,j)
  // we can say g(i,j).
  def apply(i: Int, j: Int) = s(i) * s(j)

  /** The text at row `i` column `j`, which is just the cell's
    * numeric value plus some padding at the start.
    */
  // Approach: return the value at the grid index as a string,
  // padded with `diff` spaces, where `diff` is the difference
  // between the length of the largest cell and this one.
  def textAt(i: Int, j: Int) = {
    val prod = apply(i, j).toString
    val diff = max.toString.length - prod.length
    (" " * diff) + prod
  }

  /** The largest value in the grid.
    */
  // The max value is the maximum value of the largest
  // square of all the input sequence. We don't assume
  // the input sequence is in ascending order, so that
  // might not be the last one.
  val max = (s map { x => x*x }).max

  /** The grid as a multi-line string.
    */
  // s.indices gives a sequence 0, 1, 2,... for each item in the
  // input sequence `s`.
  // s.indices map {textAt(row, _)} means "map each index to the
  // text at (row, that-index). The value `row` is looping through
  // each row index.
  // mkString(" ") means "string all the values of that sequence
  // together, with a space between each one.
  // So the value `lines` is a sequence containing each line of the grid.
  // Finally all those rows (lines) are joined with a carriage return
  // to produce the whole grid.
  val asText = {
    def rowAsText(row: Int) = (s.indices map {textAt(row, _)}).mkString(" ")
    (s.indices map {rowAsText(_)}).mkString("\n")
  }
}
