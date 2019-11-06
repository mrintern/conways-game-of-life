package packagewithstuff

import scala.util.Random


object Main {
  def main(args: Array[String]): Unit = {
    println("Hello, World!")

    val board = new GameBoard(30,30)
    println("Executing print board")

    board.randomize(.05)
    board.printBoard()







  }
}