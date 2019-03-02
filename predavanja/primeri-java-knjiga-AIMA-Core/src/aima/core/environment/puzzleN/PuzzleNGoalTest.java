package aima.core.environment.puzzleN;

import aima.core.search.framework.GoalTest;

/**
 * @author Ravi Mohan
 * 
 */
public class PuzzleNGoalTest implements GoalTest
{

  PuzzleNBoard goal;

  public PuzzleNGoalTest( int n )
  {
    int[] goalA = new int[n * n];
    for ( int i = 0; i < n * n; i++ )
      goalA[i] = i;
    goal = new PuzzleNBoard( goalA );
  }

  public boolean isGoalState( Object state )
  {
    PuzzleNBoard board = ( PuzzleNBoard ) state;
    return board.equals( goal );
  }
}