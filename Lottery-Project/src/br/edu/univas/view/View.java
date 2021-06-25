package br.edu.univas.view;

public class View {
	
	public void printMenu () {
		System.out.printf  (":::::MENU PRINCIPAL:::::"
						+ "\n:::::  1-Mega-Sena :::::"
						+ "\n:::::  2-Quina     :::::"
						+ "\n:::::  3-Lotofácil :::::"
						+ "\n:::::  9-Sair      :::::"
						+ "\n::::::::::::::::::::::::\n");
	
	}public void printSubMenu () {
		System.out.printf  (":::::        MENU SECUNDARIO             :::::"
						+ "\n:::::  1-Cinco números que mais saíram   :::::"
						+ "\n:::::  2-Cinco números que menos saíram  :::::"
						+ "\n:::::  3-Gerar números randômicos        :::::"
						+ "\n:::::  4-Verificar meu jogo              :::::"
						+ "\n:::::  9-Menu Principal                  :::::"
						+ "\n::::::::::::::::::::::::::::::::::::::::::::::\n");
		
	}
	
}
