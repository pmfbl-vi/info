package aima.core.environment.vacuum2x2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;

/**
 * Specifies the actions available to the agent at state s
 * 
 * @author Andrew Brown
 */
public class Vacuum2x2WorldActions implements ActionsFunction {

	private static final Set<Action> _actions;
	static {
		Set<Action> actions = new HashSet<Action>();
		actions.add(Vacuum2x2Environment.AKCIJA_USISAVAJ);
		actions.add(Vacuum2x2Environment.AKCIJA_IDI_LEVO);
		actions.add(Vacuum2x2Environment.AKCIJA_IDI_DESNO);
		// Ensure cannot be modified.
		_actions = Collections.unmodifiableSet(actions);
	}

	/**
	 * Returns possible actions given this state
	 * 
	 * @param s
	 * @return possible actions given this state.
	 */
	@Override
	public Set<Action> actions(Object s) {
		return _actions;
	}
}
