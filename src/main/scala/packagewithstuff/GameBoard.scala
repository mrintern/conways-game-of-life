package packagewithstuff

import org.scalactic
import org.scalactic.Or

import scala.util.Random

/**
 * The game board. Where all the magic happens!
 */
case class GameBoard(rows: Int, cols: Int){
  /**
   * CONSTRUCTOR
   *    - create a 2 dimensional array to serve as the game board for our conway's "Game of Life" program
   *    - initialize all cells to zero
   */
  var board = Array.ofDim[Int](rows, cols)
  for(i <- 0 until rows)
    for(j <- 0 until cols)
      board(i)(j) = 0



  /**
   *  Prints version of the current state of the board
   */
  def printBoard(): Unit ={
    println("")
    for(i <- 0 until rows){
      for(j <- 0 until cols){
        print(s"${board(i)(j)}  ")
      }
      println("")
    }
  }
  /**
   *  Sets all cells on board to zero
   */
  def wipe: Unit ={
    for(i <- 0 until rows){
      for(j <- 0 until cols){
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
    for(i <- 0 until rows){
      for(j <- 0 until cols){
        val choice = Random.between(0.01,0.99)
        board (i)(j) = if(choice >= bound) 0 else 1
      }
    }
  }
//TODO finish countAlive function
  /**
   *  Returns the number of "alive" cells on the board
   */

  def countAlive(): Unit ={
    var count = 0
    for(i <- 0 until rows)
      for(j <- 0 until cols)
        if(board(i)(j) == 1) count += 1
    return count
  }

}
