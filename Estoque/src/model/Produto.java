package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.ProdutoDAO;

public class Produto {
	
	private int codigo;
	private String nome;
	private int qtde;
	private double valor;
	private static List<Produto> lista = new ArrayList<Produto>();
	
	public static List<Produto> getLista() {
		return lista;
	}
	
	public static void gravar() {
		new ProdutoDAO().exportaCSV(lista);
	}
	public static void carregar() {
		lista = new ProdutoDAO().importaCSV();
	}

	public Produto() {
		this(0,"",0,0);
	}
	public Produto(String nome, int qtde, double valor) {
		this(0,nome,qtde,valor);
	}
	public Produto(int codigo, String nome, int qtde, double valor) {
		setCodigo(codigo);
		setNome(nome);
		setQtde(qtde);
		setValor(valor);
		lista.add(this);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		if (qtde < 0) {
			throw new IllegalArgumentException("Quantidade deve ser maior ou igual a zero");
		} else {
			this.qtde = qtde;
		}
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public static DefaultTableModel getTableModel() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("C�digo");
		modelo.addColumn("Nome");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Valor");
		for (Produto p: lista) {
			String[] s = { String.valueOf(p.getCodigo()),
						   p.getNome(),
						   String.valueOf(p.getQtde()),
						   String.valueOf(p.getValor())
						 };
			modelo.addRow(s);
		}
		return modelo;
	}
	
	@Override
	public String toString() {
		return (getNome() + ": \t\tSaldo=" + getQtde() + "\t\tValor=" + getValor());
	}

}
