package output;

import java.util.Vector;

import game.GameField;
import game.GameLogic;

public class OutputGerman extends Output {	

	public OutputGerman(GameLogic logic) {
		super(logic);
	}

	public void displayGameRules() {
		System.out.println("Die Regeln sind einfach: links oben beginnend befindet sich\n"
				+ "ein quadratisches Spielfeld. Außerhalb davon befinden sich rechts und unterhalb\n"
				+ "des Spielfeldes Hinweise, wieviele aufeinanderfolgende Felder gefüllt sind.\n"
				+ "Die Hinweise rechts geben Aufschluss auf die jeweilige Zeile und die unterhalb\n"
				+ "auf die jeweilige Spalte.\n"
				+ "1 und 2 bedeutet zum Beispiel, dass von links nach rechts 1 einzelnes Feld gefüllt ist\n"
				+ "und weiter rechts davon zwei auffeinanderfolgende Felder gefüllt sind. Davor und\n"
				+ "dazwischen befinden sich beliebiggroße Freiräume.\n"
				+ "Aufgabe:\n Fülle das gesamte Spielfeld, ein \"X\" steht für ein ausgefülltes Feld, ein\n"
				+ "\"*\" für ein freies Feld. Die Spalten werden in Buchstaben von A-J und die Zeilen\n"
				+ "von 1-9 aufgezählt.\n"
				+ "Das linke obere Feld wird also als gefülltes Feld mit A1X deklariert. Ein freies Feld\n"
				+ "wird zum Beispiel mit G7* deklariert.\n"
				+ "Viel Spaß beim Spielen.\n");
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
