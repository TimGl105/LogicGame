package output;

import game.GameLogic;

public abstract class Output {

	protected GameLogic logic;
	
	protected final int FILLED;
	protected final int UNFILLED;

	public Output(GameLogic logic) {
		this.logic = logic;
		FILLED = logic.getConstantForFilled();
		UNFILLED = logic.getConstantForUnfilled();
	}
	
	public abstract void displayGameRules();

	public void displayField(int[][] field, int size) {
		for(int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				String outputTmp;
				if (field[i][j] == UNFILLED) outputTmp = "*";
				else if (field[i][j] == FILLED) outputTmp = "X";
				else if (field[i][j] == 0) outputTmp = " "; 
				else outputTmp = ((Integer) field[i][j]).toString();
				System.out.print("|" + outputTmp);
			}
			System.out.println("|");
		}
	}
	
	public abstract void displayElapsedTime(double time);
	
	public abstract void displayCongratulations();
	
}
