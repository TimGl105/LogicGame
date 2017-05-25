package game;

public class Game {
	
	private GameField gamefield;
	private Ranklist ranklist;
	
	public Game(GameField gamefield, Ranklist ranklist) {
		this.gamefield = gamefield;
		this.ranklist = ranklist;
	}
	
	public GameField getGamefield() {
		return gamefield;
	}
	
	public void setGamefield(GameField gamefield) {
		this.gamefield = gamefield;
	}
	
	public Ranklist getRanklist() {
		return ranklist;
	}
	
	public void setRanklist(Ranklist ranklist) {
		this.ranklist = ranklist;
	}
	

}
