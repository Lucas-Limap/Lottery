package br.edu.univas.view;

public class View {
	
	public void printMenu () {
		System.out.printf  (":::::MENU PRINCIPAL:::::"
						+ "\n:::::  1-Mega-Sena :::::"
						+ "\n:::::  2-Quina     :::::"
						+ "\n:::::  3-Lotof�cil :::::"
						+ "\n:::::  9-Sair      :::::"
						+ "\n::::::::::::::::::::::::\n");
	
	}public void printSubMenu () {
		System.out.printf  (":::::        MENU SECUNDARIO             :::::"
						+ "\n:::::  1-Cinco n�meros que mais sa�ram   :::::"
						+ "\n:::::  2-Cinco n�meros que menos sa�ram  :::::"
						+ "\n:::::  3-Gerar n�meros rand�micos        :::::"
						+ "\n:::::  4-Verificar meu jogo              :::::"
						+ "\n:::::  9-Menu Principal                  :::::"
						+ "\n::::::::::::::::::::::::::::::::::::::::::::::\n");
		
	}
	
}
