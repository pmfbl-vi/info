package aima.core.environment.vacuum2x2;

import aima.core.agent.Agent;
import aima.core.agent.Percept;

public interface FullyObservableVacuum2x2EnvironmentPercept extends Percept {
	/**
     * Returns the agent location
     *
     * @param a
     * @return the agents location
     */
    String getAgentLocation(Agent a);
    
    /**
     * Returns the location state
     *
     * @param location
     * @return the location state
     */
    Vacuum2x2Environment.LocationState getLocationState(String location);
}
