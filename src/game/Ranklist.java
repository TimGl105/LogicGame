package game;

import java.util.Vector;

public class Ranklist {

	String gameName;
	Vector<Double> times;
	Vector<String> names;
	int winnerCount;
	int capacity;
	
	public Ranklist(String gameName, int winnerCount) {
		this.gameName = gameName;
		this.winnerCount = winnerCount;
		this.times = new Vector<Double>(winnerCount);
		this.names = new Vector<String>(winnerCount);
	}
	
	private boolean isValidIndexAccess(int index) {
		return (index >= 0 && index <= winnerCount && index <= capacity - 1);
	}
	
//	private boolean isValidIndexWriteAccess(int index) {
//		return (index >= 0 && index <= winnerCount && winnerCount < times.size());
//	}
	
	/**
	 * 
	 * @param index
	 * @return time of index in sec or -1 if index was invalid
	 */
	public double getTime(int index) {
		if (isValidIndexAccess(index)) {
			return times.get(index);
		} else {
			return -1.0;
		}
	}
	
	public void insertTime(int index, double time) {
		times.insertElementAt(time, index);
	}
	
	/**
	 * 
	 * @param index
	 * @return name of index or "---" if index was invalid
	 */
	public String getName(int index) {
		if (isValidIndexAccess(index)) {
			return names.get(index);			
		} else {
			return "---";
		}
	}
	
	public void insertName(int index, String name) {
		names.insertElementAt(name, index);
	}
	
	public int getWinnerCount() {
		return winnerCount;
	}

	/**
	 * Validates the rank of the given winners value.
	 * @param time winners value
	 * @return winner rank
	 */
	public int validateWinner(double time) {
		int i = (winnerCount > times.size()) ? times.size() - 1 : winnerCount - 1;
		for (; i >= 0; i--) {
			if (time > times.get(i)) {
				return i++;
			}
		}
		return 0;
	}

	public void setWinnerEntry(int index, String name, double time) {
		insertTime(index, time);
		insertName(index, name);
		if (capacity < winnerCount) capacity++;
		times.setSize(winnerCount);
	}
}
