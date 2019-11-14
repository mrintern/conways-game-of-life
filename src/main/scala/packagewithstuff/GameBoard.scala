package packagewithstuff

import scala.util.Random

/**
 * COMPANION OBJECT
 *  - allows us to run tests on the constructor
 *  - as well as other things
 *
 */
object GameBoard {
  def apply(size: Int): Option[GameBoard] = {
    if(size < 10 ||  size < 10 ) None else Some(new GameBoard(size))
  }
}
/**
 * The game board. Where all the magic happens!
 */
case class GameBoard(size: Int){
  /**
   * CONSTRUCTOR
   *    - create a 2 dimensional array to serve as the game board for our conway's "Game of Life" program
   *    - initialize all cells to zero
   */
  var board: Array[Array[Int]] = Array.ofDim[Int](size,size)
  for(i <- 0 until size)
    for(j <- 0 until size)
      board(i)(j) = 0
  /**
   *  Prints version of the current state of the board
   */
  def printBoard(): Unit ={
    println("")
    for(i <- 0 until size){
      for(j <- 0 until size){
        print(s"${board(i)(j)}  ")
      }
      println("")
    }
  }
  /**
   *  Sets all cells on board to zero
   */
  def wipe: Unit ={
    for(i <- 0 until size){
      for(j <- 0 until size){
        board(i)(j) = 0
      }
    }
  }
  /**
   *  Randomly populates board using probability
   *    -bound: a double between 0.01 and .99 that determines the probability that any individual cell becomes 1 ('alive')
   *      example: bound = .1 means there is a 10% chance any given cell is a 1 ('alive')
   */
  def randomize(bound: Double, value: Int = 0): Unit ={
    for(i <- 0 until size){
      for(j <- 0 until size){
        // value is a parameter for testing purposes only
        // it verifies that board has been populated using randomness
        val choice = if(value == 0) Random.between(0.01,0.99) else value
        board(i)(j) = if(choice == value) 9 else if(choice >= bound) 0 else 1

      }
    }
  }
  /**
   *  Returns the number of "alive" cells on the current board
   */
  def countAlive: Int ={
    var alive = 0
    for(i <- 0 until size)
      for(j <- 0 until size)
        if(board(i)(j) == 1) alive += 1
    alive
  }
  //TODO: raise-error functionality
  //TODO: count neighbors of live and dead cells
  //TODO: How can return 'None' if coordinates are out of bounds?
  def countNeighbors(x: Int, y: Int): Option[Int] ={
    // check that original coordinates are not out-of-bounds
    if(x < 0 || y < 0 || x >= board.length || y >= board.length)
      None
    else {
      // define neighbor coordinates
      val (topX: Int, topY: Int) = (x - 1, y)
      val (leftX: Int, leftY: Int) = (x, y - 1)
      val (bottomX: Int, bottomY: Int) = (x + 1, y)
      val (rightX: Int, rightY: Int) = (x, y + 1)
      val (topLeftX: Int, topLeftY: Int) = (x - 1, y - 1)
      val (bottomLeftX: Int, bottomLeftY: Int) = (x + 1, y - 1)
      val (topRightX: Int, topRightY: Int) = (x - 1, y + 1)
      val (bottomRightX: Int, bottomRightY: Int) = (x + 1, y + 1)

      // check that neighbor coordinates are not out-of-bounds
      // count neighbors
      val top = if (topX < 0 || topX >= board.length) 0 else board(topX)(topY)
      val left = if (leftY < 0 || leftY >= board.length) 0 else board(leftX)(leftY)
      val bottom = if (bottomX < 0 || bottomX >= board.length) 0 else board(bottomX)(bottomY)
      val right = if (rightY < 0 || rightY >= board.length) 0 else board(rightX)(rightY)
      val topLeft = if (topLeftX < 0 || topLeftY < 0 || topLeftX >= board.length || topLeftY >= board.length) 0 else board(topLeftX)(topLeftY)
      val bottomLeft = if (bottomLeftX < 0 || bottomLeftY < 0 || bottomLeftX >= board.length || bottomLeftY >= board.length) 0 else board(bottomLeftX)(bottomLeftY)
      val topRight = if (topRightX < 0 || topRightY < 0 || topRightX >= board.length || topRightY >= board.length) 0 else board(topRightX)(topRightY)
      val bottomRight = if (bottomRightX < 0 || bottomRightY < 0 || bottomRightX >= board.length || bottomRightY >= board.length) 0 else board(bottomRightX)(bottomRightY)

      // count 'alive' neighbors
      val count: Some[Int] = Some(top + left + bottom + right + topLeft + bottomLeft + topRight + bottomRight)
      // return
      count
    }
  }

}
