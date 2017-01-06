package br.com.lzl.teste_de_unidade_mvn;

import org.junit.Assert;
import org.junit.Test;

import br.com.lzl.leilao.main.MatematicaMaluca;

public class MatematicaMalucaTest {

	@Test
	public void deveCalcularNumeroMaiorQue30() {

		MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
		int valorEsperado = 124;
		int valorObtido = matematicaMaluca.contaMaluca(31);

		Assert.assertEquals(valorEsperado, valorObtido);

	}
}
