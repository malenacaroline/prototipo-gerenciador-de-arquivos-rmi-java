
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.*;
import java.util.ArrayList;
import java.util.Scanner;

public class cliente {
	public static void main(String[] args) {
		interface_servidor servidor;
		try {
			System.setSecurityManager(new RMISecurityManager());
			servidor = (interface_servidor) Naming.lookup("rmi://localhost/GerenciaArquivos");

			int sair = 1;

			while (sair != 0) {
				
				System.out.println("------------------------------------------- SISTEMA DE ARQUIVOS DISTRIBUÍDOS ------------------------------------------\n");
				System.out.println("1 - CRIAR ARQUIVO \n2 - EXCLUIR ARQUIVO \n3 - COPIAR ARQUIVO \n4 - ESCREVER ARQUIVO \n5 - LER ARQUIVOS \n0 - SAIR");
				System.out.println("----------------------------------------------------------------------------------------------------------------------\n");
				Scanner scan = new Scanner(System.in);
				int opcao = scan.nextInt();
				System.out.println("");
				switch (opcao) {
				case 1:
					System.out.println("Digite o nome do arquivo:");
					String nome_arquivo = scan.next(); 
					String result = servidor.criar_arquivo(nome_arquivo);
					System.out.println(result);					
					break;
				case 2:
					System.out.println("Digite o nome do arquivo:");
					String nome_arquivo1 = scan.next();
					String result1 = servidor.apagar_arquivo(nome_arquivo1);
					System.out.println(result1);
					break;
				case 3:
					System.out.println("Digite o nome do arquivo:");
					String nome_arquivo2 = scan.next();
					System.out.println("Digite o nome do novo arquivo:");
					String novo = scan.next();
					String result2 = servidor.copiar_arquivo(nome_arquivo2, novo);
					System.out.println(result2);
					break;
				case 4:
					System.out.println("Digite o nome do arquivo:");
					String nome_arquivo3 = scan.next();
					System.out.println("Digite o texto que deseja adicionar ao arquivo:");
					String texto = scan.next();
					String result3 = servidor.escrever_arquivo(nome_arquivo3, texto);
					System.out.println(result3);
					break;
				case 5:
					System.out.println("Digite o nome do arquivo:");
					String nome_arquivo4 = scan.next();
					System.out.println("Conteudo do arquivo "+nome_arquivo4+": ");
					ArrayList<String> linhas = servidor.ler_arquivo(nome_arquivo4);
					for(int i = 0; i < linhas.size(); i++) {   
					    System.out.println(linhas.get(i));
					}
					break;
				case 0:
					sair = 0;
					break;
				default:
					
				}
			}

		} catch (Exception e) {
			System.out.println("Erro no Cliente: " + e);
		}
	}
}