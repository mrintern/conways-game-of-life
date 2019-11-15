package packagewithstuff

import scala.util.Random


object Main {
  def main(args: Array[String]): Unit = {
/*
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
     */

      val gen1: GameBoard = GameBoard(size = 20).get
      // space ship formation
      gen1.board(4)(4) = 1
      gen1.board(4)(5) = 1
      gen1.board(4)(6) = 1

      gen1.board(2)(5) = 1
      gen1.board(3)(6) = 1

      gen1.randomize(bound = .15)

      val evolve: Evolve = Evolve(game = gen1)
      gen1.printBoard()
      val gen2 = evolve.nextGeneration
      gen2.printBoard()
      val gen3 = evolve.nextGeneration()
      gen3.printBoard()
      val gen4 = evolve.nextGeneration()
      gen4.printBoard()
      val gen5 = evolve.nextGeneration()
      gen5.printBoard()
  }
}