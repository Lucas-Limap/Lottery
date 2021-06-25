package br.edu.univas.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.lang.Comparable;

public class LogicTest {
	public static void main(String[] args) throws IOException  {
		
		String path = "mega.csv";
		String line = "";
		String comparar = "41 01 21 30 50 60";
		String num = "41";
		String num2 = "05";
		int cont = 0;
		List<String> mega = new ArrayList <> ();
		
		BufferedReader br = new BufferedReader (new FileReader(path));
		
		while((line = br.readLine())!= null) {
			String [] values = line.split(",");
			mega.add(values.toString());
				
		}
		
		for (int i = 0; i < mega.size(); i++) {
			if(num.equals(mega.toString())) {
				cont++;
			}
		}
		
		System.out.println(mega);
		System.out.println(cont);
		System.out.println(mega.size());
		Collections.sort(mega);
		
		
    }
}
