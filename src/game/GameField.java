package game;

public class GameField {
	
	private String name;
	private int[][] field;
	
	public GameField(String name, int[][] field) {
		this.name = name;
		this.field = field;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int[][] getField() {
		return field;
	}
	
	public void setField(int[][] field) {
		this.field = field;
	}
}
