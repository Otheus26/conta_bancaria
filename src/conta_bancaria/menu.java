package conta_bancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao;
		boolean continuar = true;

		ContaController contas = new ContaController();

		int escolha, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100);
		contas.cadastrar(cc1);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		contas.cadastrar(cp1);

		while (continuar == true) {

			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_BLUE
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("Escolha uma opção:                                   ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
			opcao = leia.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				continuar = false;
				System.out.println(Cores.TEXT_BLUE + "Consulta finalizada!");
				sobre();
			}

			switch (opcao) {
			case 1:System.out.println(Cores.TEXT_BLUE + "Criar Conta\n");

				System.out.println("Digite o número da Agência: ");
				agencia = leia.nextInt();

				System.out.println("Digite o nome do titular: ");leia.skip("\\R");
				titular = leia.nextLine();

				System.out.println("Digite o tipo da Conta (1 - CC ou 2 - CP): ");
				tipo = leia.nextInt();
				
				System.out.println("Digite o Saldo da Conta:");
				saldo = leia.nextFloat();
				
				switch(tipo) {
				case 1 -> {
					System.out.println("Digite o limite da conta: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do aniversário da conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				
				}
				
				

			case 2: 
				System.out.println(Cores.TEXT_BLUE + "Listar Todas as Contas\n: ");
					contas.listarTodas();
				keyPress();
				break;

			case 3: 
				System.out.println(Cores.TEXT_BLUE + "Buscar Conta por Número\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;

			case 4: 
				System.out.println(Cores.TEXT_BLUE + "Atualizador Dados da Conta\n");
				keyPress();
				break;

			case 5: 
				System.out.println(Cores.TEXT_BLUE + "Apagar Conta\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero);

				keyPress();
				break;

			case 6: 
				System.out.println(Cores.TEXT_BLUE + "Sacar\n");
				keyPress();
				break;

			case 7: 
				System.out.println(Cores.TEXT_BLUE + "Depositar\n");
				keyPress();
				break;

			case 8: 
				System.out.println(Cores.TEXT_BLUE + "Transferir Valores entre Contras\n");
				keyPress();
				break;
				
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			}

		}

	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Matheus Pedrosa");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/Otheus26");
		System.out.println("*********************************************************");
	}
	
	public static void keyPress() {
		try {
			
			System.out.println("\n\nPressione a tecla Enter para continuar...");
			System.in.read();
			
		}catch(IOException e) {
			System.out.println("Você pressionou uma tecla inválida!");
		}
	}

}
