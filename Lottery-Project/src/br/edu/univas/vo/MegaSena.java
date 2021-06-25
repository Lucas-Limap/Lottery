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


public class MegaSena extends Loterry {
	
	static final int MEGA_SENA = 6;
	static final String PATH = "mega.csv";
	static String  line = "";
	static Scanner input = new Scanner (System.in);
	static Random rand = new Random();
	static DecimalFormat decFormat = new DecimalFormat("00");
	static View view = new View();
	
		
	@Override
	public void runRuflle () {
				
		int[] result = new int [MEGA_SENA];
		int value = 0;
		boolean repeat = false;
        		
		for (int i = 0; i < MEGA_SENA; i++) {
        		do {
                value = rand.nextInt(60)+1;
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
	        
	}public void megaList () throws IOException {
		List<MegaSena> qList = new ArrayList <> ();
		qList = megaAdd(qList);
		
	
	}public List<MegaSena> megaAdd(List<MegaSena> megaList) throws IOException {
		
		BufferedReader reader = new BufferedReader (new FileReader(PATH));
		while((line = reader.readLine())!= null) {
			String [] values = line.split(",");
			MegaSena megaLotery = new MegaSena();
			List<String> listAux = new ArrayList <> ();
			for (int i = 0; i < values.length; i++) {
				if(i == 0) megaLotery.setIDRuffle(values[i]);						
				if(i == 1) megaLotery.setRuffleDate(values[i]);						
				if(i >= 2) listAux.add(values[i]);										
			}
			megaLotery.setRuflleNumbers(listAux);
			megaList.add(megaLotery);
		}
		reader.close();
		return megaList;
	
	}public void reapetNumber (List<MegaSena> megaList, int option) {
			
		List<String> megaNumber = new ArrayList<>();		
			for (int i = 0; i < megaList.size(); i++) {
				for (int j = 0; j < megaList.get(i).getRuflleNumbers().size(); j++) {
					megaNumber.add(megaList.get(i).getRuflleNumbers().get(j));
			}
		}
		
		List<HitsNumbers> raffleNumber = new ArrayList<>();
		
		for (int i = 0; i < 60; i++) {
			int count = 0;
			String chart = decFormat.format(i);
			HitsNumbers values = new HitsNumbers();
			values.setRuffleID(chart);
			for (int j = 0; j < megaNumber.size(); j++) {
				if(chart.equals(megaNumber.get(j).toString())) {
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
		
		
	}public void seachRaffle (List<MegaSena> megaList) {
		
		List<HitsNumbers> hits = new ArrayList<>();
		
		ArrayList<String> inputUser = new ArrayList<>();
		List<String> raffleUser = inputUser;
		
		for (int i = 0; i < MEGA_SENA; i++) {
			System.out.printf("Digite a Dezena %s: ", i+1);
			int value = readInterger();
			String inputConvert = decFormat.format(value);
			inputUser.add(inputConvert);
		
		
		}
		for (int i = 0; i < megaList.size(); i++) {
			HitsNumbers hitsCount = new HitsNumbers();
			int count = 0;
			for (int j = 0; j < raffleUser.size(); j++) {
				for (int k = 0; k < megaList.get(i).getRuflleNumbers().size(); k++) {
					if(raffleUser.get(j).equals(megaList.get(i).getRuflleNumbers().get(k))) {
						count++;
					}
				}
			}
			if(count >= 4 && count <= 6) {
				hitsCount.setRuffleID(megaList.get(i).getIDRuffle());
				hitsCount.setRuffleNumber(count);
				hits.add(hitsCount);
				count = 0;
			}
		}
		
		for (int i = 0; i < hits.size(); i++) {
			if(hits.get(i).getRuffleNumbers() == 4){
				System.out.printf("No concurso %s você ganharia na Quadra\n", hits.get(i).getRuffleID());
			}else if(hits.get(i).getRuffleNumbers() == 5){
				System.out.printf("No concurso %s você ganharia na Quina\n", hits.get(i).getRuffleID());
			}else if (hits.get(i).getRuffleNumbers() == 6 && hits.get(i).getRuffleID().equals("2255")) {
				System.out.printf("No concurso %s você ganhou na MEGA! Pode parar de trabalhar!\n", hits.get(i).getRuffleID());
			}else if(hits.get(i).getRuffleNumbers() == 6){
				System.out.printf("No concurso %s você ganharia na MEGA\n", hits.get(i).getRuffleID());
			}else {
				System.out.printf("Não foi dessa vez! dorme cedo amanhã você trabalha ;-;\n");
			}
		}
		
	}
	
}
