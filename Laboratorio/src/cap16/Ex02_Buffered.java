package cap16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex02_Buffered {
	
	private static final String ARQUIVO = "E:/Documents/Arquivo.txt";
	private static final String ARQCSV = "E:/Documents/Gorjetas.csv";
	private static final String TEXTO = "De tudo, ao meu amor serei atento\n"
									  + "Antes, e com tal zelo, e sempre, e tanto\n"
									  + "Que mesmo em face do maior encanto\n"
									  + "Dele se encante mais meu pensamento.";
	
	
	public static void main(String[] args) {
		gravaArquivo();
		leArquivo3();
	}
	
	public static void gravaArquivo() {
		try {
			FileWriter fout = new FileWriter(ARQUIVO);
			BufferedWriter dados = new BufferedWriter(fout);
			dados.write(TEXTO); 
			dados.close();
			fout.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void leArquivo() {
		try {
			FileReader fin = new FileReader(ARQUIVO);
			BufferedReader dados = new BufferedReader(fin);
			String s = "";
			while (s != null) {
				s = dados.readLine();
			    if (s != null) System.out.println(s);
			}
			dados.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("\n*** Fim do arquivo ***");
		}
	}

	public static void leArquivo2() {
		try {
			FileReader fin = new FileReader(ARQCSV);
			BufferedReader dados = new BufferedReader(fin);
			String s;
			while ((s = dados.readLine()) != null) {
				String[] campos = s.split(";");
				for (String c: campos) {
					System.out.println(c + " - ");
				}
			}
			dados.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("\n*** Fim do arquivo ***");
		}
	}	
	
	public static void leArquivo3() {
		try {
			FileReader fin = new FileReader(ARQUIVO);
			BufferedReader dados = new BufferedReader(fin);
			while (dados.readLine() != null) {
				System.out.println(dados.readLine());
			}
			dados.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("\n*** Fim do arquivo ***");
		}
	}

}
