package aima.core.environment.vacuum2x2;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.agent.Agent;
import aima.core.search.nondeterministic.ResultsFunction;

/**
 * Returns possible results
 * 
 * @author Andrew Brown
 */
public class Vacuum2x2WorldResults implements ResultsFunction
{

  private Agent agent;

  /**
   * Constructor
   * 
   * @param agent
   */
  public Vacuum2x2WorldResults( Agent agent )
  {
    this.agent = agent;
  }

  /**
   * Returns a list of possible results for a given state and action
   * 
   * @param state
   * @param action
   * @return a list of possible results for a given state and action.
   */
  @Override
  public Set<Object> results( Object state, Action action )
  {
    // setup
    Vacuum2x2EnvironmentState vacEnvState = ( Vacuum2x2EnvironmentState ) state;
    // Ensure order is consistent across platforms.
    Set<Object> results = new LinkedHashSet<Object>();
    String currentLocation = vacEnvState.getAgentLocation( agent );
    // case: move right
    if ( Vacuum2x2Environment.AKCIJA_IDI_DESNO == action )
    {
      String adjacentLocation = currentLocation;
      if ( currentLocation.equals( Vacuum2x2Environment.LOKACIJA_A1 ) )
        adjacentLocation = Vacuum2x2Environment.LOKACIJA_A2;
      if ( currentLocation.equals( Vacuum2x2Environment.LOKACIJA_B1 ) )
        adjacentLocation = Vacuum2x2Environment.LOKACIJA_B2;
      Vacuum2x2EnvironmentState s = new Vacuum2x2EnvironmentState();
      s.setLocationState( currentLocation,
          vacEnvState.getLocationState( currentLocation ) );
      s.setLocationState( adjacentLocation,
          vacEnvState.getLocationState( adjacentLocation ) );
      s.setAgentLocation( this.agent, adjacentLocation );
      results.add( s );
    } // case: move left
    else if ( Vacuum2x2Environment.AKCIJA_IDI_LEVO == action )
    {
      String adjacentLocation = currentLocation;
      if ( currentLocation.equals( Vacuum2x2Environment.LOKACIJA_A2 ) )
        adjacentLocation = Vacuum2x2Environment.LOKACIJA_A1;
      if ( currentLocation.equals( Vacuum2x2Environment.LOKACIJA_B2 ) )
        adjacentLocation = Vacuum2x2Environment.LOKACIJA_B1;
      Vacuum2x2EnvironmentState s = new Vacuum2x2EnvironmentState();
      s.setLocationState( currentLocation,
          vacEnvState.getLocationState( currentLocation ) );
      s.setLocationState( adjacentLocation,
          vacEnvState.getLocationState( adjacentLocation ) );
      s.setAgentLocation( this.agent, adjacentLocation );
      results.add( s );
    } else if ( Vacuum2x2Environment.AKCIJA_IDI_DOLE == action )
    {
      String adjacentLocation = currentLocation;
      if ( currentLocation.equals( Vacuum2x2Environment.LOKACIJA_A2 ) )
        adjacentLocation = Vacuum2x2Environment.LOKACIJA_B2;
      if ( currentLocation.equals( Vacuum2x2Environment.LOKACIJA_A1 ) )
        adjacentLocation = Vacuum2x2Environment.LOKACIJA_B1;
      Vacuum2x2EnvironmentState s = new Vacuum2x2EnvironmentState();
      s.setLocationState( currentLocation,
          vacEnvState.getLocationState( currentLocation ) );
      s.setLocationState( adjacentLocation,
          vacEnvState.getLocationState( adjacentLocation ) );
      s.setAgentLocation( this.agent, adjacentLocation );
      results.add( s );
    } else if ( Vacuum2x2Environment.AKCIJA_IDI_GORE == action )
    {
      String adjacentLocation = currentLocation;
      if ( currentLocation.equals( Vacuum2x2Environment.LOKACIJA_B1 ) )
        adjacentLocation = Vacuum2x2Environment.LOKACIJA_A1;
      if ( currentLocation.equals( Vacuum2x2Environment.LOKACIJA_B2 ) )
        adjacentLocation = Vacuum2x2Environment.LOKACIJA_A2;
      Vacuum2x2EnvironmentState s = new Vacuum2x2EnvironmentState();
      s.setLocationState( currentLocation,
          vacEnvState.getLocationState( currentLocation ) );
      s.setLocationState( adjacentLocation,
          vacEnvState.getLocationState( adjacentLocation ) );
      s.setAgentLocation( this.agent, adjacentLocation );
      results.add( s );
    }
    // case: suck
    else if ( Vacuum2x2Environment.AKCIJA_USISAVAJ == action )
    {
      // case: square is dirty
      if ( Vacuum2x2Environment.LocationState.Prljavo == vacEnvState
          .getLocationState( vacEnvState.getAgentLocation( this.agent ) ) )
      {
        // always clean current
        Vacuum2x2EnvironmentState s1 = new Vacuum2x2EnvironmentState();
        s1.setLocationState( currentLocation,
            Vacuum2x2Environment.LocationState.Cisto );
        s1.setAgentLocation( this.agent, currentLocation );
        results.add( s1 );
      } // case: square is clean
      else
      {
        // sometimes do nothing
        Vacuum2x2EnvironmentState s1 = new Vacuum2x2EnvironmentState();
        s1.setLocationState( currentLocation,
            vacEnvState.getLocationState( currentLocation ) );
        s1.setAgentLocation( this.agent, currentLocation );
        results.add( s1 );
      }
    } else if ( action.isNoOp() )
    {
      // do nothing
    }
    return results;
  }
}
