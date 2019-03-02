package aima.core.environment.eightpuzzle;

import aima.core.search.framework.HeuristicFunction;
import aima.core.util.datastructure.XYLocation;

/**
 * @author Ravi Mohan
 * 
 */
public class BorderMisplacedTilleHeuristicFunction implements HeuristicFunction
{

  public double h( Object state )
  {
    EightPuzzleBoard board = ( EightPuzzleBoard ) state;
    return getWeightedNumberOfMisplacedTiles( board );
  }

  private int getWeightedNumberOfMisplacedTiles( EightPuzzleBoard board )
  {
    int ret = 0;
    boolean firstRowIsOK = false;
    if ( board.getLocationOf( 8 ).equals( new XYLocation( 2, 2 ) )
        && board.getLocationOf( 7 ).equals( new XYLocation( 2, 1 ) )
        && board.getLocationOf( 6 ).equals( new XYLocation( 2, 0 ) ) )
      firstRowIsOK = true;
    boolean firstColumnIsOK = false;
    if ( board.getLocationOf( 2 ).equals( new XYLocation( 0, 2 ) )
        && board.getLocationOf( 5 ).equals( new XYLocation( 1, 2 ) )
        && board.getLocationOf( 8 ).equals( new XYLocation( 2, 2 ) ) )
      firstColumnIsOK = true;
    if ( !( board.getLocationOf( 0 ).equals( new XYLocation( 0, 0 ) ) ) )
    {
      ret += 1;
    }
    if ( !( board.getLocationOf( 1 ).equals( new XYLocation( 0, 1 ) ) ) )
    {
      ret += 1;
    }
    if ( !( board.getLocationOf( 2 ).equals( new XYLocation( 0, 2 ) ) ) )
    {
      ret += 1;
    }
    if ( !( board.getLocationOf( 3 ).equals( new XYLocation( 1, 0 ) ) ) )
    {
      ret += 1;
    }
    if ( !( board.getLocationOf( 4 ).equals( new XYLocation( 1, 1 ) ) ) )
    {
      ret += 1;
    }
    if ( !( board.getLocationOf( 5 ).equals( new XYLocation( 1, 2 ) ) ) )
    {
      ret += 1;
    }
    if ( !( board.getLocationOf( 6 ).equals( new XYLocation( 2, 0 ) ) ) )
    {
      ret += 1;
    }
    if ( !( board.getLocationOf( 7 ).equals( new XYLocation( 2, 1 ) ) ) )
    {
      ret += 1;
    }
    if ( !( board.getLocationOf( 8 ).equals( new XYLocation( 2, 2 ) ) ) )
    {
      ret += 1;
    }
    // Subtract the gap position from the # of misplaced tiles
    // as its not actually a tile (see issue 73).
    if ( ret > 0 )
    {
      ret--;
    }
    return ret;
  }
}