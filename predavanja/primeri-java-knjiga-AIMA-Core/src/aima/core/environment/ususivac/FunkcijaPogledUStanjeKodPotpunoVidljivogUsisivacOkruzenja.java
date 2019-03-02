package aima.core.environment.ususivac;

import aima.core.agent.Percept;
import aima.core.search.framework.PerceptToStateFunction;

/**
 * Map fully observable state percepts to their corresponding state
 * representation.
 * 
 * @author Andrew Brown
 */
public class FunkcijaPogledUStanjeKodPotpunoVidljivogUsisivacOkruzenja implements
		PerceptToStateFunction {

	/**
	 * Default Constructor.
	 */
	public FunkcijaPogledUStanjeKodPotpunoVidljivogUsisivacOkruzenja() {

	}

	@Override
	public Object getState(Percept p) {
		// Note: VacuumEnvironmentState implements
		// FullyObservableVacuumEnvironmentPercept
		return (UsisivacOkruzenjeStanje) p;
	}
}
