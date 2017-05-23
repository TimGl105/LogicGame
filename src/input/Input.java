package input;

import java.io.InputStream;
import java.util.Scanner;

public class Input {

	private static Input instance = null;
	private Scanner scanner;
	
	protected Input (InputStream stream) {}
	
	public Input getInstance(InputStream stream) {
		if (instance == null) {
			scanner = new Scanner(stream); 
		}
		return instance;
	}
	
	public int getGameOption(int options) {
		int i = -1;
		if (scanner.hasNextInt()) {
			i = scanner.nextInt() - 1;
			if (i <= 0 || i > options - 1) {
				i = -1;
			}
		}
		scanner.nextLine();
		return i;
	}
}
