package aima.gui.applications.usisivac;

import aima.core.agent.impl.AbstractAgent;
import aima.core.environment.ususivac.JednostavniRefleksniUsusuvacAgent;
import aima.core.environment.ususivac.RefleksniUsisivacAgent;
import aima.core.environment.ususivac.RefleksniUsisivacAgentZasnovanNaModelu;
import aima.core.environment.ususivac.UsisivacOkruzenje;
import aima.core.search.framework.DefaultStepCostFunction;
import aima.core.search.nondeterministic.NondeterministicProblem;
import aima.gui.framework.AgentAppController;
import aima.gui.framework.AgentAppFrame;
import aima.gui.framework.SimulationThread;
import aima.gui.framework.MessageLogger;

/**
 * Defines how to react on user button events.
 * 
 * @author Ruediger Lunde
 */
public class UsisivacController extends AgentAppController {
	
	protected UsisivacOkruzenje env = null;
	protected AbstractAgent agent = null;
	protected boolean isPrepared = false;
	
	/** Prepares next simulation if that makes sense. */
	@Override
	public void clear() {
		if (!isPrepared())
		prepare(null);
	}

	/**
	 * Creates a vacuum environment and a corresponding agent based on the
	 * state of the selectors and finally passes the environment to the viewer.
	 */
	@Override
	public void prepare(String changedSelector) {
		AgentAppFrame.SelectionState selState = frame.getSelection();
		env = null;
		switch (selState.getValue(UsisivacProzor.ENV_SEL)) {
		case 0:
			env = new UsisivacOkruzenje();
			break;
		}
		agent = null;
		switch (selState.getValue(UsisivacProzor.AGENT_SEL)) {
		case 0:
			agent = new JednostavniRefleksniUsusuvacAgent();
			break;
		case 1:
			agent = new RefleksniUsisivacAgent();
			break;
		case 2:
			agent = new RefleksniUsisivacAgentZasnovanNaModelu();
			break;
		}
		if (env != null && agent != null) {
			frame.getEnvView().setEnvironment(env);
			env.addAgent(agent);
			
			isPrepared = true;
		}
	}
	
	/** Checks whether simulation can be started. */
	@Override
	public boolean isPrepared() {
		return isPrepared && !env.isDone();
	}

	/** Starts simulation. */
	@Override
	public void run(MessageLogger logger) {
		logger.log("<simulation-log>");
		try {
			while (!env.isDone() && !frame.simulationPaused()) {
				Thread.sleep(500);
				env.step();
			}
		} catch (InterruptedException e) {}
		logger.log("Performance: "
				+ env.getPerformanceMeasure(agent));
		logger.log("</simulation-log>\n");
	}

	/** Executes one simulation step. */
	@Override
	public void step(MessageLogger logger) {
		env.step();
	}

	/** Updates the status of the frame after simulation has finished. */
	public void update(SimulationThread simulationThread) {
		if (simulationThread.isCanceled()) {
			frame.setStatus("Task canceled.");
			isPrepared = false;
		} else if (frame.simulationPaused()){
			frame.setStatus("Task paused.");
		} else {
			frame.setStatus("Task completed.");
		}
	}
	
	//
	// PRIVATE METHODS
	//
	
//	private NondeterministicProblem createNondeterministicProblem() {
//		// create problem
//        NondeterministicProblem problem = new NondeterministicProblem(
//                env.getCurrentState(),
//                new VacuumWorldActions(),
//                new VacuumWorldResults(agent),
//                new VacuumWorldGoalTest(agent),
//                new DefaultStepCostFunction());
//        
//        return problem;
//	}
}

