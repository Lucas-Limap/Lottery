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

public class LotoFacil extends Loterry{
	
	static final int LOTO_FACIL = 15;
	static final String PATH = "lotofacil.csv";
	static String  line = "";
	static Scanner input = new Scanner (System.in);
	static Random rand = new Random();
	static DecimalFormat decFormat = new DecimalFormat("00");
	static View view = new View();
	
		
	@Override
	public void runRuflle () {
				
		int[] result = new int [LOTO_FACIL];
		int value = 0;
		boolean repeat = false;
        		
		for (int i = 0; i < LOTO_FACIL; i++) {
        		do {
                value = rand.nextInt(25)+1;
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
	        
	}public void lotoList () throws IOException {
		List<LotoFacil> lotoList = new ArrayList <> ();
		lotoList = lotoAdd(lotoList);
		
	
	}public List<LotoFacil> lotoAdd(List<LotoFacil> msList) throws IOException {
		
		BufferedReader reader = new BufferedReader (new FileReader(PATH));
		while((line = reader.readLine())!= null) {
			String [] values = line.split(",");
			LotoFacil lotoLotery = new LotoFacil();
			List<String> listAux = new ArrayList <> ();
			for (int i = 0; i < values.length; i++) {
				if(i == 0) lotoLotery.setIDRuffle(values[i]);						
				if(i == 1) lotoLotery.setRuffleDate(values[i]);						
				if(i >= 2) listAux.add(values[i]);										
			}
			lotoLotery.setRuflleNumbers(listAux);
			msList.add(lotoLotery);
		}
		reader.close();
		return msList;
	
	}public void reapetNumber (List<LotoFacil> lotoList, int option) {
			
		List<String> lotoNumber = new ArrayList<>();		
			for (int i = 0; i < lotoList.size(); i++) {
				for (int j = 0; j < lotoList.get(i).getRuflleNumbers().size(); j++) {
					lotoNumber.add(lotoList.get(i).getRuflleNumbers().get(j));
			}
		}
		
		List<HitsNumbers> raffleNumber = new ArrayList<>();
		
		for (int i = 0; i < 25; i++) {
			int count = 0;
			String chart = decFormat.format(i);
			HitsNumbers values = new HitsNumbers();
			values.setRuffleID(chart);
			for (int j = 0; j < lotoNumber.size(); j++) {
				if(chart.equals(lotoNumber.get(j).toString())) {
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
		
		
	}public void seachRaffle (List<LotoFacil> lotoList) {
		
		List<HitsNumbers> hits = new ArrayList<>();
		
		ArrayList<String> inputUser = new ArrayList<>();
		List<String> raffleUser = inputUser;
		
		for (int i = 0; i < LOTO_FACIL; i++) {
			System.out.printf("Digite a Dezena %s: ", i+1);
			int value = readInterger();
			String inputConvert = decFormat.format(value);
			inputUser.add(inputConvert);
		
		
		}
		for (int i = 0; i < lotoList.size(); i++) {
			HitsNumbers hitsCount = new HitsNumbers();
			int count = 0;
			for (int j = 0; j < raffleUser.size(); j++) {
				for (int k = 0; k < lotoList.get(i).getRuflleNumbers().size(); k++) {
					if(raffleUser.get(j).equals(lotoList.get(i).getRuflleNumbers().get(k))) {
						count++;
					}
				}
			}
			if(count >= 14 && count <= 15) {
				hitsCount.setRuffleID(lotoList.get(i).getIDRuffle());
				hitsCount.setRuffleNumber(count);
				hits.add(hitsCount);
				count = 0;		
			}
		}
		
		for (int i = 0; i < hits.size(); i++) {

			if(hits.get(i).getRuffleNumbers() == 11){
				System.out.printf("11No concurso %s você acertaria 11 dezenas\n", hits.get(i).getRuffleID());
			}else if(hits.get(i).getRuffleNumbers() == 12){
				System.out.printf("12No concurso %s você acertaria 12 dezenas\n", hits.get(i).getRuffleID());
			}else if(hits.get(i).getRuffleNumbers() == 13){
				System.out.printf("13No concurso %s você acertaria 13 dezenas\n", hits.get(i).getRuffleID());
			}else if (hits.get(i).getRuffleNumbers() == 14) {
				System.out.printf("14No concurso %s você acertaria 14 dezenas \n", hits.get(i).getRuffleID());
			}else if (hits.get(i).getRuffleNumbers() == 15 && hits.get(i).getRuffleID().equals("2255")) {
				System.out.printf("No concurso %s você ganhou na LOTO! Não vai gastar tudo em MCDonalds!r!\n", hits.get(i).getRuffleID());
			}else if(hits.get(i).getRuffleNumbers() == 15) {
				System.out.printf("No concurso %s você ganharia na LOTO dezenas\n", hits.get(i).getRuffleID());
				
			}else {
				System.out.printf("Não foi dessa vez! dorme cedo amanhã você trabalha ;-;\n");
			}
		
	
		}
	
	}

}