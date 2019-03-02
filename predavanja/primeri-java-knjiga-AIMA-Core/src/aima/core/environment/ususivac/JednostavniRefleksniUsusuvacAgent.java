package aima.core.environment.ususivac;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.impl.AbstractAgent;
import aima.core.agent.impl.aprog.SimpleReflexAgentProgram;
import aima.core.agent.impl.aprog.simplerule.EQUALCondition;
import aima.core.agent.impl.aprog.simplerule.Rule;

/**
 * @author Ciaran O'Reilly
 * 
 */
public class JednostavniRefleksniUsusuvacAgent extends AbstractAgent {

	public JednostavniRefleksniUsusuvacAgent() {
		super(new SimpleReflexAgentProgram(getRuleSet()));
	}

	//
	// PRIVATE METHODS
	//
	private static Set<Rule> getRuleSet() {
		// Note: Using a LinkedHashSet so that the iteration order (i.e. implied
		// precedence) of rules can be guaranteed.
		Set<Rule> rules = new LinkedHashSet<Rule>();

		// Rules based on REFLEX-VACUUM-AGENT:
		// Artificial Intelligence A Modern Approach (3rd Edition): Figure 2.8,
		// page 48.

		rules.add(new Rule(
		    new EQUALCondition(LokalniPogledNaUsusvacOkruzenje.ATTRIBUTE_STATE,
				UsisivacOkruzenje.LocationState.Dirty),
				UsisivacOkruzenje.AKCIJA_USISAVANJE));
		rules.add(new Rule(new EQUALCondition(
				LokalniPogledNaUsusvacOkruzenje.ATTRIBUTE_AGENT_LOCATION,
				UsisivacOkruzenje.LOKACIJA_A1),
				UsisivacOkruzenje.AKCIJA_IDI_DESNO));
    rules.add(new Rule(new EQUALCondition(
        LokalniPogledNaUsusvacOkruzenje.ATTRIBUTE_AGENT_LOCATION,
        UsisivacOkruzenje.LOKACIJA_A2),
        UsisivacOkruzenje.AKCIJA_IDI_DOLE));
    rules.add(new Rule(new EQUALCondition(
        LokalniPogledNaUsusvacOkruzenje.ATTRIBUTE_AGENT_LOCATION,
        UsisivacOkruzenje.LOKACIJA_B2),
        UsisivacOkruzenje.AKCIJA_IDI_LEVO));
    rules.add(new Rule(new EQUALCondition(
        LokalniPogledNaUsusvacOkruzenje.ATTRIBUTE_AGENT_LOCATION,
        UsisivacOkruzenje.LOKACIJA_B1),
        UsisivacOkruzenje.AKCIJA_IDI_GORE));

		return rules;
	}
}
