package packagewithstuff

object Main {
  def main(args: Array[String]): Unit = {

//      val x: Array[Int] = Array(0,0,5,6,8,67,4,5,5,6)
//      val y: Array[Int] = Array(1,2,3,4,5,6,7,8,9)
//      val dbl = (x: Int) => x * x
//      def logic(x: Int): Int = {
//          x match{
//              case a if x == 0 => 999 // return 999
//              case b if x == 6 => 1001
//              case _ => x // return x
//          }
//      }
//
//
//      x.map(dbl)
//      val sick = x.map(logic)
//      sick.foreach(println)


      def five_generations(gen1: GameBoard): Unit ={
          gen1.printBoard()

          val evolve: Evolve = Evolve(game = gen1)
          val gen2 = evolve.nextGeneration()
          gen2.printBoard()

          val evolve2: Evolve = Evolve(game = gen2)
          val gen3 = evolve2.nextGeneration()
          gen3.printBoard()

          val evolve3: Evolve = Evolve(game = gen3)
          val gen4 = evolve3.nextGeneration()
          gen4.printBoard()

          val evolve4: Evolve = Evolve(game = gen4)
          val gen5 = evolve4.nextGeneration()
          gen5.printBoard()
      }
      val gen1: GameBoard = GameBoard(size = 20).get
      // space ship formation
      gen1.board(4)(4) = 1
      gen1.board(4)(5) = 1
      gen1.board(4)(6) = 1
      gen1.board(2)(5) = 1
      gen1.board(3)(6) = 1

      five_generations(gen1)

//      gen1.printBoard()
//
//      val evolve: Evolve = Evolve(game = gen1)
//      val gen2 = evolve.nextGeneration()
//      gen2.printBoard()
//
//      val evolve2: Evolve = Evolve(game = gen2)
//      val gen3 = evolve2.nextGeneration()
//      gen3.printBoard()
//
//      val evolve3: Evolve = Evolve(game = gen3)
//      val gen4 = evolve3.nextGeneration()
//      gen4.printBoard()
//
//      val evolve4: Evolve = Evolve(game = gen4)
//      val gen5 = evolve4.nextGeneration()
//      gen5.printBoard()

  }
}