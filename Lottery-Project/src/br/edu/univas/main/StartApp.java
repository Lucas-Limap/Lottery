package br.edu.univas.main;

import br.edu.univas.view.*;
import br.edu.univas.vo.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartApp {
		static View view = new View ();
		static Scanner input = new Scanner (System.in);
		static MegaSena megaControl = new MegaSena ();
		static Quina quinaControl = new Quina();
		static LotoFacil lotoControl =  new LotoFacil();
		
	public static void main(String[] args) throws IOException {
		
		initialize();
		
	}private static void initialize () throws IOException {
				
		printMenu();
		
	}public static int readInterger () {
		int value = input.nextInt();
		input.nextLine();
		return value;
	
	}public static void printMenu () throws IOException {
		int option = 0;
		
		do {
			view.printMenu();
			option = readInterger();
			
			if(option == 9) {
				System.out.println("FIM DO PROGRAMA");
				break;			
			
			}else if (option > 9 || option <= 0) {
				System.out.println("OPÇÃO INVALIDA");
					
			}else if (option == 1) {
				subMenu(option);
				
			}else if (option == 2) {
				subMenu(option);			
				
			}else if (option == 3) {
				subMenu(option);						
					
			}
			
		}while(option != 9);		
		
	
	}public static void subMenu (int selected) throws IOException {
		int option = 0;
		view.printSubMenu();
		option = readInterger();
		
		if(option == 9) {
			System.out.println("MENU PRINCIPAL");
			
		
		}else if (option > 9 || option <= 0) {
			System.out.println("OPÇÃO INVALIDA");
			
			
		}else if (option == 1) {
			if(selected == 1) {
				List<MegaSena> megaList = new ArrayList <> ();
				megaList = megaControl.megaAdd(megaList);
				megaControl.reapetNumber(megaList, option);
					
			
			}else if (selected == 2) {
				List<Quina> quinaList = new ArrayList <> ();
				quinaList = quinaControl.quinaAdd(quinaList);
				quinaControl.reapetNumber(quinaList, option);
			
			}else if (selected == 3) {
				List<LotoFacil> lotoList = new ArrayList <> ();
				lotoList = lotoControl.lotoAdd(lotoList);
				lotoControl.reapetNumber(lotoList, option);				
				
			}
			
		}else if (option == 2) {
			
			if(selected == 1) {
				List<MegaSena> megaList = new ArrayList <> ();
				megaList = megaControl.megaAdd(megaList);
				megaControl.reapetNumber(megaList, option);
				
			}else if (selected == 2) {
				List<Quina> quinaList = new ArrayList <> ();
				quinaList = quinaControl.quinaAdd(quinaList);
				quinaControl.reapetNumber(quinaList, option);
							
			}else if (selected == 3) {
				List<LotoFacil> lotoList = new ArrayList <> ();
				lotoList = lotoControl.lotoAdd(lotoList);
				lotoControl.reapetNumber(lotoList, option);		
								
			}
		
		}else if (option == 3) {			
			
			if(selected == 1) {
				megaControl.runRuflle();			
			
			}else if (selected == 2) {
				quinaControl.runRuflle();
			
			}else if (selected == 3) {
				lotoControl.runRuflle();				
			}
				
		
		}else if (option == 4) {
			if(selected == 1) {
				List<MegaSena> msList = new ArrayList <> ();
				msList = megaControl.megaAdd(msList);
				megaControl.seachRaffle(msList);
			}else if (selected == 2) {
				List<Quina> quinaList = new ArrayList <> ();
				quinaList = quinaControl.quinaAdd(quinaList);
				quinaControl.seachRaffle(quinaList);
			}else if (selected == 3) {
				List<LotoFacil> lotoList = new ArrayList <> ();
				lotoList = lotoControl.lotoAdd(lotoList);
				lotoControl.seachRaffle(lotoList);
			}
		}
		
	}

}
