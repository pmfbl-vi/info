package aima.gui.applications.vacuum2x2;

import aima.core.agent.impl.AbstractAgent;
import aima.core.environment.vacuum2x2.FullyObservableVacuum2x2EnvironmentPerceptToStateFunction;
import aima.core.environment.vacuum2x2.ModelBasedReflexVacuum2x2Agent;
import aima.core.environment.vacuum2x2.NondeterministicVacuum2x2Agent;
import aima.core.environment.vacuum2x2.NondeterministicVacuum2x2Environment;
import aima.core.environment.vacuum2x2.ReflexVacuum2x2Agent;
import aima.core.environment.vacuum2x2.SimpleReflexVacuum2x2Agent;
import aima.core.environment.vacuum2x2.TableDrivenVacuum2x2Agent;
import aima.core.environment.vacuum2x2.TableDrivenVacuum2x2Agent;
import aima.core.environment.vacuum2x2.Vacuum2x2Environment;
import aima.core.environment.vacuum2x2.Vacuum2x2WorldActions;
import aima.core.environment.vacuum2x2.Vacuum2x2WorldGoalTest;
import aima.core.environment.vacuum2x2.Vacuum2x2WorldResults;
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
public class Vacuum2x2Controller extends AgentAppController {
	
	protected Vacuum2x2Environment env = null;
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
		switch (selState.getValue(Vacuum2x2Frame.ENV_SEL)) {
		case 0:
			env = new Vacuum2x2Environment();
			break;
		case 1:
			env = new NondeterministicVacuum2x2Environment();
			break;
		}
		agent = null;
		switch (selState.getValue(Vacuum2x2Frame.AGENT_SEL)) {
		case 0:
			agent = new TableDrivenVacuum2x2Agent();
			break;
		case 1:
			agent = new ReflexVacuum2x2Agent();
			break;
		case 2:
			agent = new SimpleReflexVacuum2x2Agent();
			break;
		case 3:
			agent = new ModelBasedReflexVacuum2x2Agent();
			break;
		case 4:
			agent = createNondeterministic2x2VacuumAgent();
			break;
		}
		if (env != null && agent != null) {
			frame.getEnvView().setEnvironment(env);
			env.addAgent(agent);
			if (agent instanceof NondeterministicVacuum2x2Agent) {
				// Set the problem now for this kind of agent
		        // set the problem and agent
		        ((NondeterministicVacuum2x2Agent)agent).setProblem(createNondeterministicProblem());
			}
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
	private NondeterministicVacuum2x2Agent createNondeterministic2x2VacuumAgent() {
		NondeterministicVacuum2x2Agent agent = new NondeterministicVacuum2x2Agent(
        		new FullyObservableVacuum2x2EnvironmentPerceptToStateFunction());
        
        return agent;
	}
	
	private NondeterministicProblem createNondeterministicProblem() {
		// create problem
        NondeterministicProblem problem = new NondeterministicProblem(
                env.getCurrentState(),
                new Vacuum2x2WorldActions(),
                new Vacuum2x2WorldResults(agent),
                new Vacuum2x2WorldGoalTest(agent),
                new DefaultStepCostFunction());
        
        return problem;
	}
}

