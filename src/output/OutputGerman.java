package output;

import java.util.Vector;

import game.GameField;
import game.GameLogic;

public class OutputGerman extends Output {	

	public OutputGerman(GameLogic logic) {
		super(logic);
	}

	@Override
	public void displayGameRules() {
		System.out.println("Die Regeln sind einfach: links oben beginnend befindet sich ein quadratisches Spielfeld.\n"
				+ "Au�erhalb davon befinden sich rechts und unterhalb des Spielfeldes Hinweise, wieviele aufeinanderfolgende\n"
				+ "Felder in welcher Reihenfolge gef�llt sind. Die Hinweise rechts geben Aufschluss auf die jeweilige Zeile\n"
				+ "und die unterhalb auf die jeweilige Spalte.\n"
				+ "1 und 2 am rechten Rand bedeuten zum Beispiel, dass von links nach rechts 1 einzelnes Feld gef�llt ist\n"
				+ "und weiter rechts davon zwei auffeinanderfolgende Felder. Davor und dazwischen befinden sich beliebiggro�e Freir�ume.\n"
				+ "Aufgabe:\n F�lle das gesamte Spielfeld, ein \"X\" markiert ein ausgef�lltes Feld, ein \"*\" ein freies Feld.\n"
				+ "Die Spalten werden in Buchstaben von A-I und die Zeilen von 1-9 aufgez�hlt. Ein markiertes Feld kann mit \"~\"\n"
				+ "wieder entmarkiert werden."
				+ "Beispiele:\n"
				+ "Das linke obere Feld wird also als gef�lltes Feld mit A1X markiert.\n"
				+ "Ein freies Feld wird zum Beispiel mit G7* deklariert.\n"
				+ "Mit G7~ wird die *-Markierung wieder entfernt.\n"
				+ "\nViel Spa� beim Spielen.\n");
	}
	
	@Override
	public void displayGameOptions(Vector<GameField> games) {
		System.out.println("W�hle das Spielfeld, das du spielen m�chtest. Gebe seine Nummer an.");
		for (int i = 0; i < games.size(); i++) {
			System.out.print((i + 1) + " " + games.get(i).getName() + "  ");
		}
	}
	
	@Override
	public void displayWrongGameInputMessage() {
		System.out.println("Die eingegebene Zahl des gew�nschten Spielfelds ist nicht g�ltig, "
				+ "bitte w�hle eine g�ltige und best�tige mit Enter.");
	}
	
	@Override
	public void displayFieldInputRequest() {
		System.out.println("Spalte Reihe Zeichen: X/*");
	}
	
	@Override
	public void displayWrongInputLength() {
		System.out.println("Die Anzahl der eingegeben Werte ist ung�ltig. Bitte gib die Werte erneut ein.");
	}

	@Override
	public void displayWrongInputMessage(char wrongInput, int error) {
		String errorCase = "";
		switch (error) {
		case ERROR_IN_COLUMN: errorCase = "Spaltenwert"; break;
		case ERROR_IN_ROW: errorCase = "Zeilenwert"; break;
		case ERROR_IN_SYMBOL: errorCase = "Symbol"; break;
		default: errorCase = "???";
		}
		System.out.println(wrongInput + " ist als " + errorCase + " ung�ltig. Bitte gib die Werte erneut ein.");
	}
	
	@Override
	public void displayWrongColumnInputMessage(char wrongInput) {
		System.out.println(wrongInput + " ist als Spaltenwert ung�ltig. Bitte gib die Werte erneut ein.");
	}
	
	@Override
	public void displayWrongRowInputMessage(char wrongInput) {
		System.out.println(wrongInput + " ist als Zeilenwert ung�ltig. Bitte gib die Werte erneut ein.");
	}

	@Override
	public void displayWrongSymbolInputMessage(char wrongInput) {
		System.out.println(wrongInput + " ist als Symbol ung�ltig. Bitte gib die Werte erneut ein.");
	}
	
	@Override
	public void displayElapsedTime(double time) {
		System.out.println("Du hast " + time + " Sekunden gebraucht.");
	}
	
	@Override
	public void displayCongratulations() {
		System.out.println("Gl�ckwunsch. Du hast das Spiel gel�st!");
	}

}
