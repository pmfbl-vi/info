package aima.core.environment.vacuum2x2;

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
public class SimpleReflexVacuum2x2Agent extends AbstractAgent {

	public SimpleReflexVacuum2x2Agent() {
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

		rules.add(new Rule(new EQUALCondition(LocalVacuum2x2EnvironmentPercept.ATTRIBUTE_STATE,
				Vacuum2x2Environment.LocationState.Prljavo),
				Vacuum2x2Environment.AKCIJA_USISAVAJ));
		rules.add(new Rule(new EQUALCondition(
				LocalVacuum2x2EnvironmentPercept.ATTRIBUTE_AGENT_LOCATION,
				Vacuum2x2Environment.LOKACIJA_A1),
				Vacuum2x2Environment.AKCIJA_IDI_DESNO));
		rules.add(new Rule(new EQUALCondition(
				LocalVacuum2x2EnvironmentPercept.ATTRIBUTE_AGENT_LOCATION,
				Vacuum2x2Environment.LOKACIJA_A2),
				Vacuum2x2Environment.AKCIJA_IDI_DOLE));
    rules.add(new Rule(new EQUALCondition(
        LocalVacuum2x2EnvironmentPercept.ATTRIBUTE_AGENT_LOCATION,
        Vacuum2x2Environment.LOKACIJA_B2),
        Vacuum2x2Environment.AKCIJA_IDI_LEVO));
    rules.add(new Rule(new EQUALCondition(
        LocalVacuum2x2EnvironmentPercept.ATTRIBUTE_AGENT_LOCATION,
        Vacuum2x2Environment.LOKACIJA_B1),
        Vacuum2x2Environment.AKCIJA_IDI_GORE));
		return rules;
	}
}
