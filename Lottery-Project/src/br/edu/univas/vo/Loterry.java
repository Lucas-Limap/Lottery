package br.edu.univas.vo;

import java.util.ArrayList;
import java.util.List;

public abstract class Loterry {
	
	private String selectedNumbers;
	private String contNumber;
	private String IDRuffle;
	private String ruffleDate;
	private List<String> ruflleNumbers = new ArrayList<>();

	public String getIDRuffle() {
		return IDRuffle;
	}

	public void setIDRuffle(String IDRuffle) {
		this.IDRuffle = IDRuffle;
	}

	public String getRuffleDate() {
		return ruffleDate;
	}

	public void setRuffleDate(String RuffleDate) {
		this.ruffleDate = RuffleDate;
	}

	public List<String> getRuflleNumbers() {
		return ruflleNumbers;
	}

	public void setRuflleNumbers(List<String> ruflleNumbers) {
		this.ruflleNumbers = ruflleNumbers;
	}
	
	public String getSelectedNumbers() {
		return selectedNumbers;
	}

	public void setSelectedNumbers(String selectedNumbers) {
		this.selectedNumbers = selectedNumbers;
	}
	
	public String getContNumber() {
		return contNumber;
	}

	public void setContNumber(String contNumber) {
		this.contNumber = contNumber;
	}

	public abstract void runRuflle () ;
	
	public abstract boolean validNumber (int[] value1 , int value2);

}
