package output;

import java.util.ResourceBundle;
import java.util.Vector;

import game.Game;
import game.GameLogic;
import game.Ranklist;

public abstract class Output extends ResourceBundle {

	protected GameLogic logic;
	
	protected final int FILLED;
	protected final int UNFILLED;
	protected final int RESET;
	private final int CHAR_TO_INT_OFFSET = 65;
	public final static int ERROR_IN_COLUMN = -1;
	public final static int ERROR_IN_ROW = -2;
	public final static int ERROR_IN_SYMBOL = -3;
	
	public Output(GameLogic logic) {
		this.logic = logic;
		this.FILLED = logic.getConstantForFilled();
		this.UNFILLED = logic.getConstantForUnfilled();
		this.RESET = logic.getConstantForReset();
	}
	
	public abstract void displayGameRules();
	
	public abstract void displayGameOptions(Vector<Game> games);

	public void displayField(int[][] field, int innerSize, int completeSize) {
		System.out.print("    ");
		for(int row = 0; row < innerSize; row++) {
			System.out.print((char) (row + CHAR_TO_INT_OFFSET) + " ");
		}
		System.out.println();
		for(int i = 0; i < completeSize; i++) {
			for(int j = 0; j < completeSize; j++) {
				String outputTmp;
				if (j == 0 && i < innerSize) System.out.print((i + 1) + ". ");
				else if (j == 0) System.out.print("   ");
				if (field[i][j] == UNFILLED) outputTmp = "*";
				else if (field[i][j] == FILLED) outputTmp = "X";
				else if (field[i][j] == RESET) outputTmp = " ";
				else if (field[i][j] == 0) outputTmp = " "; 
				else outputTmp = ((Integer) field[i][j]).toString();
				System.out.print("|" + outputTmp);
			}
			System.out.println("|");
		}
	}
	
	public abstract void displayWrongGameInputMessage();
	
	public abstract void displayFieldInputRequest();
	
	public abstract void displayWrongInputLength();

	public abstract void displayWrongInputMessage(char wrongInput, int error);
	/*
	public abstract void displayWrongColumnInputMessage(char wrongInput);
	
	public abstract void displayWrongRowInputMessage(char wrongInput);

	public abstract void displayWrongSymbolInputMessage(char wrongInput);
	*/
	public abstract void displayElapsedTime(double time);
	
	public abstract void displayCongratulations();
	
	public void displayHighscoresBeforeNewEntry(Ranklist ranklist, int newEntry) {
		for (int i = 1; i <= ranklist.getRankCount(); i++) {
			if (i == newEntry) {
				System.out.println(i + ".");
			} else {
				System.out.println(i + ".\t" + ranklist.getName(i) + "\t" + ranklist.getTime(i));		
			}
		}
	}
	
	public abstract void displayInvalidNameMessage();
	
	public void displayHighscoresAfterNewEntry(Ranklist ranklist) {
		for (int i = 1; i <= ranklist.getRankCount(); i++) {
			System.out.println(i + ".\t" + ranklist.getName(i) + "\t" + ranklist.getTime(i));		
		}
	}
	
	public abstract void displayNameInputMessage();

	public abstract void displayRestartOption();

	public abstract void displayGameRestart();
	
	public abstract void displayGameEnd();

}
