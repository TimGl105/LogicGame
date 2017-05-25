package output;

import java.util.Enumeration;
import java.util.Vector;

import game.Game;
import game.GameLogic;

public class Output_de extends Output {	

	public Output_de(GameLogic logic) {
		super(logic);
	}

	@Override
	public Enumeration<String> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object handleGetObject(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void displayGameRules() {
		System.out.println("Die Regeln sind einfach: links oben beginnend befindet sich ein quadratisches Spielfeld.\n"
				+ "Au�erhalb davon befinden sich rechts und unterhalb des Spielfeldes Hinweise, wieviele aufeinanderfolgende\n"
				+ "Felder in welcher Reihenfolge gef�llt sind. Die Hinweise rechts geben Aufschluss auf die jeweilige Zeile\n"
				+ "und die unterhalb auf die jeweilige Spalte.\n"
				+ "1 und 2 am rechten Rand bedeuten zum Beispiel, dass von links nach rechts 1 einzelnes Feld gef�llt ist\n"
				+ "und weiter rechts davon zwei auffeinanderfolgende Felder. Davor und dazwischen befinden sich beliebiggro�e Freir�ume.\n\n"
				+ "Aufgabe:\n F�lle das gesamte Spielfeld, ein \"X\" markiert ein ausgef�lltes Feld, ein \"*\" ein freies Feld.\n "
				+ "Die Spalten werden in Buchstaben von A-I und die Zeilen von 1-9 aufgez�hlt. Ein markiertes Feld kann mit \"~\"\n "
				+ "wieder entmarkiert werden.\n\n"
				+ "Beispiele:\n "
				+ "Das linke obere Feld wird also als gef�lltes Feld mit A1X markiert.\n "
				+ "Ein freies Feld wird zum Beispiel mit G7* deklariert.\n "
				+ "Mit G7~ wird die *-Markierung wieder entfernt.\n\n"
				+ "Viel Spa� beim Spielen.\n");
	}
	
	@Override
	public void displayGameOptions(Vector<Game> games) {
		System.out.println("W�hle das Spielfeld, das du spielen m�chtest. Gebe seine Nummer an.");
		for (int i = 0; i < games.size(); i++) {
			System.out.print("(" + (i + 1) + ") " + games.get(i).getGamefield().getName() + "  ");
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
	
	/*
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
	*/
	
	@Override
	public void displayElapsedTime(double time) {
		System.out.println("Du hast " + (int) time/60 + " Minuten und " + (int) time%60 + " Sekunden gebraucht.");
	}
	
	@Override
	public void displayCongratulations() {
		System.out.println("Gl�ckwunsch. Du hast das Spiel gel�st!");
	}

	@Override
	public void displayNameInputMessage() {
		System.out.println("Bitte gib deinen Namen f�r die Rangliste ein.");
	}

	@Override
	public void displayInvalidNameMessage() {
		System.out.println("Der Name ist leer oder zu betr�gt mehr als 16 Zeichen. Bitte gib einen anderen Namen ein.");
	}
	
	@Override
	public void displayRestartOption() {
		System.out.println("Wenn du noch ein Spiel spielen willst, gib \"Ja\" ein.");
	}
	
	@Override
	public void displayGameRestart() {
		System.out.println("Du hast ein neues Spiel gestartet.\n");
	}
	
	@Override
	public void displayGameEnd() {
		System.out.println("Das Spiel wurde beendet.");
	}

}
