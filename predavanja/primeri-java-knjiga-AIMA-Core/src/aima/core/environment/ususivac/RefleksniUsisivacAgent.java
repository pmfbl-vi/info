package aima.core.environment.ususivac;

import aima.core.agent.Action;
import aima.core.agent.AgentProgram;
import aima.core.agent.Percept;
import aima.core.agent.impl.AbstractAgent;
import aima.core.agent.impl.NoOpAction;

/**
 * Artificial Intelligence A Modern Approach (3rd Edition): Figure 2.8, page 48.<br>
 * <br>
 * 
 * <pre>
 * function REFLEX-VACUUM-AGENT([location, status]) returns an action
 *   
 *   if status = Dirty then return Suck
 *   else if location = A then return Right
 *   else if location = B then return Left
 * </pre>
 * 
 * Figure 2.8 The agent program for a simple reflex agent in the two-state
 * vacuum environment. This program implements the action function tabulated in
 * Figure 2.3.
 * 
 * @author Ciaran O'Reilly
 * 
 */
public class RefleksniUsisivacAgent extends AbstractAgent
{

  public RefleksniUsisivacAgent()
  {
    super( new AgentProgram()
    {
      // function REFLEX-VACUUM-AGENT([location, status]) returns an
      // action
      public Action execute( Percept percept )
      {
        LokalniPogledNaUsusvacOkruzenje vep = ( LokalniPogledNaUsusvacOkruzenje ) percept;

        // if status = Dirty then return Suck
        if ( UsisivacOkruzenje.LocationState.Dirty == vep.getLocationState() )
        {
          return UsisivacOkruzenje.AKCIJA_USISAVANJE;
          // else if location = A then return Right
        }
        else if ( UsisivacOkruzenje.LOKACIJA_A1 == vep.getAgentLocation() )
        {
          return UsisivacOkruzenje.AKCIJA_IDI_DESNO;
        }
        else if ( UsisivacOkruzenje.LOKACIJA_A2 == vep.getAgentLocation() )
        {
          return UsisivacOkruzenje.AKCIJA_IDI_DOLE;
        }
        else if ( UsisivacOkruzenje.LOKACIJA_B2 == vep.getAgentLocation() )
        {
          return UsisivacOkruzenje.AKCIJA_IDI_LEVO;
        }
        else if ( UsisivacOkruzenje.LOKACIJA_B1 == vep.getAgentLocation() )
        {
          return UsisivacOkruzenje.AKCIJA_IDI_GORE;
        }
 
        // Note: This should not be returned if the
        // environment is correct
        return NoOpAction.NO_OP;
      }
    } );
  }
}
