package aima.core.environment.ususivac;

import aima.core.agent.Agent;
import aima.core.agent.Percept;

/**
 * Implements a fully observable environment percept, in accordance with page
 * 134, AIMAv3.
 *
 * @author Andrew Brown
 */
public interface PoptunoVidljiviPogledUsisvacOkruzenja extends Percept {
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
    UsisivacOkruzenje.LocationState getLocationState(String location);
}
