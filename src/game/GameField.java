package game;

public class GameField {
	
	private int[][] field;
	
	public GameField(int size) {
		this.field = new int[size][size];
	}
	
	public int getEntry(int row, int column) {
		return this.field[row][column];
	}

	public void setEntry(int row, int column, int value) {
		this.field[row][column] = value;
	}
	
	public int getLength() {
		return this.field.length;
	}
}
