package aima.core.environment.vacuum2x2;

import aima.core.agent.Action;
import aima.core.agent.Agent;
import aima.core.agent.EnvironmentState;

/**
 * Create the erratic vacuum world from page 134, AIMA3e. In the erratic vacuum
 * world, the Suck action works as follows: 1) when applied to a dirty square
 * the action cleans the square and sometimes cleans up dirt in an adjacent
 * square too; 2) when applied to a clean square the action sometimes deposits
 * dirt on the carpet.
 * 
 * @author Andrew Brown
 */
public class NondeterministicVacuum2x2Environment extends Vacuum2x2Environment
{

  /**
   * Construct a vacuum environment with two locations, in which dirt is placed
   * at random.
   */
  public NondeterministicVacuum2x2Environment()
  {
    super();
  }

  /**
   * Construct a vacuum environment with two locations, in which dirt is placed
   * as specified.
   * 
   * @param locAState
   *          the initial state of location A, which is either <em>Clean</em> or
   *          <em>Dirty</em>.
   * @param locBState
   *          the initial state of location B, which is either <em>Clean</em> or
   *          <em>Dirty</em>.
   */
  public NondeterministicVacuum2x2Environment( LocationState locA1State,
      LocationState locA2State, LocationState locB1State,
      LocationState locB2State )
  {
    super( locA1State, locA2State, locB1State, locB2State );
  }

  /**
   * Execute the agent action
   * 
   * @param a
   * @param agentAction
   * @return the environment state after the action is executed.
   */
  @Override
  public EnvironmentState executeAction( Agent a, Action agentAction )
  {
    if ( AKCIJA_IDI_DESNO == agentAction )
    {
      if ( envState.getAgentLocation( a ).equals( LOKACIJA_A1 ) )
        envState.setAgentLocation( a, LOKACIJA_A2 );
      else if ( envState.getAgentLocation( a ).equals( LOKACIJA_B1 ) )
        envState.setAgentLocation( a, LOKACIJA_B2 );
      updatePerformanceMeasure( a, -1 );
    } else if ( AKCIJA_IDI_LEVO == agentAction )
    {
      if ( envState.getAgentLocation( a ).equals( LOKACIJA_A2 ) )
        envState.setAgentLocation( a, LOKACIJA_A1 );
      else if ( envState.getAgentLocation( a ).equals( LOKACIJA_B2 ) )
        envState.setAgentLocation( a, LOKACIJA_B1 );
      updatePerformanceMeasure( a, -1 );
    } else if ( AKCIJA_IDI_GORE == agentAction )
    {
      if ( envState.getAgentLocation( a ).equals( LOKACIJA_B2 ) )
        envState.setAgentLocation( a, LOKACIJA_A2 );
      else if ( envState.getAgentLocation( a ).equals( LOKACIJA_B1 ) )
        envState.setAgentLocation( a, LOKACIJA_A1 );
      updatePerformanceMeasure( a, -1 );
    } else if ( AKCIJA_IDI_DOLE == agentAction )
    {
      if ( envState.getAgentLocation( a ).equals( LOKACIJA_A2 ) )
        envState.setAgentLocation( a, LOKACIJA_B1 );
      else if ( envState.getAgentLocation( a ).equals( LOKACIJA_A1 ) )
        envState.setAgentLocation( a, LOKACIJA_B1 );
      updatePerformanceMeasure( a, -1 );
    } else if ( AKCIJA_USISAVAJ == agentAction )
    {
      // case: square is dirty
      if ( Vacuum2x2Environment.LocationState.Prljavo == envState
          .getLocationState( envState.getAgentLocation( a ) ) )
      {
        String current_location = envState.getAgentLocation( a );
        String adjacent_location = ( current_location.equals( "A" ) ) ? "B"
            : "A";
        // always clean current square
        envState.setLocationState( current_location,
            Vacuum2x2Environment.LocationState.Cisto );
        // possibly clean adjacent square
        if ( Math.random() > 0.5 )
        {
          envState.setLocationState( adjacent_location,
              Vacuum2x2Environment.LocationState.Cisto );
        }
      } // case: square is clean
      else if ( Vacuum2x2Environment.LocationState.Cisto == envState
          .getLocationState( envState.getAgentLocation( a ) ) )
      {
        // possibly dirty current square
        if ( Math.random() > 0.5 )
        {
          envState.setLocationState( envState.getAgentLocation( a ),
              Vacuum2x2Environment.LocationState.Prljavo );
        }
      }
    } else if ( agentAction.isNoOp() )
    {
      isDone = true;
    }
    return envState;
  }
}
