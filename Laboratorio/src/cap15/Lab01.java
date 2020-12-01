package cap15;

import java.util.HashMap;

/**
 * 1. Crie um projeto Java chamado Cap15_Lab01;
 * 2. Dentro dele, crie uma classe com o nome Cap15_Lab1 e insira a estrutura
 * básica de um programa Java;
 * 3. Importe a classe HashMap do pacote java.util;
 * 4. Dentro do método main, crie um objeto HashMap <String, Integer> com o
 * nome pessoaMap;
 * 5. Utilizando o método put, insira quatro nomes de pessoas e suas respectivas
 * idades no HashMap pessoaMap;
 * 6. Utilizando o método get, imprima o nome e idade de todas as pessoas;
 *
 * "nome",idade
 * "João",22
 * "Carlos",18
 */


public class Lab01 {
	
	public static void main(String[] args) {
		
		HashMap<String,Integer> pessoaMap = new HashMap<>();
		pessoaMap.put("João", 22);
		pessoaMap.put("Carlos", 18);
		pessoaMap.put("Antônio", 31);
		pessoaMap.put("Jorge", 27);
		
//		String nome = "João";
//		int idade = pessoaMap.get(nome);
//		System.out.println(nome + ": " + idade);
//		nome = "Carlos";
//		idade = pessoaMap.get(nome);
//		System.out.println(nome + ": " + idade);
		
		System.out.println("Listagem de Pessoas ==========");
		for (String nome: pessoaMap.keySet()) {
			System.out.println(nome + ": " + pessoaMap.get(nome));
		}
		
		System.out.println("Com Streams e Expressão Lambda ====");
		pessoaMap.forEach((nome,idade) ->  System.out.println(nome + ": " + pessoaMap.get(nome)));
	}

}
