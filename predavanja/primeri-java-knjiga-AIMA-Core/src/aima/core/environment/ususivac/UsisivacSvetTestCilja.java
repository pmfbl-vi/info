package aima.core.environment.ususivac;

import aima.core.agent.Agent;
import aima.core.search.framework.GoalTest;

/**
 * Tests for goals states
 * 
 * @author Andrew Brown
 */
public class UsisivacSvetTestCilja implements GoalTest
{

  private Agent agent;

  /**
   * Constructor
   * 
   * @param agent
   */
  public UsisivacSvetTestCilja( Agent agent )
  {
    this.agent = agent;
  }

  /**
   * Tests whether the search has identified a goal state
   * 
   * @param state
   * @return true if the state is a goal state, false otherwise.
   */
  @Override
  public boolean isGoalState( Object state )
  {
    // setup
    UsisivacOkruzenjeStanje vacEnvState = ( UsisivacOkruzenjeStanje ) state;
    // test goal state
    if ( UsisivacOkruzenje.LocationState.Clean != vacEnvState
        .getLocationState( UsisivacOkruzenje.LOKACIJA_A1 ) )
    {
      return false;
    }
    if ( UsisivacOkruzenje.LocationState.Clean != vacEnvState
        .getLocationState( UsisivacOkruzenje.LOKACIJA_A2 ) )
    {
      return false;
    }
    if ( UsisivacOkruzenje.LocationState.Clean != vacEnvState
        .getLocationState( UsisivacOkruzenje.LOKACIJA_B1 ) )
    {
      return false;
    }
    if ( UsisivacOkruzenje.LocationState.Clean != vacEnvState
        .getLocationState( UsisivacOkruzenje.LOKACIJA_B2 ) )
    {
      return false;
    }
    return true;
  }

}