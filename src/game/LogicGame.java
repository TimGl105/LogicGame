package game;

import java.util.Vector;

import output.Output_de;

public class LogicGame {
	
	private static Vector<Game> games;

	public static void main(String[] args) {
		LogicGame pg = new LogicGame();
		
		games = new Vector<Game>();
		
		GameField test = new GameField("Test", TEST);
		GameField test2 = new GameField("Test2", TEST2);
		GameField car = new GameField("Car", pg.getCarField());
		GameField cookie = new GameField("Cookie", COOKIE);
		GameField fullRandom = new GameField("Full Random", pg.getRandomField(9));
		
		Ranklist testRanklist = new Ranklist("TestRanklist", 3);
		Ranklist test2Ranklist = new Ranklist("Test2Ranklist", 3);
		Ranklist carRanklist = new Ranklist("CarRanklist", 3);
		Ranklist cookieRanklist = new Ranklist("CookieRanklist", 3);
		Ranklist fullRandomRanklist = new Ranklist("Full RandomRanklist", 3);
		
		games.add(new Game(test, testRanklist));
		games.add(new Game(test2, test2Ranklist));
		games.add(new Game(car, carRanklist));
		games.add(new Game(cookie, cookieRanklist));
		games.add(new Game(fullRandom, fullRandomRanklist));

		boolean restart = true;
		while(restart) {
			GameLogic logic = new GameLogic(1);
			Output_de view = new Output_de(logic);
			GameController game = new GameController("GameController", logic, view, games);
			game.start();
			restart = game.playerWantsRestart();				
		}
		
	}
	
	//Alternative Games
	
	private static final int[][] TEST = {{1}};
	
	private static final int[][] TEST2 = {
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

