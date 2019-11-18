package packagewithstuff

case class Evolve(game :GameBoard){
  /**
   *  Given the coordinates of a single cell, determine whether the cell will be alive or dead in the next generation based on the rules of the game.
   *  Then, return 1 (for a living cell) or 0 (for a dead cell)
   *  @param x: Int, the x coordinate of a single cell on the GameBoard
   *  @param y: Int, the y coordinate of a single cell on the GameBoard
   *  @return 1 or 0
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

  /**
   *  Iterate over the GameBoard given as input to the Evolve constructor and use the survival() method to
   *  determine whether each cell will be 1 (alive) or 0 (dead) in the next generation.
   *  @return GameBoard object
   */
 def nextGeneration(): GameBoard = {
   val size: Int = game.board.length
   val newGame: GameBoard = GameBoard(size = size).get
   for (i <- 0 until size)
     for (j <- 0 until size)
       newGame.board(i)(j) = survival(x = i, y = j)

   newGame
 }
}
