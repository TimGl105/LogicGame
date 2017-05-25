package input;

import java.io.InputStream;
import java.util.Scanner;

import output.Output;

public class Input {

	private static Input instance = null;
	private Scanner scanner;
	private Output view;
	
	private final static int CHAR_TO_INT_OFFSET_ROW = 49;
	private final static int CHAR_TO_INT_OFFSET_COLUMN = 65;
	
	public Input (InputStream stream, Output view) {
		if (instance == null) {
			scanner = new Scanner(stream);
			this.view = view;
		}		
	}
	
	public int getGameDecision(int options) {
		int i = -1;
		if (scanner.hasNextInt()) {
			i = scanner.nextInt() - 1;
			if (i < 0 || i > options - 1) {
				i = -1;
			}
		}
		scanner.nextLine();
		return i;
	}
	
	public char[] getNextField(int gameSize ) {
		String s = (scanner.hasNextLine()) ? scanner.nextLine() : "";

		while (true) {
			while (s.length() != 3) {
				view.displayWrongInputLength();
				s = (scanner.hasNextLine()) ? scanner.nextLine() : "";
			}
			char[] tmp = s.toCharArray();
			tmp[0] = Character.toUpperCase(tmp[0]);
			tmp[2] = Character.toUpperCase(tmp[2]);

			if ((int) tmp[0] < CHAR_TO_INT_OFFSET_COLUMN
					|| (int) tmp[0] >= gameSize + CHAR_TO_INT_OFFSET_COLUMN) {
				view.displayWrongInputMessage(tmp[0], Output.ERROR_IN_COLUMN);
			} else if ((int) tmp[1] < CHAR_TO_INT_OFFSET_ROW
					|| (int) tmp[1] >= gameSize + CHAR_TO_INT_OFFSET_ROW) {
				view.displayWrongInputMessage(tmp[1], Output.ERROR_IN_ROW);
			} else if (!((tmp[2] == 'X') || (tmp[2] == '*') || (tmp[2] == '~'))) {
				view.displayWrongInputMessage(tmp[2], Output.ERROR_IN_SYMBOL);
			} else {
				return tmp;
			}
			s = (scanner.hasNextLine()) ? scanner.nextLine() : "";
		}
	}
	
	public String getName() {
		String s = (scanner.hasNextLine()) ? scanner.nextLine() : "";
		while (s.length() <= 0 || s.length() > 16) {
			view.displayInvalidNameMessage();
			s = (scanner.hasNextLine()) ? scanner.nextLine() : "";
		}
		return s;
	}
	
	public boolean getRestartDecision() {
		Scanner scanner = new Scanner(System.in);
		String s = (scanner.hasNextLine()) ? scanner.nextLine() : "";
		
		boolean b = (s.equals("Ja") || s.equals("ja"));
		if (b) {
			view.displayGameRestart();
		} else {
			view.displayGameEnd();
		}
		return b;
	}
}
