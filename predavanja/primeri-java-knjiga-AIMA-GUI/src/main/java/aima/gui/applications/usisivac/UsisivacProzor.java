package aima.gui.applications.usisivac;

import aima.gui.framework.AgentAppFrame;

/**
 * Adds some selectors to the base class and adjusts its size.
 * 
 * @author Ruediger Lunde
 */
public class UsisivacProzor extends AgentAppFrame {
	private static final long serialVersionUID = 1L;
	public static String ENV_SEL = "EnvSelection";
	public static String AGENT_SEL = "AgentSelection";

	public UsisivacProzor() {
		setTitle("Vacuum Agent Application");
		setSelectors(new String[] { ENV_SEL, AGENT_SEL }, new String[] {
				"Select Environment", "Select Agent" });
    setSelectorItems( ENV_SEL, new String[] { "A/B Deterministic Environment"},
				0);
		setSelectorItems(AGENT_SEL, new String[] {
				"JednostavniRefleksniUsusuvacAgent",
				"RefleksniUsisivacAgent",
				"RefleksniUsisivacAgentZasnovanNaModelu" },
				0);
		setEnvView(new UsisivacPogled());
		setSize(800, 400);
	}
}