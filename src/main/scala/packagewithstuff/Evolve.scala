package packagewithstuff

case class Evolve(game :GameBoard){
  /**
   * given the coordinates of a single cell, determine whether the cell will be alive or dead in the next generation based on the rules of the game.
   * then, return either 1 or 0
   *  returning 1 means the cell is "alive"
   * returning 0 means the cell is "dead"
   */
  def survival(x: Int,y: Int): Int= {

    val cell: Int = game.board(x)(y)
    val neighbors: Option[Int] = game.countNeighbors(x = x,y = y)

    (cell, neighbors ) match {
      case a if (cell == 1 && neighbors.get < 2) => 0
      case b if (cell == 1 && neighbors.get > 3) => 0
      case d if (cell == 1 && neighbors.get == 2) => 1
      case e if (cell == 1 && neighbors.get == 3) => 1
      case f if (cell == 0 && neighbors.get < 3) => 0
      case g if (cell == 0 && neighbors.get > 3) => 0
      case h if (cell == 0 && neighbors.get == 3) => 1
      case _ => 8008135
    }
  }
 def nextGeneration(): GameBoard = {
   val size: Int = game.board.length
   val newGame: GameBoard = GameBoard(size = size).get
   for (i <- 0 until size)
     for (j <- 0 until size) {
       newGame.board(i)(j) = survival(x = i, y = j)
     }
   newGame
 }
}
