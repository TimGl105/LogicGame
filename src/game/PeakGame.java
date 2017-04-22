package game;

import output.OutputGerman;

public class PeakGame {
	
	public static void main(String[] args) {
		GameLogic logic = new GameLogic(1);
		OutputGerman view = new OutputGerman(logic);
		GameController game = new GameController(logic, view, CAR);
		game.startGame();
	}
	
	//Alternative Games
	
	public static final int[][] CAR = {
			{0, 0, 0, 0},
			{0, 1, 1, 1},
			{1, 1, 1, 1},
			{1, 0, 0, 1}};
	
	public static final int[][] COOKIE = {
			{1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 1, 0, 0, 1},
			{1, 0, 1, 1, 1, 0, 1},
			{1, 1, 1, 1, 1, 1, 1},
			{1, 0, 1, 1, 1, 0, 1},
			{1, 0, 0, 1, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1}};
	
}

