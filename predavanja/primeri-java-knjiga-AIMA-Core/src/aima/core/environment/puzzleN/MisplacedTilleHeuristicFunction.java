package aima.core.environment.puzzleN;

import aima.core.search.framework.HeuristicFunction;
import aima.core.util.datastructure.XYLocation;

/**
 * @author Ravi Mohan
 * 
 */
public class MisplacedTilleHeuristicFunction implements HeuristicFunction
{

  public double h( Object state )
  {
    PuzzleNBoard board = ( PuzzleNBoard ) state;
    return getNumberOfMisplacedTiles( board );
  }

  private int getNumberOfMisplacedTiles( PuzzleNBoard board )
  {
    int numberOfMisplacedTiles = 0;
    int n = board.getN();
    for ( int i = 0; i < n; i++ )
      for ( int j = 0; j < n; j++ )
      {
        if ( !( board.getLocationOf( i * n + j )
            .equals( new XYLocation( i, j ) ) ) )
          numberOfMisplacedTiles++;
      }
    // Subtract the gap position from the # of misplaced tiles
    // as its not actually a tile (see issue 73).
    if ( numberOfMisplacedTiles > 0 )
    {
      numberOfMisplacedTiles--;
    }
    return numberOfMisplacedTiles;
  }
}