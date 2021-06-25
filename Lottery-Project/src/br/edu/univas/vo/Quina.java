package br.edu.univas.vo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import br.edu.univas.view.View;

public class Quina extends Loterry {
	
	static final int QUINA = 5;
	static final String PATH = "quina.csv";
	static String  line = "";
	static Scanner input = new Scanner (System.in);
	static Random rand = new Random();
	static DecimalFormat decFormat = new DecimalFormat("00");
	static View view = new View();
	
		
	@Override
	public void runRuflle () {
				
		int[] result = new int [QUINA];
		int value = 0;
		boolean repeat = false;
        		
		for (int i = 0; i < QUINA; i++) {
        		do {
                value = rand.nextInt(80)+1;
                repeat = validNumber(result, value);
        		}while(repeat);
        		
        		result[i] = value;
        		System.out.printf(value + " ");
    	}
		System.out.println("\n");
				
	}public static int readInterger () {
			int value = input.nextInt();
			input.nextLine();
			return value;
	
	}public boolean validNumber(int[] value1 , int value2) {
	        for (int i = 0; i < value1.length; i++) {
	            if (value1[i] == value2) return true; 
	        }
	        return false;
	        
	}public void qList () throws IOException {
		List<Quina> qList = new ArrayList <> ();
		qList = quinaAdd(qList);
		
	
	}public List<Quina> quinaAdd(List<Quina> qList) throws IOException {
		
		BufferedReader reader = new BufferedReader (new FileReader(PATH));
		while((line = reader.readLine())!= null) {
			String [] values = line.split(",");
			Quina qLotery = new Quina();
			List<String> listAux = new ArrayList <> ();
			for (int i = 0; i < values.length; i++) {
				if(i == 0) qLotery.setIDRuffle(values[i]);						
				if(i == 1) qLotery.setRuffleDate(values[i]);						
				if(i >= 2) listAux.add(values[i]);										
			}
			qLotery.setRuflleNumbers(listAux);
			qList.add(qLotery);
		}
		reader.close();
		return qList;
	
	}public void reapetNumber (List<Quina> qList, int option) {
			
		List<String> qNumber = new ArrayList<>();		
			for (int i = 0; i < qList.size(); i++) {
				for (int j = 0; j < qList.get(i).getRuflleNumbers().size(); j++) {
					qNumber.add(qList.get(i).getRuflleNumbers().get(j));
			}
		}
		
		List<HitsNumbers> raffleNumber = new ArrayList<>();
		
		for (int i = 0; i < 80; i++) {
			int count = 0;
			String chart = decFormat.format(i);
			HitsNumbers values = new HitsNumbers();
			values.setRuffleID(chart);
			for (int j = 0; j < qNumber.size(); j++) {
				if(chart.equals(qNumber.get(j).toString())) {
					count++;
				}				
			}
			values.setRuffleNumber(count);
			raffleNumber.add(values);
			raffleNumber.remove("00");
		}
		Collections.sort(raffleNumber);
		
		if(option == 1) { 
			for (int i = 1; i <= 5; i++) {
				System.out.printf(raffleNumber.get(i).toString());
			}
		}
		else {
			Collections.reverse(raffleNumber);
			for (int i = 1; i <= 5; i++) {
			System.out.printf(raffleNumber.get(i).toString());					
				
			}
		}
		
		System.out.printf("\n");
		
		
	}public void seachRaffle (List<Quina> qList) {
		
		List<HitsNumbers> hits = new ArrayList<>();
		
		ArrayList<String> inputUser = new ArrayList<>();
		List<String> raffleUser = inputUser;
		
		for (int i = 0; i < QUINA; i++) {
			System.out.printf("Digite a Dezena %s: ", i+1);
			int value = readInterger();
			String inputConvert = decFormat.format(value);
			inputUser.add(inputConvert);
		
		
		}
		for (int i = 0; i < qList.size(); i++) {
			HitsNumbers hitsCount = new HitsNumbers();
			int count = 0;
			for (int j = 0; j < raffleUser.size(); j++) {
				for (int k = 0; k < qList.get(i).getRuflleNumbers().size(); k++) {
					if(raffleUser.get(j).equals(qList.get(i).getRuflleNumbers().get(k))) {
						count++;
					}
				}
			}
			if(count >= 2 && count <= 5) {
				hitsCount.setRuffleID(qList.get(i).getIDRuffle());
				hitsCount.setRuffleNumber(count);
				hits.add(hitsCount);
				count = 0;
			}
		}
		
		for (int i = 0; i < hits.size(); i++) {
			if(hits.get(i).getRuffleNumbers() == 2){
				System.out.printf("No concurso %s você acertaria 2 dezenas\n", hits.get(i).getRuffleID());
			}else if(hits.get(i).getRuffleNumbers() == 3){
				System.out.printf("No concurso %s você acertaria 3 dezenas\n", hits.get(i).getRuffleID());
			}else if(hits.get(i).getRuffleNumbers() == 4){
				System.out.printf("No concurso %s você ganharia Quadra\n", hits.get(i).getRuffleID());
			}else if (hits.get(i).getRuffleNumbers() == 5 && hits.get(i).getRuffleID().equals("5254")){
				System.out.printf("No concurso %s você ganhou na QUINA! Não vai gastar tudo no camaro amarelo\n", hits.get(i).getRuffleID());
			}else if (hits.get(i).getRuffleNumbers() == 5) {
				System.out.printf("No concurso %s você ganharia a Quina\n", hits.get(i).getRuffleID());
				
			}else {
				System.out.printf("Não foi dessa vez! dorme cedo amanhã você trabalha ;-;\n");
			}
		}
		
	}
	
}
