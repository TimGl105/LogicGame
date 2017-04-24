package output;

import java.util.Vector;

import game.GameField;
import game.GameLogic;

public class OutputGerman extends Output {	

	public OutputGerman(GameLogic logic) {
		super(logic);
	}

	public void displayGameRules() {
		System.out.println("Die Regeln sind einfach: links oben beginnend befindet sich ein quadratisches Spielfeld.\n"
				+ "Außerhalb davon befinden sich rechts und unterhalb des Spielfeldes Hinweise, wieviele aufeinanderfolgende\n"
				+ "Felder in welcher Reihenfolge gefüllt sind. Die Hinweise rechts geben Aufschluss auf die jeweilige Zeile\n"
				+ "und die unterhalb auf die jeweilige Spalte.\n"
				+ "1 und 2 am rechten Rand bedeuten zum Beispiel, dass von links nach rechts 1 einzelnes Feld gefüllt ist\n"
				+ "und weiter rechts davon zwei auffeinanderfolgende Felder. Davor und dazwischen befinden sich beliebiggroße Freiräume.\n"
				+ "Aufgabe:\n Fülle das gesamte Spielfeld, ein \"X\" markiert ein ausgefülltes Feld, ein \"*\" ein freies Feld.\n"
				+ "Die Spalten werden in Buchstaben von A-I und die Zeilen von 1-9 aufgezählt. Ein markiertes Feld kann mit \"~\"\n"
				+ "wieder entmarkiert werden."
				+ "Beispiele:\n"
				+ "Das linke obere Feld wird also als gefülltes Feld mit A1X markiert.\n"
				+ "Ein freies Feld wird zum Beispiel mit G7* deklariert.\n"
				+ "Mit G7~ wird die *-Markierung wieder entfernt.\n"
				+ "\nViel Spaß beim Spielen.\n");
	}
	
	public void displayGameOptions(Vector<GameField> games) {
		System.out.println("Wähle das Spielfeld, das du spielen möchtest. Gebe seine Nummer an.");
		for (int i = 0; i < games.size(); i++) {
			System.out.print((i + 1) + " " + games.get(i).getName() + "  ");
		}
	}
	
	public void displayElapsedTime(double time) {
		System.out.println("Du hast " + time + " Sekunden gebraucht.");
	}
	
	public void displayCongratulations() {
		System.out.println("Glückwunsch. Du hast das Spiel gelöst!");
	}
}
