package cap15;

import java.util.ArrayList;
import java.util.List;

/**
 * Utilizando uma coleção do tipo ArrayList parametrizada por um tipo
 * Estudante para armazenar dados de diversos alunos
 * 1. Dentro do método main da primeira classe criada, Cap15_Lab2, crie um
 * novo ArrayList parametrizado para o tipo Estudante, da seguinte forma:
 * ArrayList<Estudante> estudanteList = new ArrayList<>();
 * 2. Usando o método add(E e) do ArrayList criado, insira cinco instâncias da
 * classe Estudante contendo os seguintes dados:
 * 3. Utilize o método forEach() para aplicar uma expressão lambda que, para
 * cada item, calcula a média das notas de matemática e português e assinala
 * com o método setMedia();
 * 4. Use novamente o método forEach() para exibir o nome e média de cada
 * aluno;
 */
public class Lab02 {
	
	public static void main(String[] args) {
		List<Estudante> lista = new ArrayList<>();
		lista.add(new Estudante("Joana",8.5,8.5));
		lista.add(new Estudante("Antônio",6,9));
		lista.add(new Estudante("Mariana",7.5,9));
		lista.add(new Estudante("Ricardo",7,6));
		lista.add(new Estudante("Gustavo",9.5,10));
		
		// calcula média
		// forma 1
		for (Estudante e: lista) {
			e.setMedia((e.getNotaMatematica() + e.getNotaPortugues()) / 2);
		}
		// forma 2
		for (Estudante e: lista) {
			e.calculaMedia();
		}
		// forma 3
		lista.forEach(e -> e.calculaMedia());
		
		// listar dados
		// forma 1
		System.out.println("Com loop for --------");
		for (Estudante e: lista) {
			System.out.println(e.getNome() + ": " + e.getMedia());
		}
		// forma 2
		System.out.println("Com forEach ------------");
		lista.forEach(e -> System.out.println(e));
		
	}
	
}


/**
* 3. Crie uma segunda classe, chamada Estudante, com quatro atributos privados:
	• nome: String;
	• notaMatematica: double;
	• notaPortugues: double;
	• media: double.
* 4. Nessa classe, crie os métodos getters e setters apropriados e um construtor
* que receba somente os atributos nome, notaMatematica e notaPortugues
* como parâmetros e configure-os, atribuindo seus valores às suas variáveis de
* instância.
*/

class Estudante {

	private String nome;
	private double notaMatematica;
	private double notaPortugues;
	private double media;

	public Estudante(String nome, double notaMatematica, double notaPortugues) {
		setNome(nome);
		setNotaMatematica(notaMatematica);
		setNotaPortugues(notaPortugues);
	}	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getNotaMatematica() {
		return notaMatematica;
	}
	public void setNotaMatematica(double notaMatematica) {
		if (notaMatematica >= 0 && notaMatematica <= 10) {
			this.notaMatematica = notaMatematica;
		}
	}
	public double getNotaPortugues() {
		return notaPortugues;
	}
	public void setNotaPortugues(double notaPortugues) {
		this.notaPortugues = notaPortugues;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}

	public double calculaMedia() {
		setMedia((getNotaPortugues() + getNotaMatematica()) / 2);
		return getMedia();
	}
	
	@Override
	public String toString() {
		return (getNome() + ": " + getMedia());
	}
	
}
