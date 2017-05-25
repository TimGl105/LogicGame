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
				+ "Außerhalb davon befinden sich rechts und unterhalb des Spielfeldes Hinweise, wieviele aufeinanderfolgende\n"
				+ "Felder in welcher Reihenfolge gefüllt sind. Die Hinweise rechts geben Aufschluss auf die jeweilige Zeile\n"
				+ "und die unterhalb auf die jeweilige Spalte.\n"
				+ "1 und 2 am rechten Rand bedeuten zum Beispiel, dass von links nach rechts 1 einzelnes Feld gefüllt ist\n"
				+ "und weiter rechts davon zwei auffeinanderfolgende Felder. Davor und dazwischen befinden sich beliebiggroße Freiräume.\n\n"
				+ "Aufgabe:\n Fülle das gesamte Spielfeld, ein \"X\" markiert ein ausgefülltes Feld, ein \"*\" ein freies Feld.\n "
				+ "Die Spalten werden in Buchstaben von A-I und die Zeilen von 1-9 aufgezählt. Ein markiertes Feld kann mit \"~\"\n "
				+ "wieder entmarkiert werden.\n\n"
				+ "Beispiele:\n "
				+ "Das linke obere Feld wird also als gefülltes Feld mit A1X markiert.\n "
				+ "Ein freies Feld wird zum Beispiel mit G7* deklariert.\n "
				+ "Mit G7~ wird die *-Markierung wieder entfernt.\n\n"
				+ "Viel Spaß beim Spielen.\n");
	}
	
	@Override
	public void displayGameOptions(Vector<Game> games) {
		System.out.println("Wähle das Spielfeld, das du spielen möchtest. Gebe seine Nummer an.");
		for (int i = 0; i < games.size(); i++) {
			System.out.print("(" + (i + 1) + ") " + games.get(i).getGamefield().getName() + "  ");
		}
	}
	
	@Override
	public void displayWrongGameInputMessage() {
		System.out.println("Die eingegebene Zahl des gewünschten Spielfelds ist nicht gültig, "
				+ "bitte wähle eine gültige und bestätige mit Enter.");
	}
	
	@Override
	public void displayFieldInputRequest() {
		System.out.println("Spalte Reihe Zeichen: X/*");
	}
	
	@Override
	public void displayWrongInputLength() {
		System.out.println("Die Anzahl der eingegeben Werte ist ungültig. Bitte gib die Werte erneut ein.");
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
		System.out.println(wrongInput + " ist als " + errorCase + " ungültig. Bitte gib die Werte erneut ein.");
	}
	
	/*
	@Override
	public void displayWrongColumnInputMessage(char wrongInput) {
		System.out.println(wrongInput + " ist als Spaltenwert ungültig. Bitte gib die Werte erneut ein.");
	}
	
	@Override
	public void displayWrongRowInputMessage(char wrongInput) {
		System.out.println(wrongInput + " ist als Zeilenwert ungültig. Bitte gib die Werte erneut ein.");
	}

	@Override
	public void displayWrongSymbolInputMessage(char wrongInput) {
		System.out.println(wrongInput + " ist als Symbol ungültig. Bitte gib die Werte erneut ein.");
	}
	*/
	
	@Override
	public void displayElapsedTime(double time) {
		System.out.println("Du hast " + (int) time/60 + " Minuten und " + (int) time%60 + " Sekunden gebraucht.");
	}
	
	@Override
	public void displayCongratulations() {
		System.out.println("Glückwunsch. Du hast das Spiel gelöst!");
	}

	@Override
	public void displayNameInputMessage() {
		System.out.println("Bitte gib deinen Namen für die Rangliste ein.");
	}

	@Override
	public void displayInvalidNameMessage() {
		System.out.println("Der Name ist leer oder zu beträgt mehr als 16 Zeichen. Bitte gib einen anderen Namen ein.");
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
