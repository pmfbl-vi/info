package aima.core.environment.ususivac;

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
public class UsisivacSvetAkcije implements ActionsFunction {

	private static final Set<Action> _actions;
	static {
		Set<Action> actions = new HashSet<Action>();
		actions.add(UsisivacOkruzenje.AKCIJA_USISAVANJE);
		actions.add(UsisivacOkruzenje.AKCIJA_IDI_LEVO);
    actions.add(UsisivacOkruzenje.AKCIJA_IDI_DESNO);
    actions.add(UsisivacOkruzenje.AKCIJA_IDI_GORE);
    actions.add(UsisivacOkruzenje.AKCIJA_IDI_DOLE);
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
