package aima.core.environment.vacuum2x2;

import aima.core.agent.Agent;
import aima.core.agent.EnvironmentState;
import java.util.LinkedHashMap;
import java.util.Map;

public class Vacuum2x2EnvironmentState implements EnvironmentState,
    FullyObservableVacuum2x2EnvironmentPercept
{

  private Map<String, Vacuum2x2Environment.LocationState> state;
  private Map<Agent, String> agentLocations;

  /**
   * Constructor
   */
  public Vacuum2x2EnvironmentState()
  {
    state = new LinkedHashMap<String, Vacuum2x2Environment.LocationState>();
    agentLocations = new LinkedHashMap<Agent, String>();
  }

  /**
   * Constructor
   * 
   * @param locAState
   * @param locBState
   */
  public Vacuum2x2EnvironmentState(
      Vacuum2x2Environment.LocationState locA1State,
      Vacuum2x2Environment.LocationState locA2State,
      Vacuum2x2Environment.LocationState locB1State,
      Vacuum2x2Environment.LocationState locB2State )
  {
    this();
    state.put( Vacuum2x2Environment.LOKACIJA_A1, locA1State );
    state.put( Vacuum2x2Environment.LOKACIJA_A2, locA2State );
    state.put( Vacuum2x2Environment.LOKACIJA_B1, locB1State );
    state.put( Vacuum2x2Environment.LOKACIJA_B2, locB2State );
  }

  /**
   * Copy Constructor.
   * 
   * @param toCopyState
   *          Vacuum Environment State to copy.
   */
  public Vacuum2x2EnvironmentState( Vacuum2x2EnvironmentState toCopyState )
  {
    this();
    this.state.putAll( toCopyState.state );
    this.agentLocations.putAll( toCopyState.agentLocations );
  }

  @Override
  public String getAgentLocation( Agent a )
  {
    return agentLocations.get( a );
  }

  /**
   * Sets the agent location
   * 
   * @param a
   * @param location
   */
  public void setAgentLocation( Agent a, String location )
  {
    agentLocations.put( a, location );
  }

  @Override
  public Vacuum2x2Environment.LocationState getLocationState( String location )
  {
    return state.get( location );
  }

  /**
   * Sets the location state
   * 
   * @param location
   * @param s
   */
  public void setLocationState( String location,
      Vacuum2x2Environment.LocationState s )
  {
    state.put( location, s );
  }

  @Override
  public boolean equals( Object o )
  {
    if ( o instanceof Vacuum2x2EnvironmentState )
    {
      Vacuum2x2EnvironmentState s = ( Vacuum2x2EnvironmentState ) o;
      if ( this.state.equals( s.state )
          && this.agentLocations.equals( s.agentLocations ) )
      {
        return true;
      }
    }
    return false;
  }

  /**
   * Override hashCode()
   * 
   * @return the hash code for this object.
   */
  @Override
  public int hashCode()
  {
    int hash = 7;
    hash = 13 * hash + ( this.state != null ? this.state.hashCode() : 0 );
    hash = 53 * hash
        + ( this.agentLocations != null ? this.agentLocations.hashCode() : 0 );
    return hash;
  }

  /**
   * Returns a string representation of the environment
   * 
   * @return a string representation of the environment
   */
  @Override
  public String toString()
  {
    return this.state.toString();
  }
}