package game;

import java.util.Vector;

import output.OutputGerman;

public class PeakGame {
	
	public static Vector<GameField> games;

	public static void main(String[] args) {
		PeakGame pg = new PeakGame();
		
		games = new Vector<GameField>();
		
		GameField full_random = new GameField("Full Random", pg.getRandomField(9));
		GameField car = new GameField("Car", pg.getCarField());
		GameField cookie = new GameField("Cookie", COOKIE);
		
		games.add(car);
		games.add(cookie);
		games.add(full_random);
		
		GameLogic logic = new GameLogic(1);
		OutputGerman view = new OutputGerman(logic);
		GameController game = new GameController("GameController", logic, view, games);
		game.start();
	}
	
	//Alternative Games
	
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

