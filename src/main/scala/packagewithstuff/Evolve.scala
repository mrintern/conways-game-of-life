package packagewithstuff

case class Evolve(game :GameBoard){
//TODO figure out this error. is there something wrong with the return statements?
  /**
   * given the coordinates of a single cell, determine the fate of the cell based on the rules of the game.
   * returning 1 means the cell is "alive"
   * returning 0 means the cell is "dead"
   *
   */
  def survival(x: Int,y: Int): Int={
    //count neighbors
    //check rules
    //return 1 or 0
    val cell: Int = game.board(x)(y)
    val neighbors: Option[Int] = game.countNeighbors(x = x,y = y)
    // cell is alive
    if(cell == 1)
      //less than 2 neighbors
      if(neighbors.get < 2 || neighbors.get > 3) 0 else if(neighbors.get == 2 || neighbors.get == 3) 1
    // cell is dead
    else if(cell == 0)
      if(neighbors.get == 3) 1 else 0
  }
