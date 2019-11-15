package packagewithstuff

case class Evolve(game :GameBoard){
  /**
   * given the coordinates of a single cell, determine whether the cell will be alive or dead based on the rules of the game.
   * returning 1 means the cell is "alive"
   * returning 0 means the cell is "dead"
   */
  def survival(x: Int,y: Int): Int={
    val cell: Int = game.board(x)(y)
    val neighbors: Option[Int] = game.countNeighbors(x = x,y = y)
    // if cell is alive, follow these rules
    if(cell == 1)
      if(neighbors.get < 2 || neighbors.get > 3) 0 else if(neighbors.get == 2 || neighbors.get == 3) 1
    // if cell is dead, follow these rules
    else if(cell == 0)
      if(neighbors.get == 3) 1 else 0

    //if the method reaches this far without returning a value, print error. Return 400
    println(s"ERROR Cell at coordinates (${x},${y}) = ${cell}. Expected 0 or 1")
    400
  }
}
