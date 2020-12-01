package cap16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex01_Output {
	
	private static final String ARQUIVO = "E:/Documents/Arquivo.txt";
	private static final String TEXTO = "De tudo, ao meu amor serei atento\n"
									  + "Antes, e com tal zelo, e sempre, e tanto\n"
									  + "Que mesmo em face do maior encanto\n"
									  + "Dele se encante mais meu pensamento.";
	
	
	public static void main(String[] args) {
		gravaArquivo();
		leArquivo();
	}
	
	public static void gravaArquivo() {
		try {
			FileOutputStream fout = new FileOutputStream(ARQUIVO);
			DataOutputStream dados = new DataOutputStream(fout);
			dados.writeUTF(TEXTO); 
			dados.close();
			fout.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void leArquivo() {
		try {
			FileInputStream fin = new FileInputStream(ARQUIVO);
			DataInputStream dados = new DataInputStream(fin);
			while (true) {
				char c = dados.readChar();
				System.out.print(c);
			}
		} catch (IOException e) {
			System.out.println("\n*** Fim do arquivo ***");
		}
	}

}
