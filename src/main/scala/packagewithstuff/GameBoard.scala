package packagewithstuff

import org.scalactic
import org.scalactic.Or

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
  var board = Array.ofDim[Int](size,size)
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
  def randomize(bound: Double): Unit ={
    for(i <- 0 until size){
      for(j <- 0 until size){
        val choice = Random.between(0.01,0.99)
        board(i)(j) = if(choice >= bound) 0 else 1
      }
    }
  }
  /**
   *  Returns the number of "alive" cells on the current board
   */
  def countAlive(): Int ={
    var alive = 0
    for(i <- 0 until size)
      for(j <- 0 until size)
        if(board(i)(j) == 1) alive += 1
    alive
  }

}
