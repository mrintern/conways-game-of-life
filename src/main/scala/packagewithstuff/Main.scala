package packagewithstuff

object Main {
  def main(args: Array[String]): Unit = {

      /**
       *  Recursively run the game, stopping when the limit is reached.
       *
       *  @param num: the GameBoard object. Should be populated with living cells prior to running this function
       *  @param limit: the number of generations you'd like to print
       */
      def Run(generation: GameBoard, num: Int = 0, limit: Int ): Unit ={
          println("===========================================================")
          println(s"                      GENERATION ${num}                         ")
          print("===========================================================")
          generation.printBoard()
          println()
          val evolve: Evolve = Evolve(game = generation)
          val generation2 = evolve.nextGeneration()
          num match {
              case a if (num < limit) => Run(generation = generation2, num = (num+1), limit = limit )
              case b if (num == limit) => // exit condition
              case _ =>
          }
      }
      val gen1: GameBoard = GameBoard(size = 20).get
      // GLIDER formation
      // a popular formation in Conway's Game of life being used here to verify that the game is working properly.
      gen1.board(4)(4) = 1
      gen1.board(4)(5) = 1
      gen1.board(4)(6) = 1
      gen1.board(2)(5) = 1
      gen1.board(3)(6) = 1

      Run(generation = gen1, limit = 60)

  }
}