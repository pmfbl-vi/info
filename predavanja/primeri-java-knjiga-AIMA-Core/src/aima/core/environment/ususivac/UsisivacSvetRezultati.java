package aima.core.environment.ususivac;

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
public class UsisivacSvetRezultati implements ResultsFunction
{

  private Agent agent;

  /**
   * Constructor
   * 
   * @param agent
   */
  public UsisivacSvetRezultati( Agent agent )
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
    UsisivacOkruzenjeStanje vacEnvState = ( UsisivacOkruzenjeStanje ) state;
    // Ensure order is consistent across platforms.
    Set<Object> results = new LinkedHashSet<Object>();
    String currentLocation = vacEnvState.getAgentLocation( agent );
    // case: move right
    if ( UsisivacOkruzenje.AKCIJA_IDI_DESNO == action )
    {
      String adjacentLocation = currentLocation;
      if( currentLocation.equals(UsisivacOkruzenje.LOKACIJA_A1))
        adjacentLocation = UsisivacOkruzenje.LOKACIJA_A2;
      else if( currentLocation.equals(UsisivacOkruzenje.LOKACIJA_B1))
      adjacentLocation = UsisivacOkruzenje.LOKACIJA_B2;
      UsisivacOkruzenjeStanje s = new UsisivacOkruzenjeStanje();
      s.setLocationState( currentLocation,
          vacEnvState.getLocationState( currentLocation ) );
      s.setLocationState( adjacentLocation,
          vacEnvState.getLocationState( adjacentLocation ) );
      s.setAgentLocation( this.agent, adjacentLocation );
      results.add( s );
    } 
    // case: move left
    if ( UsisivacOkruzenje.AKCIJA_IDI_LEVO == action )
    {
      String adjacentLocation = currentLocation;
      if( currentLocation.equals(UsisivacOkruzenje.LOKACIJA_A2))
        adjacentLocation = UsisivacOkruzenje.LOKACIJA_A1;
      else if( currentLocation.equals(UsisivacOkruzenje.LOKACIJA_B2))
      adjacentLocation = UsisivacOkruzenje.LOKACIJA_B1;
      UsisivacOkruzenjeStanje s = new UsisivacOkruzenjeStanje();
      s.setLocationState( currentLocation,
          vacEnvState.getLocationState( currentLocation ) );
      s.setLocationState( adjacentLocation,
          vacEnvState.getLocationState( adjacentLocation ) );
      s.setAgentLocation( this.agent, adjacentLocation );
      results.add( s );
    } 
    if ( UsisivacOkruzenje.AKCIJA_IDI_GORE == action )
    {
      String adjacentLocation = currentLocation;
      if( currentLocation.equals(UsisivacOkruzenje.LOKACIJA_B1))
        adjacentLocation = UsisivacOkruzenje.LOKACIJA_A1;
      else if( currentLocation.equals(UsisivacOkruzenje.LOKACIJA_B2))
      adjacentLocation = UsisivacOkruzenje.LOKACIJA_A2;
      UsisivacOkruzenjeStanje s = new UsisivacOkruzenjeStanje();
      s.setLocationState( currentLocation,
          vacEnvState.getLocationState( currentLocation ) );
      s.setLocationState( adjacentLocation,
          vacEnvState.getLocationState( adjacentLocation ) );
      s.setAgentLocation( this.agent, adjacentLocation );
      results.add( s );
    } 
    if ( UsisivacOkruzenje.AKCIJA_IDI_DOLE == action )
    {
      String adjacentLocation = currentLocation;
      if( currentLocation.equals(UsisivacOkruzenje.LOKACIJA_A1))
        adjacentLocation = UsisivacOkruzenje.LOKACIJA_B1;
      else if( currentLocation.equals(UsisivacOkruzenje.LOKACIJA_A2))
      adjacentLocation = UsisivacOkruzenje.LOKACIJA_B2;
      UsisivacOkruzenjeStanje s = new UsisivacOkruzenjeStanje();
      s.setLocationState( currentLocation,
          vacEnvState.getLocationState( currentLocation ) );
      s.setLocationState( adjacentLocation,
          vacEnvState.getLocationState( adjacentLocation ) );
      s.setAgentLocation( this.agent, adjacentLocation );
      results.add( s );
    } 
    else if ( UsisivacOkruzenje.AKCIJA_USISAVANJE == action )
    {
      // case: square is dirty
      if ( UsisivacOkruzenje.LocationState.Dirty == vacEnvState
          .getLocationState( vacEnvState.getAgentLocation( this.agent ) ) )
      {
        // always clean current
        UsisivacOkruzenjeStanje s1 = new UsisivacOkruzenjeStanje();
        s1.setLocationState( currentLocation,
            UsisivacOkruzenje.LocationState.Clean );
      } // case: square is clean
      else
      {
      }
    }
    else if ( action.isNoOp() )
    {
      // do nothing
    }
    return results;
  }
}
