package packagewithstuff

import scala.util.Random


object Main {
  def main(args: Array[String]): Unit = {

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