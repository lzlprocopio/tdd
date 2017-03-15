package br.com.lzl.teste_de_unidade_mvn;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.lzl.leilao.main.AnoBissexto;

public class AnoBissextoTest {

	@Test
	public void deveRetornarPositovoParaAnosMultiplosDe400() {
		assertTrue(new AnoBissexto().ehBissexto(800));
		assertTrue(new AnoBissexto().ehBissexto(400));
		assertTrue(new AnoBissexto().ehBissexto(2000));
		assertTrue(new AnoBissexto().ehBissexto(1600));

	}

	@Test
	public void deveRetornarNegativoParaAnosMultiplosDe100QueNaoSaoMultiplosDe400() {
		assertFalse(new AnoBissexto().ehBissexto(1000));
		assertFalse(new AnoBissexto().ehBissexto(100));
		assertFalse(new AnoBissexto().ehBissexto(300));
	}

	@Test
	public void deveRetornarPositivoParaAnoMultiploDe4QueNaoSaoMultiplosDe100() {
		assertTrue(new AnoBissexto().ehBissexto(4));
	}

	@Test
	public void deveRetornarFalsoParaAnoNaoMultiploDe4NemDe400() {
		assertFalse(new AnoBissexto().ehBissexto(2015));
		assertFalse(new AnoBissexto().ehBissexto(2017));
		assertFalse(new AnoBissexto().ehBissexto(2018));
	}
}
