package game;

import java.util.Scanner;

import output.Output;

public class GameController {

	private Output view;
	private GameLogic logic;
	
	public GameController(GameLogic logic, Output view, int[][] field) {
		this.logic = logic;
		this.view = view;
		logic.setGameField(field);
	}
	
	private final static int CHAR_TO_INT_OFFSET_ROW = 48;
	private final static int CHAR_TO_INT_OFFSET_COLUMN = 65;
	
	final static int FILLED = 10;
	final static int UNFILLED = -1;
	
	void startGame() {
		view.displayGameRules();
		view.displayField(logic.getCompleteGameField(), logic.getGameSize());
		
		double time = System.currentTimeMillis();
		
		Scanner scanner = new Scanner(System.in);
		
		while (!logic.gameIsFinished()) {
			System.out.println("Spalte Reihe Zeichen: X/*");
			
			String s = scanner.nextLine();
//			System.out.println(s.length());
			
			char[] tmp = s.toCharArray();
//			System.out.println(tmp.length);
//			for (int i = 0; i < tmp.length; i++) {
////				System.out.print(tmp[i] + " " + i);		
//			}
			
			logic.setSingleField(tmp[1] - CHAR_TO_INT_OFFSET_ROW, tmp[0] - CHAR_TO_INT_OFFSET_COLUMN, tmp[2]);
			view.displayField(logic.getCompleteGameField(), logic.getGameSize());
		}
		time = (System.currentTimeMillis() - time) / 1000;
		view.displayElapsedTime(time);
		view.displayCongratulations();
		scanner.close();
	}

	
	


}
