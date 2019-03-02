package aima.core.environment.vacuum2x2;

import aima.core.agent.Agent;
import aima.core.search.framework.GoalTest;

/**
 * Tests for goals states
 * 
 * @author Andrew Brown
 */
public class Vacuum2x2WorldGoalTest implements GoalTest
{

  private Agent agent;

  /**
   * Constructor
   * 
   * @param agent
   */
  public Vacuum2x2WorldGoalTest( Agent agent )
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
    Vacuum2x2EnvironmentState vacEnvState = ( Vacuum2x2EnvironmentState ) state;
    String currentLocation = vacEnvState.getAgentLocation( this.agent );
    if ( Vacuum2x2Environment.LocationState.Cisto != vacEnvState
        .getLocationState( Vacuum2x2Environment.LOKACIJA_A1 ) )
      return false;
    if ( Vacuum2x2Environment.LocationState.Cisto != vacEnvState
        .getLocationState( Vacuum2x2Environment.LOKACIJA_A2 ) )
      return false;
    if ( Vacuum2x2Environment.LocationState.Cisto != vacEnvState
        .getLocationState( Vacuum2x2Environment.LOKACIJA_B1 ) )
      return false;
    if ( Vacuum2x2Environment.LocationState.Cisto != vacEnvState
        .getLocationState( Vacuum2x2Environment.LOKACIJA_B2 ) )
      return false;
    return true;
  }
}