package game;

import java.util.Vector;

import output.OutputGerman;

public class PeakGame {
	
	private static Vector<Game> games;

	public static void main(String[] args) {
		PeakGame pg = new PeakGame();
		
		games = new Vector<Game>();
		
		GameField car = new GameField("Car", pg.getCarField());
		GameField cookie = new GameField("Cookie", COOKIE);
		GameField fullRandom = new GameField("Full Random", pg.getRandomField(9));
		GameField test = new GameField("Test", TEST);
		
		Ranklist carRanklist = new Ranklist("CarRanklist", 3);
		Ranklist cookieRanklist = new Ranklist("CookieRanklist", 3);
		Ranklist fullRandomRanklist = new Ranklist("Full RandomRanklist", 3);
		Ranklist testRanklist = new Ranklist("TestRanklist", 3);
		
		games.add(new Game(car, carRanklist));
		games.add(new Game(cookie, cookieRanklist));
		games.add(new Game(fullRandom, fullRandomRanklist));
		games.add(new Game(test, testRanklist));

		boolean restart = true;
		while(restart) {
			GameLogic logic = new GameLogic(1);
			OutputGerman view = new OutputGerman(logic);
			GameController game = new GameController("GameController", logic, view, games);
			game.start();
			restart = game.playerWantsRestart();				
		}
		
	}
	
	//Alternative Games
	
	private static final int[][] TEST = {
			{1, 0},
			{0, 1}};
	
	
	private static final int[][] CAR = {
			{0, 0, 0, 0},
			{0, 1, 1, 1},
			{1, 1, 1, 1},
			{1, 0, 0, 1}};
	
	private int[][] getCarField() {
		return CAR;
	}
	
	private static final int[][] COOKIE = {
			{1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 1, 0, 0, 1},
			{1, 0, 1, 1, 1, 0, 1},
			{1, 1, 1, 1, 1, 1, 1},
			{1, 0, 1, 1, 1, 0, 1},
			{1, 0, 0, 1, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1}};
	
	private int[][] getRandomField(int size) {
		int[][] randomField = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				randomField[i][j] = getRandomFill();
			}
		}
		return randomField;
	}
	
	//Methods
	public static int getRandomFill() {
		int i = Math.random() > 0.5 ? 1 : 0;
		return i;
	}
}

