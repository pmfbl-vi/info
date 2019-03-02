package aima.core.environment.vacuum2x2;

import java.util.Random;

import aima.core.agent.Action;
import aima.core.agent.Agent;
import aima.core.agent.EnvironmentState;
import aima.core.agent.Percept;
import aima.core.agent.impl.AbstractEnvironment;
import aima.core.agent.impl.DynamicAction;

public class Vacuum2x2Environment extends AbstractEnvironment
{
  // Allowable Actions within the Vacuum Environment
  public static final Action AKCIJA_IDI_LEVO = new DynamicAction( "Levo" );
  public static final Action AKCIJA_IDI_DESNO = new DynamicAction( "Desno" );
  public static final Action AKCIJA_IDI_GORE = new DynamicAction( "Gore" );
  public static final Action AKCIJA_IDI_DOLE = new DynamicAction( "Dole" );
  public static final Action AKCIJA_USISAVAJ = new DynamicAction( "Usisavaj" );
  public static final String LOKACIJA_A1 = "A1";
  public static final String LOKACIJA_A2 = "A2";
  public static final String LOKACIJA_B1 = "B1";
  public static final String LOKACIJA_B2 = "B2";

  public enum LocationState
  {
    Cisto, Prljavo
  };

  //
  protected Vacuum2x2EnvironmentState envState = null;
  protected boolean isDone = false;

  /**
   * Constructs a vacuum environment with two locations, in which dirt is placed
   * at random.
   */
  public Vacuum2x2Environment()
  {
    Random r = new Random();
    envState = new Vacuum2x2EnvironmentState(
        0 == r.nextInt( 2 ) ? LocationState.Cisto : LocationState.Prljavo,
        0 == r.nextInt( 2 ) ? LocationState.Cisto : LocationState.Prljavo,
        0 == r.nextInt( 2 ) ? LocationState.Cisto : LocationState.Prljavo,
        0 == r.nextInt( 2 ) ? LocationState.Cisto : LocationState.Prljavo );
  }

  /**
   * Constructs a vacuum environment with two locations, in which dirt is placed
   * as specified.
   * 
   * @param locAState
   *          the initial state of location A, which is either <em>Clean</em> or
   *          <em>Dirty</em>.
   * @param locBState
   *          the initial state of location B, which is either <em>Clean</em> or
   *          <em>Dirty</em>.
   * 
   *          A1 A2 B1 B2
   */
  public Vacuum2x2Environment( LocationState locA1State,
      LocationState locA2State, LocationState locB1State,
      LocationState locB2State )
  {
    envState = new Vacuum2x2EnvironmentState( locA1State, locA2State,
        locB1State, locB2State );
  }

  @Override
  public EnvironmentState getCurrentState()
  {
    return envState;
  }

  @Override
  public EnvironmentState executeAction( Agent a, Action agentAction )
  {

    if ( AKCIJA_IDI_DESNO == agentAction )
    {
      if ( envState.getAgentLocation( a ) == LOKACIJA_A1 )
        envState.setAgentLocation( a, LOKACIJA_A2 );
      else if ( envState.getAgentLocation( a ) == LOKACIJA_B1 )
        envState.setAgentLocation( a, LOKACIJA_B2 );
      updatePerformanceMeasure( a, -1 );
    }
    else if ( AKCIJA_IDI_LEVO == agentAction )
    {
      if ( envState.getAgentLocation( a ) == LOKACIJA_A2 )
        envState.setAgentLocation( a, LOKACIJA_A1 );
      else if ( envState.getAgentLocation( a ) == LOKACIJA_B2 )
        envState.setAgentLocation( a, LOKACIJA_B1 );
      updatePerformanceMeasure( a, -1 );
    }
    else if ( AKCIJA_IDI_GORE == agentAction )
    {
      if ( envState.getAgentLocation( a ) == LOKACIJA_B1 )
        envState.setAgentLocation( a, LOKACIJA_A1 );
      else if ( envState.getAgentLocation( a ) == LOKACIJA_B2 )
        envState.setAgentLocation( a, LOKACIJA_A2 );
      updatePerformanceMeasure( a, -1 );
    }
    else if ( AKCIJA_IDI_DOLE == agentAction )
    {
      if ( envState.getAgentLocation( a ) == LOKACIJA_A2 )
        envState.setAgentLocation( a, LOKACIJA_B2 );
      else if ( envState.getAgentLocation( a ) == LOKACIJA_A1 )
        envState.setAgentLocation( a, LOKACIJA_B1 );
      updatePerformanceMeasure( a, -1 );
    }
    else if ( AKCIJA_USISAVAJ == agentAction )
    {
      if ( LocationState.Prljavo == envState.getLocationState( envState
          .getAgentLocation( a ) ) )
      {
        envState.setLocationState( envState.getAgentLocation( a ),
            LocationState.Cisto );
        updatePerformanceMeasure( a, 10 );
      }
    }
    else if ( agentAction.isNoOp() )
    {
      // In the Vacuum Environment we consider things done if
      // the agent generates a NoOp.
      isDone = true;
    }

    return envState;
  }

  @Override
  public Percept getPerceptSeenBy( Agent anAgent )
  {
    if ( anAgent instanceof NondeterministicVacuum2x2Agent )
    {
      // Note: implements FullyObservableVacuumEnvironmentPercept
      return new Vacuum2x2EnvironmentState( this.envState );
    }
    String agentLocation = envState.getAgentLocation( anAgent );
    return new LocalVacuum2x2EnvironmentPercept( agentLocation,
        envState.getLocationState( agentLocation ) );
  }

  @Override
  public boolean isDone()
  {
    return super.isDone() || isDone;
  }

  @Override
  public void addAgent( Agent a )
  {
    int idx = new Random().nextInt( 4 );
    switch ( idx )
    {
    case 0:
      envState.setAgentLocation( a, LOKACIJA_A1 );
      break;
    case 1:
      envState.setAgentLocation( a, LOKACIJA_A2 );
      break;
    case 2:
      envState.setAgentLocation( a, LOKACIJA_B1 );
      break;
    case 3:
      envState.setAgentLocation( a, LOKACIJA_B2 );
      break;
    }
    super.addAgent( a );
  }

  public void addAgent( Agent a, String location )
  {
    // Ensure the agent state information is tracked before
    // adding to super, as super will notify the registered
    // EnvironmentViews that is was added.
    envState.setAgentLocation( a, location );
    super.addAgent( a );
  }

  public LocationState getLocationState( String location )
  {
    return envState.getLocationState( location );
  }

  public String getAgentLocation( Agent a )
  {
    return envState.getAgentLocation( a );
  }
}