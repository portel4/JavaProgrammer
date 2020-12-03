package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Fornecedor;
import util.CSV;

public class FornecedorDAO {

	private final String arquivo = "D:/Projects/GitHub/JavaProgrammer/Estoque/db/Fornecedor.CSV";
	
	public void exportaCSV(List<Fornecedor> lista) {
		try {
			BufferedWriter dados = new BufferedWriter(new FileWriter(arquivo));
			for (Fornecedor f: lista) {
				CSV.write(dados, f.getCodigo());
				CSV.write(dados, f.getNome());
				CSV.write(dados, f.getCnpj());
				CSV.writeln(dados, f.getTelefone());
			}
			dados.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public List<Fornecedor> importaCSV() {
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		try {
			BufferedReader dados = new BufferedReader(new FileReader(arquivo));
			String linha;
			while ((linha = dados.readLine()) != null) {
				String[] s = linha.split(",");
				int codigo = Integer.parseInt(s[0]);
				String nome = s[1];
				nome = nome.replaceAll("\"", "");
				String cnpj = s[2];
				nome = cnpj.replaceAll("\"", "");
				String telefone = s[3];
				nome = telefone.replaceAll("\"", "");
				lista.add(new Fornecedor(codigo,nome,cnpj,telefone));
			}
			dados.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}	
	
}
