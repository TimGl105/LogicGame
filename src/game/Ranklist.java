package game;

import java.util.Vector;

public class Ranklist {

	String gameName;
	Vector<Double> times;
	Vector<String> names;
	int rankCount;
	int capacity;
	
	public Ranklist(String gameName, int winnerCount) {
		this.gameName = gameName;
		this.rankCount = winnerCount;
		this.times = new Vector<Double>(winnerCount);
		this.names = new Vector<String>(winnerCount);
	}
	
	private boolean isValidIndexAccess(int index) {
		return (index >= 0 && index < capacity && index < rankCount);
	}
	
	/**
	 * 
	 * @param rank
	 * @return time of rank in sec or -1 if rank was invalid
	 */
	public double getTime(int rank) {
		if (isValidIndexAccess(castRankToIndex(rank))) {
			return times.get(castRankToIndex(rank));
		} else {
			return -1.0;
		}
	}
	
	private void insertTime(int index, double time) {
		times.insertElementAt(time, index);
	}
	
	/**
	 * 
	 * @param rank
	 * @return name of index or "---" if index was invalid
	 */
	public String getName(int rank) {
		if (isValidIndexAccess(castRankToIndex(rank))) {
			return names.get(castRankToIndex(rank));			
		} else {
			return "---";
		}
	}
	
	/**
	 * 
	 * @param rank
	 * @param name
	 */
	public void setName(int rank, String name) {
		names.set(castRankToIndex(rank), name);
	}
	
	/**
	 * Creates new entry at given index with default as name.
	 * @param index index
	 */
	private void insertEntry(int index) {
		names.insertElementAt("default", index);
	}
	
	public int getCapacity() {
		return capacity;
	}

	public int getRankCount() {
		return rankCount;
	}
	
	/**
	 * Returns the rank of the given time.
	 * @param time winners value
	 * @return winner rank (1 is the highest rank, rankCount the lowest)
	 */
	public int getRank(double time) {
		int i = (times.size() < rankCount) ? times.size() : rankCount;
		for (; i >= 1; i--) {
			if (time >= times.get(i-1)) {
				return i+1;
			}
		}
		return 1;
	}
	
	/**
	 * 
	 * @param rank
	 * @param time
	 */
	public void setWinnerEntry(int rank, double time) {
		insertTime(castRankToIndex(rank), time);
		insertEntry(castRankToIndex(rank));
		if (capacity < rankCount) capacity++;
		if (capacity > rankCount) times.setSize(rankCount);
	}
	
	private int castRankToIndex(int rank) {
		return --rank;
	}
}
