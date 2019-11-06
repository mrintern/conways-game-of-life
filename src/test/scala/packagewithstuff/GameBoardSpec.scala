package packagewithstuff

import org.scalatest.FlatSpec

/**
 * This is where the tests for GameBoard lives
 */

case class GameBoardSpec() extends FlatSpec{
  "the GameBoardSpec constructor" should "produce a 2d array of size ROWS x COLUMNS" in{
    val gameBoard = new GameBoard(10,5)
    assert(gameBoard.board.length == 10)
    assert(gameBoard.board(0).length == 5)
  }

  "the wipe method" should "set all cells to zero" in{
    val gameBoard = new GameBoard(10,5)
//    for(i <- 0 until gameBoard.rows)
//      for(j <- 0 until gameBoard.cols)
//
    for(i <- 0 until gameBoard.rows)
      assert(gameBoard.board(i).forall(_ == 0))

    gameBoard.board.map(xs => xs.forall(_ == 0)).forall(_.equals(true))
  }

}