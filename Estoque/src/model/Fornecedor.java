package model;

import java.util.ArrayList;
import java.util.List;

import dao.FornecedorDAO;
import util.Valida;

public class Fornecedor {

	private int codigo;
	private String nome;
	private String cnpj;
	private String telefone;
	private static List<Fornecedor> lista = new ArrayList<Fornecedor>();

	public static List<Fornecedor> getLista() {
		return lista;
	}

	public static void gravar() {
		new FornecedorDAO().exportaCSV(lista);
	}

	public static void carregar() {
		lista = new FornecedorDAO().importaCSV();
	}

// Não pode existir na versão final do sistema
//	public Fornecedor() { 
//		this(0, "", "", "");
//	}

	public Fornecedor(String nome, String cnpj, String telefone) {
		this(0, nome, cnpj, telefone);
	}

	public Fornecedor(int codigo, String nome, String cnpj, String telefone) {
		setCodigo(codigo);
		setNome(nome);
		setCnpj(cnpj);
		setTelefone(telefone);
		lista.add(this);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (codigo >= 0) {
			this.codigo = codigo;
		} else {
			throw new IllegalArgumentException("Código inválido");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.length() > 2) {
			this.nome = nome;
		} else {
			throw new IllegalArgumentException("Nome inválido. Deve ter mais que 2 caracteres!");
		}
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		if (Valida.CNPJ(cnpj)) {
		this.cnpj = cnpj;
		} else {
			throw new IllegalArgumentException("CNPJ Inválido!");
		}
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return ("Fornecedor: [" + "CNPJ: " + getCnpj() + "\tNome: " + getNome() + "]");
	}

}
