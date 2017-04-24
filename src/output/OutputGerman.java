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
				+ "ein quadratisches Spielfeld. Au�erhalb davon befinden sich rechts und unterhalb\n"
				+ "des Spielfeldes Hinweise, wieviele aufeinanderfolgende Felder gef�llt sind.\n"
				+ "Die Hinweise rechts geben Aufschluss auf die jeweilige Zeile und die unterhalb\n"
				+ "auf die jeweilige Spalte.\n"
				+ "1 und 2 bedeutet zum Beispiel, dass von links nach rechts 1 einzelnes Feld gef�llt ist\n"
				+ "und weiter rechts davon zwei auffeinanderfolgende Felder gef�llt sind. Davor und\n"
				+ "dazwischen befinden sich beliebiggro�e Freir�ume.\n"
				+ "Aufgabe:\n F�lle das gesamte Spielfeld, ein \"X\" steht f�r ein ausgef�lltes Feld, ein\n"
				+ "\"*\" f�r ein freies Feld. Die Spalten werden in Buchstaben von A-J und die Zeilen\n"
				+ "von 1-9 aufgez�hlt.\n"
				+ "Das linke obere Feld wird also als gef�lltes Feld mit A1X deklariert. Ein freies Feld\n"
				+ "wird zum Beispiel mit G7* deklariert.\n"
				+ "Viel Spa� beim Spielen.\n");
	}
	
	public void displayGameOptions(Vector<GameField> games) {
		System.out.println("W�hle das Spielfeld, das du spielen m�chtest. Gebe seine Nummer an.");
		for (int i = 0; i < games.size(); i++) {
			System.out.print((i + 1) + " " + games.get(i).getName() + "  ");
		}
	}
	
	public void displayElapsedTime(double time) {
		System.out.println("Du hast " + time + " Sekunden gebraucht.");
	}
	
	public void displayCongratulations() {
		System.out.println("Gl�ckwunsch. Du hast das Spiel gel�st!");
	}
}
