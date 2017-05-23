package game;

import java.util.Scanner;
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

	@SuppressWarnings("resource")
	@Override
	public void run() {

//		input = input.getInstance(System.in);
		Scanner scanner = new Scanner(System.in);
		try {
			view.displayGameRules();
			view.displayGameOptions(games);

//			currentGame = input.getGameOption(games.size());
//			while(currentGame == -1) {
//				view.displayWrongGameInputMessage();
//				currentGame = input.getGameOption(games.size());
//			}
			currentGame = scanner.nextInt() - 1;
			while (currentGame <= -1 || currentGame >= games.size()) {
				scanner.nextLine();
				view.displayWrongGameInputMessage();
				currentGame = (scanner.hasNextInt()) ? scanner.nextInt() - 1 : -1;
			}
			
			logic.setGameField(games.get(currentGame).getGamefield().getField());
			scanner.nextLine();

			view.displayField(logic.getCompleteGameField(), logic.getGameSize(), logic.getCompleteGameSize());

			time = System.currentTimeMillis();

			while (!logic.gameIsFinished()) {
				view.displayFieldInputRequest();

				String s = (scanner.hasNextLine()) ? scanner.nextLine() : "";

				while (true) {
					while (s.length() != 3) {
						view.displayWrongInputLength();
						s = (scanner.hasNextLine()) ? scanner.nextLine() : "";
					}
					char[] tmp = s.toCharArray();
					tmp[0] = Character.toUpperCase(tmp[0]);
					tmp[2] = Character.toUpperCase(tmp[2]);

					if ((int) tmp[0] < CHAR_TO_INT_OFFSET_COLUMN
							|| (int) tmp[0] >= logic.getGameSize() + CHAR_TO_INT_OFFSET_COLUMN) {
						System.out.println((int) tmp[0] + " " + tmp[0]);
						view.displayWrongInputMessage(tmp[0], Output.ERROR_IN_COLUMN);
						// view.displayWrongColumnInputMessage(tmp[0]);
					} else if ((int) tmp[1] < CHAR_TO_INT_OFFSET_ROW
							|| (int) tmp[1] >= logic.getGameSize() + CHAR_TO_INT_OFFSET_ROW) {
						view.displayWrongInputMessage(tmp[1], Output.ERROR_IN_ROW);
						// view.displayWrongRowInputMessage(tmp[1]);
					} else if (!((tmp[2] == 'X') || (tmp[2] == '*') || (tmp[2] == '~'))) {
						view.displayWrongInputMessage(tmp[2], Output.ERROR_IN_SYMBOL);
						// view.displayWrongSymbolInputMessage(tmp[2]);
					} else {
						logic.setSingleField(tmp[1] - CHAR_TO_INT_OFFSET_ROW, tmp[0] - CHAR_TO_INT_OFFSET_COLUMN,
								tmp[2]);
						view.displayField(logic.getCompleteGameField(), logic.getGameSize(),
								logic.getCompleteGameSize());
						break;
					}

					s = (scanner.hasNextLine()) ? scanner.nextLine() : "";
				}

			}
			time = (System.currentTimeMillis() - time) / 1000;
			view.displayCongratulations();
			view.displayElapsedTime(time);

			setRank();
			view.displayHighscoresBeforeNewEntry(games.get(currentGame).getRanklist(), rank);
			if (rank < 3 && rank >= 0) {
				view.displayNameInputMessage();
				playerName = (scanner.hasNextLine()) ? scanner.nextLine() : "";
				games.get(currentGame).getRanklist().setWinnerEntry(rank, playerName, time);
				view.displayHighscoresAfterNewEntry(games.get(currentGame).getRanklist());
			}

			// } catch (InterruptedException e) {
			// System.out.println("Thread " + threadName + " interrupted.");
		} finally {
			if (scanner != null) {
//				scanner.close();
			}
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
		
		Scanner scanner = new Scanner(System.in);
		String s = (scanner.hasNextLine()) ? scanner.nextLine() : "";
		
		boolean b = (s.equals("Ja") || s.equals("ja"));
		
//		scanner.close();
		return b;
	}
}