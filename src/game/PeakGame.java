package game;

import java.util.Vector;

import output.OutputGerman;

public class PeakGame {
	
	public static Vector<GameField> games;

	public static void main(String[] args) {
		games = new Vector<GameField>();
		GameField car = new GameField("Car", CAR);
		GameField cookie = new GameField("Cookie", COOKIE);
		GameField full_random = new GameField("Full Random", FULL_RANDOM);
		games.add(car);
		games.add(cookie);
		games.add(full_random);
		GameLogic logic = new GameLogic(1);
		OutputGerman view = new OutputGerman(logic);
		GameController game = new GameController(logic, view, games);
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
	
	public static final int[][] FULL_RANDOM = {
			{getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill()},
			{getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill()},
			{getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill()},
			{getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill()},
			{getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill()},
			{getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill()},
			{getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill()},
			{getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill()},
			{getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill(), getRandomFill()}};
	
	//Methods
	public static int getRandomFill() {
		int i = Math.random() > 0.5 ? 1 : 0;
		return i;
	}
}

