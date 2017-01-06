package br.com.lzl.teste_de_unidade_mvn;

import org.junit.Test;

import br.com.lzl.leilao.dominio.Palindromo;
import static org.junit.Assert.*;

public class PalindromoTest {

	@Test
	public void deveVerificarSeEPalindromo() {
		Palindromo palindromo = new Palindromo();
		String frase = "Socorram-me subi no onibus em Marrocos";
		String frase2 =  "Anotaram a data da maratona";
		assertTrue(palindromo.ehPalindromo(frase));
		assertTrue(palindromo.ehPalindromo(frase2));
	}

}
