package br.edu.univas.vo;

public class HitsNumbers implements Comparable<HitsNumbers> {
	
	private String ruffleID;
	private int ruffleNumber;
	
	public String getRuffleID() {
		return ruffleID;
	}
	
	public void setRuffleID(String ruffleID) {
		this.ruffleID = ruffleID;
	}
	
	public int getRuffleNumbers() {
		return ruffleNumber;
	}
	
	public void setRuffleNumber(int ruffleNumber) {
		this.ruffleNumber = ruffleNumber;
	}
	
	@Override
	public String toString() {
		return getRuffleID() + " ";
	}

	@Override
	public int compareTo(HitsNumbers ruffleNumber) {
		return (ruffleNumber.getRuffleNumbers() - this.ruffleNumber);
	}	
}