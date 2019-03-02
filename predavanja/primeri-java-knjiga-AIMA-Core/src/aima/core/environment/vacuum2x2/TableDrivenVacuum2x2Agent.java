package aima.core.environment.vacuum2x2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aima.core.agent.Action;
import aima.core.agent.Percept;
import aima.core.agent.impl.AbstractAgent;
import aima.core.agent.impl.aprog.TableDrivenAgentProgram;

/**
 * Artificial Intelligence A Modern Approach (3rd Edition): Figure 2.3, page 36.<br>
 * <br>
 * Figure 2.3 Partial tabulation of a simple agent function for the
 * vacuum-cleaner world shown in Figure 2.2.
 * 
 * @author Ciaran O'Reilly
 * 
 */
public class TableDrivenVacuum2x2Agent extends AbstractAgent
{

  public TableDrivenVacuum2x2Agent()
  {
    super( new TableDrivenAgentProgram( getPerceptSequenceActions() ) );
  }

  //
  // PRIVATE METHODS
  //
  private static Map<List<Percept>, Action> getPerceptSequenceActions()
  {
    Map<List<Percept>, Action> perceptSequenceActions = new HashMap<List<Percept>, Action>();

    // NOTE: While this particular table could be setup simply
    // using a few loops, the intent is to show how quickly a table
    // based approach grows and becomes unusable.
    List<Percept> ps;
    //
    // Level 1: 8 states
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A1,
        Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_DESNO );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A1,
        Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A2,
        Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_DOLE );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A2,
        Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B2,
        Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_LEVO );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B2,
        Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B1,
        Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_GORE );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B1,
        Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );

    //
    // Level 2: 8x8 states
    // 1
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A1,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_DESNO );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A1,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A2,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_DOLE );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A2,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B1,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_GORE );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B1,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B2,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_LEVO );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B2,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );

    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A1,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_DESNO );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A1,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A2,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_DOLE );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A2,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B1,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_GORE );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B1,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B2,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_LEVO );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B2,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );

    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A1,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_DESNO );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A1,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A2,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_DOLE );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A2,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B1,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_GORE );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B1,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B2,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_LEVO );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B2,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );

    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A1,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_DESNO );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A1,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A2,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_DOLE );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A2,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B1,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_GORE );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B1,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B2,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_LEVO );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_B2,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_B2,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );

    //
    // Level 3: 8x8x8 states
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A1,
            Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A1,
            Vacuum2x2Environment.LocationState.Cisto ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_IDI_DESNO );
    ps = createPerceptSequence( new LocalVacuum2x2EnvironmentPercept(
        Vacuum2x2Environment.LOKACIJA_A1,
        Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A1,
            Vacuum2x2Environment.LocationState.Cisto ),
        new LocalVacuum2x2EnvironmentPercept( Vacuum2x2Environment.LOKACIJA_A1,
            Vacuum2x2Environment.LocationState.Prljavo ) );
    perceptSequenceActions.put( ps, Vacuum2x2Environment.AKCIJA_USISAVAJ );
    // ...

    //
    // Level 4: 8x8x8x8 states
    // ...

    return perceptSequenceActions;
  }

  private static List<Percept> createPerceptSequence( Percept... percepts )
  {
    List<Percept> perceptSequence = new ArrayList<Percept>();

    for ( Percept p : percepts )
    {
      perceptSequence.add( p );
    }

    return perceptSequence;
  }
}
