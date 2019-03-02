package aima.core.environment.puzzleN;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;

/**
 * @author Ravi Mohan
 * @author Ciaran O'Reilly
 */
public class PuzzleNFunctionFactory {
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;

	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new PNActionsFunction();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new PNResultFunction();
		}
		return _resultFunction;
	}

	private static class PNActionsFunction implements ActionsFunction {
		public Set<Action> actions(Object state) {
			PuzzleNBoard board = (PuzzleNBoard) state;

			Set<Action> actions = new LinkedHashSet<Action>();

			if (board.canMoveGap(PuzzleNBoard.UP)) {
				actions.add(PuzzleNBoard.UP);
			}
			if (board.canMoveGap(PuzzleNBoard.DOWN)) {
				actions.add(PuzzleNBoard.DOWN);
			}
			if (board.canMoveGap(PuzzleNBoard.LEFT)) {
				actions.add(PuzzleNBoard.LEFT);
			}
			if (board.canMoveGap(PuzzleNBoard.RIGHT)) {
				actions.add(PuzzleNBoard.RIGHT);
			}

			return actions;
		}
	}

	private static class PNResultFunction implements ResultFunction {
		public Object result(Object s, Action a) {
			PuzzleNBoard board = (PuzzleNBoard) s;

			if (PuzzleNBoard.UP.equals(a)
					&& board.canMoveGap(PuzzleNBoard.UP)) {
				PuzzleNBoard newBoard = new PuzzleNBoard(board);
				newBoard.moveGapUp();
				return newBoard;
			} else if (PuzzleNBoard.DOWN.equals(a)
					&& board.canMoveGap(PuzzleNBoard.DOWN)) {
				PuzzleNBoard newBoard = new PuzzleNBoard(board);
				newBoard.moveGapDown();
				return newBoard;
			} else if (PuzzleNBoard.LEFT.equals(a)
					&& board.canMoveGap(PuzzleNBoard.LEFT)) {
				PuzzleNBoard newBoard = new PuzzleNBoard(board);
				newBoard.moveGapLeft();
				return newBoard;
			} else if (PuzzleNBoard.RIGHT.equals(a)
					&& board.canMoveGap(PuzzleNBoard.RIGHT)) {
				PuzzleNBoard newBoard = new PuzzleNBoard(board);
				newBoard.moveGapRight();
				return newBoard;
			}

			// The Action is not understood or is a NoOp
			// the result will be the current state.
			return s;
		}
	}
}