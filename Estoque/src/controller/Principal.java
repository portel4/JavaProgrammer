package controller;

import model.Produto;

public class Principal {
	
	public static void main(String[] args) {
		geraProdutos();
		listaProdutos();
		gravaProdutos();
	}
	
	private static void geraProdutos() {
		new Produto(1,"Teclado Microsoft Natural",15,180);
		new Produto(2,"Monitor HP IPS Full HD 23,5",5,1000);
		new Produto(3,"SSD Sandisk 480GB M2",10,500);
		new Produto(4,"Mouse Logitech Gamer",15,100);
		new Produto(5,"Memória DDR4 2666Mhz 8GB",20,300);
		new Produto(6,"Placa NVidia RTX3080 Nova",5,3000);
	}
	
	private static void listaProdutos() {
		Produto.getLista().forEach(e -> System.out.println(e));
	}
	
	private static void gravaProdutos() {
		Produto.gravar();
	}
	
}
