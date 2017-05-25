package game;

public class GameLogic {

	private final static int FILLED = -2;
	private final static int UNFILLED = -1;
	private final static int RESET = -3;
	
	/**
	 * The indicator for filled by the input-field.
	 */
	private final int FILLED_GF;
	
	private int gameSize;
	private int[][] gameField;
	
	private int outerFieldLength;
	private int completeGameSize;
	private int[][] completeField;
	
	public GameLogic(int filled) {
		this.FILLED_GF = filled;
	}
	
	public int getConstantForFilled() {
		return FILLED;
	}
	
	public int getConstantForUnfilled() {
		return UNFILLED;
	}
	
	public int getConstantForReset() {
		return RESET;
	}
	
	/**
	 * Sets the inner gamefield.
	 * @param field
	 */
	public void setGameField(int[][] field) {
		this.gameField = field;
		this.gameSize = field.length;
		setCompleteGameField();
	}
	
	public void setCompleteGameField() {
		outerFieldLength = (gameSize + 1) / 2;
		completeGameSize = gameSize + outerFieldLength; 
		completeField = new int[completeGameSize][completeGameSize];
		rowHintField(); 		//Has to be run first, before columnHintField()
		columnHintField();
	}
	
	/**
	 * Returns the full gamefield.
	 * @return
	 */
	public int[][] getCompleteGameField() {
		return this.completeField;
	}
	
	/**
	 * Returns size of the inner gamefield.
	 * @return gameSize
	 */
	public int getGameSize() {
		return gameSize;
	}
	
	/**
	 * Returns size of the complete gamefield.
	 * @return completeGameSize
	 */
	public int getCompleteGameSize() {
		return completeGameSize;
	}
	
	/**
	 * Sets Size of the inner gamefield.
	 * @param gameSize
	 */
	public void setGameSize(int gameSize) {
		this.gameSize = gameSize;
	}
	
	public boolean gameIsFinished() {
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				if (completeField[i][j] != FILLED && gameField[i][j] == FILLED) {
					return false;
				} else if (completeField[i][j] == FILLED && gameField[i][j] != FILLED) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Calculates the hints for each row on the right, outside of the gamefield.
	 * Also changes indicator for filled by the given field to the equalized indicator in each field.
	 */
	void rowHintField() {
		
		for (int i = 0; i < gameSize; i++) {
			int run = 0;
			int tmp = 0;
			
			for (int j = 0; j < gameSize; j++) {
				if (gameField[i][j] == FILLED_GF) {
					tmp++;
					gameField[i][j] = FILLED;
				} else {
					gameField[i][j] = RESET;
					completeField[i][gameSize + run] = tmp; 
					if (tmp != 0) run++;
					tmp = 0;
				}
				if (tmp != 0) completeField[i][gameSize + run] = tmp;
			}
		}
	}
	
	/**
	 * Calculates the hints for each column on the bottom, outside of the gamefield.
	 */
	void columnHintField() {
		
		for (int i = 0; i < gameSize; i++) {
			int run = 0;
			int tmp = 0;
			
			for (int j = 0; j < gameSize; j++) {
				if (gameField[j][i] == FILLED) {
					tmp++;
				} else { 
					completeField[gameSize + run][i] = tmp; 
					if (tmp != 0) run++;
					tmp = 0;
				}
				if (tmp != 0) completeField[gameSize + run][i] = tmp;
			}
		}
	}
	
	void setSingleField(int row, int column, char symbol) {
		if (row >= 0 && row < gameSize
				&& column >= 0 && column < gameSize) {
			if (symbol == 'X') completeField[row][column] = FILLED;
			else if (symbol == '*') completeField[row][column] = UNFILLED;
			else if (symbol == '~') completeField[row][column] = RESET;
		}
	}
}
