package aima.core.environment.ususivac;

import java.util.Random;

import aima.core.agent.Action;
import aima.core.agent.Agent;
import aima.core.agent.EnvironmentState;
import aima.core.agent.Percept;
import aima.core.agent.impl.AbstractEnvironment;
import aima.core.agent.impl.DynamicAction;

/**
 * Artificial Intelligence A Modern Approach (3rd Edition): pg 58.<br>
 * <br>
 * Let the world contain just two locations. Each location may or may not
 * contain dirt, and the agent may be in one location or the other. There are 8
 * possible world states, as shown in Figure 3.2. The agent has three possible
 * actions in this version of the vacuum world: <em>Left</em>, <em>Right</em>,
 * and <em>Suck</em>. Assume for the moment, that sucking is 100% effective. The
 * goal is to clean up all the dirt.
 * 
 * @author Ravi Mohan
 * @author Ciaran O'Reilly
 * @author Mike Stampone
 */
public class UsisivacOkruzenje extends AbstractEnvironment
{
  // Allowable Actions within the Vacuum Environment
  public static final Action AKCIJA_IDI_LEVO = new DynamicAction( "Levo" );
  public static final Action AKCIJA_IDI_DESNO = new DynamicAction( "Desno" );
  public static final Action AKCIJA_IDI_GORE = new DynamicAction( "Gore" );
  public static final Action AKCIJA_IDI_DOLE = new DynamicAction( "Dole" );
  public static final Action AKCIJA_USISAVANJE = new DynamicAction(
      "Usisavanje" );
  public static final String LOKACIJA_A1 = "A1";
  public static final String LOKACIJA_A2 = "A2";
  public static final String LOKACIJA_B1 = "B1";
  public static final String LOKACIJA_B2 = "B2";

  public enum LocationState
  {
    Clean, Dirty
  };

  //
  protected UsisivacOkruzenjeStanje envState = null;
  protected boolean isDone = false;

  /**
   * Constructs a vacuum environment with two locations, in which dirt is placed
   * at random.
   */
  public UsisivacOkruzenje()
  {
    Random r = new Random();
    envState = new UsisivacOkruzenjeStanje(
        0 == r.nextInt( 2 ) ? LocationState.Clean : LocationState.Dirty,
        0 == r.nextInt( 2 ) ? LocationState.Clean : LocationState.Dirty,
        0 == r.nextInt( 2 ) ? LocationState.Clean : LocationState.Dirty,
        0 == r.nextInt( 2 ) ? LocationState.Clean : LocationState.Dirty );
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
   */
  public UsisivacOkruzenje( UsisivacOkruzenje.LocationState locA1State,
      UsisivacOkruzenje.LocationState locA2State,
      UsisivacOkruzenje.LocationState locB1State,
      UsisivacOkruzenje.LocationState locB2State )
  {
    envState = new UsisivacOkruzenjeStanje( locA1State, locA2State, locB1State,
        locB2State );
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
      if ( envState.getAgentLocation( a ) == LOKACIJA_B1 )
        envState.setAgentLocation( a, LOKACIJA_B2 );
      updatePerformanceMeasure( a, -1 );
    }
    else if ( AKCIJA_IDI_LEVO == agentAction )
    {
      if ( envState.getAgentLocation( a ) == LOKACIJA_A2 )
        envState.setAgentLocation( a, LOKACIJA_A1 );
      if ( envState.getAgentLocation( a ) == LOKACIJA_B2 )
        envState.setAgentLocation( a, LOKACIJA_B1 );
      updatePerformanceMeasure( a, -1 );
    }
    else if ( AKCIJA_IDI_DOLE == agentAction )
    {
      if ( envState.getAgentLocation( a ) == LOKACIJA_A1 )
        envState.setAgentLocation( a, LOKACIJA_B1 );
      if ( envState.getAgentLocation( a ) == LOKACIJA_A2 )
        envState.setAgentLocation( a, LOKACIJA_B2 );
      updatePerformanceMeasure( a, -1 );
    }
    else if ( AKCIJA_IDI_GORE == agentAction )
    {
      if ( envState.getAgentLocation( a ) == LOKACIJA_B1 )
        envState.setAgentLocation( a, LOKACIJA_A1 );
      if ( envState.getAgentLocation( a ) == LOKACIJA_B2 )
        envState.setAgentLocation( a, LOKACIJA_A1 );
      updatePerformanceMeasure( a, -1 );
    }
    else if ( AKCIJA_USISAVANJE == agentAction )
    {
      if ( LocationState.Dirty == envState.getLocationState( envState
          .getAgentLocation( a ) ) )
      {
        envState.setLocationState( envState.getAgentLocation( a ),
            LocationState.Clean );
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

    String agentLocation = envState.getAgentLocation( anAgent );
    return new LokalniPogledNaUsusvacOkruzenje( agentLocation,
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