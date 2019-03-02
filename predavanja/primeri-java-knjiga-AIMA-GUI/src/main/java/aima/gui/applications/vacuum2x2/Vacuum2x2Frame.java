package aima.gui.applications.vacuum2x2;

import aima.gui.framework.AgentAppFrame;

/**
 * Adds some selectors to the base class and adjusts its size.
 * 
 * @author Ruediger Lunde
 */
public class Vacuum2x2Frame extends AgentAppFrame {
	private static final long serialVersionUID = 1L;
	public static String ENV_SEL = "EnvSelection";
	public static String AGENT_SEL = "AgentSelection";

	public Vacuum2x2Frame() {
		setTitle("Vacuum Agent Application");
		setSelectors(new String[] { ENV_SEL, AGENT_SEL }, new String[] {
				"Select Environment", "Select Agent" });
    setSelectorItems( ENV_SEL, new String[] { "2x2 Deterministic Environment",
				"2x2 Non-Deterministic Environment"}, 
				0);
		setSelectorItems(AGENT_SEL, new String[] {
				"TableDrivenVacuumAgent",
				"ReflexVacuumAgent",
				"SimpleReflexVacuumAgent",
				"ModelBasedReflexVacuumAgent",
				"NondeterministicVacuumAgent" },
				0);
		setEnvView(new Vacuum2x2View());
		setSize(800, 400);
	}
}