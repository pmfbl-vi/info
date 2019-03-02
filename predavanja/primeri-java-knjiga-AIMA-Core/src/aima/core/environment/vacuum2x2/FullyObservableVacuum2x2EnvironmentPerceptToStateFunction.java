package aima.core.environment.vacuum2x2;

import aima.core.agent.Percept;
import aima.core.search.framework.PerceptToStateFunction;


public class FullyObservableVacuum2x2EnvironmentPerceptToStateFunction implements
		PerceptToStateFunction {

	/**
	 * Default Constructor.
	 */
	public FullyObservableVacuum2x2EnvironmentPerceptToStateFunction() {

	}

	@Override
	public Object getState(Percept p) {
		// Note: VacuumEnvironmentState implements
		// FullyObservableVacuumEnvironmentPercept
		return (Vacuum2x2EnvironmentState) p;
	}
}
