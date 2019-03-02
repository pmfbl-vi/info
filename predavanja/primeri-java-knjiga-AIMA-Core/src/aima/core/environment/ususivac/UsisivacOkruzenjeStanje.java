package aima.core.environment.ususivac;

import aima.core.agent.Agent;
import aima.core.agent.EnvironmentState;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents a state in the Vacuum World
 * 
 * @author Ciaran O'Reilly
 * @author Andrew Brown
 */
public class UsisivacOkruzenjeStanje implements EnvironmentState,
		PoptunoVidljiviPogledUsisvacOkruzenja {

	private Map<String, UsisivacOkruzenje.LocationState> state;
	private Map<Agent, String> agentLocations;

	/**
	 * Constructor
	 */
	public UsisivacOkruzenjeStanje() {
		state = new LinkedHashMap<String, UsisivacOkruzenje.LocationState>();
		agentLocations = new LinkedHashMap<Agent, String>();
	}

	/**
	 * Constructor
	 * 
	 * @param locAState
	 * @param locBState
	 */
	public UsisivacOkruzenjeStanje(
	    UsisivacOkruzenje.LocationState locA1State,
			UsisivacOkruzenje.LocationState locA2State,
      UsisivacOkruzenje.LocationState locB1State,
      UsisivacOkruzenje.LocationState locB2State
			) {
		this();
		state.put(UsisivacOkruzenje.LOKACIJA_A1, locA1State);
    state.put(UsisivacOkruzenje.LOKACIJA_A2, locA2State);
    state.put(UsisivacOkruzenje.LOKACIJA_B1, locB1State);
    state.put(UsisivacOkruzenje.LOKACIJA_B2, locB2State);
	}

	/**
	 * Copy Constructor.
	 * 
	 * @param toCopyState
	 *            Vacuum Environment State to copy.
	 */
	public UsisivacOkruzenjeStanje(UsisivacOkruzenjeStanje toCopyState) {
		this();
		this.state.putAll(toCopyState.state);
		this.agentLocations.putAll(toCopyState.agentLocations);
	}

	@Override
	public String getAgentLocation(Agent a) {
		return agentLocations.get(a);
	}

	/**
	 * Sets the agent location
	 * 
	 * @param a
	 * @param location
	 */
	public void setAgentLocation(Agent a, String location) {
		agentLocations.put(a, location);
	}

	@Override
	public UsisivacOkruzenje.LocationState getLocationState(String location) {
		return state.get(location);
	}

	/**
	 * Sets the location state
	 * 
	 * @param location
	 * @param s
	 */
	public void setLocationState(String location,
			UsisivacOkruzenje.LocationState s) {
		state.put(location, s);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof UsisivacOkruzenjeStanje) {
			UsisivacOkruzenjeStanje s = (UsisivacOkruzenjeStanje) o;
			if (this.state.equals(s.state)
					&& this.agentLocations.equals(s.agentLocations)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Override hashCode()
	 * 
	 * @return the hash code for this object.
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 13 * hash + (this.state != null ? this.state.hashCode() : 0);
		hash = 53
				* hash
				+ (this.agentLocations != null ? this.agentLocations.hashCode()
						: 0);
		return hash;
	}

	/**
	 * Returns a string representation of the environment
	 * 
	 * @return a string representation of the environment
	 */
	@Override
	public String toString() {
		return this.state.toString();
	}
}