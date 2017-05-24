package game;

import java.util.Vector;

import input.Input;
import output.Output;

public class GameController extends Thread {

	private Input input;
	private Output view;
	private GameLogic logic;
	private Vector<Game> games;
	private int currentGame;
	private String playerName;
	private double time;
	private int rank = -1;

	private Thread thread;
	private String threadName;

	public GameController(String name, GameLogic logic, Output view, Vector<Game> games) {
		this.threadName = name;
		this.logic = logic;
		this.view = view;
		this.games = games;
	}

	private final static int CHAR_TO_INT_OFFSET_ROW = 49;
	private final static int CHAR_TO_INT_OFFSET_COLUMN = 65;

	final static int FILLED = 10;
	final static int UNFILLED = -1;

	public void start() {
		if (thread == null) {
			thread = new Thread(this, threadName);
		}
		thread.run();
	}

	@Override
	public void run() {

		input = new Input(System.in, view);
		try {
			view.displayGameRules();
			view.displayGameOptions(games);

			currentGame = input.getGameDecision(games.size());
			while(currentGame == -1) {
				view.displayWrongGameInputMessage();
				currentGame = input.getGameDecision(games.size());
			}
			
			logic.setGameField(games.get(currentGame).getGamefield().getField());	// not for input

			view.displayField(logic.getCompleteGameField(), logic.getGameSize(), logic.getCompleteGameSize());

			time = System.currentTimeMillis();

			while (!logic.gameIsFinished()) {
				view.displayFieldInputRequest();

				char[] tmp = input.getNextField(logic.getGameSize());
				logic.setSingleField(tmp[1] - CHAR_TO_INT_OFFSET_ROW, tmp[0] - CHAR_TO_INT_OFFSET_COLUMN, tmp[2]);
				view.displayField(logic.getCompleteGameField(), logic.getGameSize(), logic.getCompleteGameSize());
			}
			
			time = (System.currentTimeMillis() - time) / 1000;
			view.displayCongratulations();
			view.displayElapsedTime(time);

			setRank();
			view.displayHighscoresBeforeNewEntry(games.get(currentGame).getRanklist(), rank);
			if (rank < 3 && rank >= 0) {
				view.displayNameInputMessage();
				playerName = input.getName();
				games.get(currentGame).getRanklist().setWinnerEntry(rank, playerName, time);
				view.displayHighscoresAfterNewEntry(games.get(currentGame).getRanklist());
			}

			// } catch (InterruptedException e) {
			// System.out.println("Thread " + threadName + " interrupted.");
		} finally {
		}

	}

	/**
	 * Gets rank and sets it to global variable.
	 */
	private void setRank() {
		int i = games.get(currentGame).getRanklist().validateWinner(time);
		if (i <= 3) {
			rank = i;
		} else {
			rank = -1;
		}
	}
	
	public boolean playerWantsRestart() {
		view.displayRestartOption();
		return input.getRestartDecision();
	}
}