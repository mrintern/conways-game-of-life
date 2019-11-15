package packagewithstuff

import org.scalatest.{Matchers, WordSpec}
class EvolveSpec() extends WordSpec with Matchers{

  "the survival method" should{
    "return 0 if the living cell at the x,y coordinates has LESS than 2 neighbors" in {
      val game: GameBoard =  GameBoard(10).get
      val (x,y) = (5,5)
      game.board(x)(y) = 1 // cell
      val evolve: Evolve = Evolve(game = game)
      val expected: Int = 0
      assert(evolve.survival(x = x, y = y) == expected)

    }
    "return 0 if the living cell at the x,y coordinates has MORE than 3 neighbors" in {
      val game: GameBoard =  GameBoard(10).get
      val (x,y) = (5,5)
      game.board(x)(y) = 1 // cell
      game.board(x+1)(y) = 1 // neighbor
      game.board(x-1)(y) = 1 // neighbor
      game.board(x)(y+1) = 1 // neighbor
      game.board(x)(y-1) = 1 // neighbor
      val evolve: Evolve = Evolve(game = game)
      val expected: Int = 0
      assert(evolve.survival(x = x, y = y) == expected)
    }
    "return 1 if the living cell at the x,y coordinates has EXACTLY 2 or 3 neighbors" in {
      val game: GameBoard =  GameBoard(10).get
      val (x,y) = (5,5)
      game.board(x)(y) = 1 // cell
      game.board(x+1)(y) = 1 // neighbor
      game.board(x-1)(y) = 1 // neighbor
      val evolve: Evolve = Evolve(game = game)
      val expected: Int = 1
      assert(evolve.survival(x = x, y = y) == expected)
    }

    "return 0 if the dead cell at the x,y coordinates has LESS than 3 neighbors" in {
      val game: GameBoard =  GameBoard(10).get
      val (x,y) = (5,5)
      game.board(x)(y) = 0 // cell
      val evolve: Evolve = Evolve(game = game)
      val expected: Int = 0
      assert(evolve.survival(x = x, y = y) == expected)

    }
    "return 0 if the dead cell at the x,y coordinates has MORE than 3 neighbors" in {
      val game: GameBoard =  GameBoard(10).get
      val (x,y) = (5,5)
      game.board(x)(y) = 0 // cell
      game.board(x+1)(y) = 1 // neighbor
      game.board(x-1)(y) = 1 // neighbor
      game.board(x)(y+1) = 1 // neighbor
      game.board(x)(y-1) = 1 // neighbor
      val evolve: Evolve = Evolve(game = game)
      val expected: Int = 0
      assert(evolve.survival(x = x, y = y) == expected)

    }
    "return 1 if the dead cell at the x,y coordinates has EXACTLY 3 neighbors" in {
      val game: GameBoard =  GameBoard(10).get
      val (x,y) = (5,5)
      game.board(x)(y) = 0 // cell
      game.board(x+1)(y) = 1 // neighbor
      game.board(x-1)(y) = 1 // neighbor
      game.board(x)(y+1) = 1 // neighbor
      val evolve: Evolve = Evolve(game = game)
      val expected: Int = 1
      assert(evolve.survival(x = x, y = y) == expected)
    }
  }



}

