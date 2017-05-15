package game;

import java.util.Scanner;
import java.util.Vector;

import output.Output;

public class GameController {

	private Output view;
	private GameLogic logic;
	private Vector<GameField> games;
	
	public GameController(GameLogic logic, Output view, Vector<GameField> games) {
		this.logic = logic;
		this.view = view;
		this.games = games;
	}
	
	private final static int CHAR_TO_INT_OFFSET_ROW = 49;
	private final static int CHAR_TO_INT_OFFSET_COLUMN = 65;
	
	final static int FILLED = 10;
	final static int UNFILLED = -1;
	
	void startGame() {
		view.displayGameRules();
		view.displayGameOptions(games);

		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt() - 1;
//		if (i == 1) {
//			
//		}
		logic.setGameField(games.get(i).getGameField());
		
		scanner.nextLine();

		view.displayField(logic.getCompleteGameField(), logic.getGameSize(), logic.getCompleteGameSize());
		
		double time = System.currentTimeMillis();
		
		while (!logic.gameIsFinished()) {
			System.out.println("Spalte Reihe Zeichen: X/*");
			
			String s = scanner.nextLine();
			
			char[] tmp = s.toCharArray();
			
			//just for testing
//			System.out.println(s.length());
//			System.out.println(tmp.length);
//			for (int j = 0; j < tmp.length; j++) {
//				System.out.print(tmp[j] + " " + j);		
//			}
//			System.out.println();
			tmp[0] = Character.toUpperCase(tmp[0]);
			tmp[2] = Character.toUpperCase(tmp[2]);
			
			logic.setSingleField(tmp[1] - CHAR_TO_INT_OFFSET_ROW, tmp[0] - CHAR_TO_INT_OFFSET_COLUMN, tmp[2]);
			view.displayField(logic.getCompleteGameField(), logic.getGameSize(), logic.getCompleteGameSize());
		}
		time = (System.currentTimeMillis() - time) / 1000;
		view.displayCongratulations();
		view.displayElapsedTime(time);
		scanner.close();
	}

	
	


}
