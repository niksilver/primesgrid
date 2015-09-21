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
  def apply(i: Int, j: Int) = s(i) * s(j)

  /** The text at row `i` column `j`, which is just the cell's
    * numeric value plus some padding at the start.
    */
  def textAt(i: Int, j: Int) = {
    val prod = apply(i, j).toString
    val diff = max.toString.length - prod.length
    (" " * diff) + prod
  }

  /** The largest value in the grid.
    */
  val max = (s map { x => x*x }).max

  /** The grid as a multi-line string.
    */
  val asText = {
    def rowAsText(row: Int) = (s.indices map {textAt(row, _)}).mkString(" ")
    (s.indices map {rowAsText(_)}).mkString("\n")
  }
}
