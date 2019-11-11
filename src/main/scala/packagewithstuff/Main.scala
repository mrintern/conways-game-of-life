package packagewithstuff

import scala.util.Random


object Main {
  def main(args: Array[String]): Unit = {
    val game = GameBoard(size = 10).get
    game.board(0)(0) = 1
    game.printBoard()
    print(game.countNeighbors(x=0,y=0))
    game.randomize(bound=.5)
    game.printBoard()
    print(game.countNeighbors(x=0,y=0))
  }
}