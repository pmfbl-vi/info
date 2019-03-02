package aima.gui.applications.usisivac;

import aima.gui.framework.AgentAppController;
import aima.gui.framework.AgentAppEnvironmentView;
import aima.gui.framework.AgentAppFrame;
import aima.gui.framework.SimpleAgentApp;

/**
 * Simple graphical application for experiments with vacuum cleaner agents. It
 * can be used as a template for creating other graphical agent applications.
 * 
 * @author Ruediger Lunde
 */
public class UsisivacApp extends SimpleAgentApp {

	/** Returns a <code>VacuumView</code> instance. */
	@Override
	public AgentAppEnvironmentView createEnvironmentView() {
		return new UsisivacPogled();
	}
	
	/** Returns a <code>VacuumFrame</code> instance. */
	@Override
	public AgentAppFrame createFrame() {
		return new UsisivacProzor();
	}

	/** Returns a <code>VacuumController</code> instance. */
	@Override
	public AgentAppController createController() {
		return new UsisivacController();
	}

	
	/////////////////////////////////////////////////////////////////
	// main method

	/**
	 * Starts the application.
	 */
	public static void main(String args[]) {
		new UsisivacApp().startApplication();
	}
}
