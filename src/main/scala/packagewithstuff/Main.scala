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
    //initialize
    val gen1: GameBoard = GameBoard(size = 10).get
    //populate board
    gen1.randomize(bound = .10)
    //print
    gen1.printBoard()
    // initalize
    val evolve: Evolve = Evolve(game = gen1)
    // EVOLVE
    val gen2 = evolve.nextGeneration()
    // print gen 2
    gen2.printBoard()
    // EVOLVE AGAIN
    val gen3 = evolve.nextGeneration()
    // print gen 3
    gen3.printBoard()


  }
}