package aima.core.environment.puzzleN;

import aima.core.search.framework.HeuristicFunction;
import aima.core.util.datastructure.XYLocation;

/**
 * @author Ravi Mohan
 * 
 */
public class ManhattanHeuristicFunction implements HeuristicFunction
{

  public double h( Object state )
  {
    PuzzleNBoard board = ( PuzzleNBoard ) state;
    int n = board.getN();
    int retVal = 0;
    for ( int i = 1; i < n * n; i++ )
    {
      XYLocation loc = board.getLocationOf( i );
      retVal += evaluateManhattanDistanceOf( i, loc, n );
    }
    return retVal;

  }

  public int evaluateManhattanDistanceOf( int i, XYLocation loc, int n )
  {
    int retVal = -1;
    int xpos = loc.getXCoOrdinate();
    int ypos = loc.getYCoOrdinate();
    retVal = Math.abs( xpos - i / n ) + Math.abs( ypos - i % n );
    return retVal;
  }
}