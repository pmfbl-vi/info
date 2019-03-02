package aima.gui.applications.vacuum2x2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import aima.core.agent.Action;
import aima.core.agent.Agent;
import aima.core.agent.EnvironmentState;
import aima.core.agent.impl.DynamicAction;
import aima.core.environment.vacuum2x2.Vacuum2x2Environment;
import aima.gui.framework.EmptyEnvironmentView;

/**
 * Displays the informations provided by a <code>VacuumEnvironment</code> on a
 * panel using 2D-graphics.
 * 
 * @author Ruediger Lunde
 */
public class Vacuum2x2View extends EmptyEnvironmentView
{

  private static final long serialVersionUID = 1L;
  private Hashtable<Agent, Action> lastActions = new Hashtable<Agent, Action>();

  @Override
  public void agentActed( Agent agent, Action action,
      EnvironmentState resultingState )
  {
    lastActions.put( agent, action );
    String prefix = "";
    if ( env.getAgents().size() > 1 )
      prefix = "A" + env.getAgents().indexOf( agent ) + ": ";
    notify( prefix + action.toString() );
    super.agentActed( agent, action, resultingState );
  }

  protected Vacuum2x2Environment getVacuumEnv()
  {
    return ( Vacuum2x2Environment ) env;
  }

  /**
   * Creates a 2D-graphics showing the agent in its environment. Locations are
   * represented as rectangles, dirt as grey background color, and the agent as
   * red Pacman.
   */
  @Override
  public void paintComponent( Graphics g )
  {
    List<String> locations = getLocations();
    adjustTransformation( 0, 0, 11 * locations.size() / 2 - 1, 20 );
    Graphics2D g2 = ( Graphics2D ) g;
    g2.setBackground( Color.white );
    g2.clearRect( 0, 0, getWidth(), getHeight() );
    for ( int i = 0; i < locations.size(); i++ )
    {
      String location = locations.get( i );
      if ( isDirty( location ) )
      {
        g2.setColor( Color.LIGHT_GRAY );
        g2.fillRect( x( 11 * ( i % 2 ) ), y( 11 * ( i / 2 ) ), scale( 10 ),
            scale( 10 ) );
      }
      g2.setColor( Color.black );
      g2.drawRect( x( 11 * ( i % 2 ) ), y( 11 * ( i / 2 ) ), scale( 10 ),
          scale( 10 ) );
      g2.drawString( location.toString(), x( 11 * ( i % 2 ) ) + 10,
          y( 11 * ( i / 2 ) ) + 20 );
      Agent agent = getAgent( location );
      if ( agent != null )
      {
        Action action = lastActions.get( agent );
        g2.setColor( Color.RED );
        if ( action == null
            || !( ( DynamicAction ) action ).getAttribute( "name" ).equals(
                "Suck" ) )
          g2.fillArc( x( 11 * ( i % 2 ) + 2 ), y( 11 * ( i / 2 ) ), scale( 6 ),
              scale( 6 ), 200, 320 );
        else
        {
          g2.fillOval( x( 11 * ( i % 2 ) + 2 ), y( 11 * ( i / 2 ) ),
              scale( 6 ), scale( 6 ) );
        }
      }
    }
  }

  /** Returns the names of all locations used. */
  protected List<String> getLocations()
  {
    List<String> result = new ArrayList<String>();
    if ( env != null )
    {
      result.add( Vacuum2x2Environment.LOKACIJA_A1 );
      result.add( Vacuum2x2Environment.LOKACIJA_A2 );
      result.add( Vacuum2x2Environment.LOKACIJA_B1 );
      result.add( Vacuum2x2Environment.LOKACIJA_B2 );
    }
    return result;
  }

  /** Checks whether the specified location is dirty. */
  protected boolean isDirty( String location )
  {
    return Vacuum2x2Environment.LocationState.Prljavo == getVacuumEnv()
        .getLocationState( location );
  }

  /**
   * Checks whether an agent is currently at the specified location and returns
   * one of them if any.
   * */
  protected Agent getAgent( Object location )
  {
    Vacuum2x2Environment e = getVacuumEnv();
    for ( Agent a : e.getAgents() )
      if ( location.equals( e.getAgentLocation( a ) ) )
        return a;
    return null;
  }
}
