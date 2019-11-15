package packagewithstuff

import scala.util.Random


object Main {
  def main(args: Array[String]): Unit = {
/*
    val a = GameBoard(size = 10) match {
      case Some(g) => 10
      case None => 3
    }
*/
    val game: GameBoard = GameBoard(size = 10).get
    game.randomize()
    val evolve: Evolve = Evolve(game = game)
  }
}