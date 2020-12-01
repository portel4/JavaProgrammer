package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.Produto;

// DAO - Data Access Object
public class ProdutoDAO {
	
	private final String arquivo = "D:/Projects/GitHub/JavaProgrammer/Estoque/db/Produto.CSV";
	
	public void exportaCSV(List<Produto> lista) {
		try {
			BufferedWriter dados = new BufferedWriter(new FileWriter(arquivo));
			for (Produto p: lista) {
				dados.write(p.getCodigo());
				// finalizar rotina
			}
			dados.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}		
	}

}
