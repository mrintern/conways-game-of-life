package packagewithstuff

import org.scalatest.{Matchers, WordSpec}

/**
 * This is where the tests for GameBoard lives
 */
// TODO: Test that board only contains 0 or 1 at every function
// TODO: Show the type of every variable by using 'alt + enter'
// TODO: get advice on testing random method
// TODO
class GameBoardSpec extends WordSpec with Matchers {
  "the GameBoardSpec constructor" should {
    "given a size of zero should return none" in {
      val actual: Option[GameBoard] = GameBoard(size = 0)
      val expected: Option[GameBoard] = None
      assert(actual equals expected)
    }
    "given a size of 1 should return none" in {
      val actual: Option[GameBoard] = GameBoard(size = 1)
      val expected: Option[GameBoard] = None
      assert(actual equals expected)
    }
    "initialize all the cells on the board to 0" in {
      val actual = GameBoard(size = 10).get
      for(i <- 0 until actual.size)
        assert(actual.board(i).forall(_ == 0))
    }
  }

  "the wipe method" should {
    "given a GameBoard with only 0's, return a GameBoard of only 0's" in {
      val game = GameBoard(size = 10).get
      for(i <- 0 until game.size)
        assert(game.board(i).forall(_ == 0))
    }
    "given a GameBoard with 1 alive cell, return a GameBoard of only 0's" in {
      val game = GameBoard(size = 10).get
      game.board(5)(5) = 1
      game.wipe
      for(i <- 0 until game.size)
        assert(game.board(i).forall(_ == 0))
    }
    "given a GameBoard with 5 alive cells, return a GameBoard of only 0's" in {
      val game = GameBoard(size = 10).get
      game.board(5)(0) = 1
      game.board(4)(0) = 1
      game.board(3)(0) = 1
      game.board(2)(0) = 1
      game.board(1)(0) = 1
      game.wipe
      for(i <- 0 until game.size)
        assert(game.board(i).forall(_ == 0))
    }
  }

  "the randomize method" should {
    "return a game board with 0, 1, or many alive cells" in {

    }
  }

  "the countAlive method" should {
    "return zero if no cells are alive on the current GameBoard" in {
      val game = GameBoard(size = 10).get
      val expected = 0
      for(i <- 0 until game.size)
        assert(game.board(i).forall(_ == expected))
    }
    "return 1 if one cell is alive on the current GameBoard" in {
      val game: GameBoard = GameBoard(size = 10).get
      game.board(5)(5) = 1
      val actual: Int = game.countAlive()
      val expected = 1
      assert(actual equals expected)
    }
    "return 5 if five cells are alive on the current GameBoard " in {
      val game = GameBoard(size = 10).get
      game.board(5)(0) = 1
      game.board(4)(0) = 1
      game.board(3)(0) = 1
      game.board(2)(0) = 1
      game.board(1)(0) = 1
      val actual = game.countAlive()
    }
  }/*
  "the countNeighbors method" should {
    "return None if the x,y coordinates it receives point to a dead cell" in {

    }
    "given an x value that is out of bounds, raise an error" in {
      val game = GameBoard(10).get
      game.countNeighbors(x = -1, y = 0)
    }
    "given a y value that is out of bounds, raise an error" in {
      val game = GameBoard(10).get
      game.countNeighbors(x = 0, y = -1)
    }
  }*/
}

