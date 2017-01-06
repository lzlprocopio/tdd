package br.com.lzl.teste_de_unidade_mvn;

import org.junit.Test;

import br.com.lzl.leilao.dominio.Lance;
import br.com.lzl.leilao.dominio.Leilao;
import br.com.lzl.leilao.dominio.Usuario;
import br.com.lzl.leilao.servico.Avaliador;
import static org.junit.Assert.*;

import java.util.List;

public class TesteAvaliador {
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 novo");

		leilao.propoe(new Lance(joao, 250.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avaliar(leilao);

		double maiorEsperado = 400.0;
		double menorEsperado = 250.0;

		assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}

	@Test
	public void deveEntenderLancesEmOrdemDeCrescente() {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 novo");

		leilao.propoe(new Lance(joao, 400.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 250.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avaliar(leilao);

		double maiorEsperado = 400.0;
		double menorEsperado = 250.0;

		assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);

	}

	@Test
	public void deveCalcularValorMedioDosLances() {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 novo");

		leilao.propoe(new Lance(joao, 400.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 250.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avaliar(leilao);

		double mediaEsperada = 316.6666666666667;

		assertEquals(mediaEsperada, leiloeiro.getValorMedio(leilao), 0.000000000001);
	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Usuario joao = new Usuario("João");
		Leilao leilao = new Leilao("Playstation 3");
		leilao.propoe(new Lance(joao, 200.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avaliar(leilao);

		assertEquals(200.0, leiloeiro.getMaiorDeTodos(), 0.00000001);
		assertEquals(200.0, leiloeiro.getMenorLance(), 0.00000001);

	}

	@Test
	public void deveEncontrarOsTresMaiores() {
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 novo");

		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avaliar(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(3, maiores.size());
		assertEquals(400.0, maiores.get(0).getValor(), 0.0000001);
		assertEquals(300.0, maiores.get(1).getValor(), 0.0000001);
		assertEquals(200.0, maiores.get(2).getValor(), 0.0000001);
	}

	@Test
	public void deveEntenderLeilaoComLancesEmOrdemAleatoria() {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 novo");

		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(jose, 450.0));
		leilao.propoe(new Lance(maria, 120.0));
		leilao.propoe(new Lance(joao, 700.0));
		leilao.propoe(new Lance(jose, 630.0));
		leilao.propoe(new Lance(maria, 230.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avaliar(leilao);

		assertEquals(700.0, leiloeiro.getMaiorDeTodos(), 0.00000001);
		assertEquals(120.0, leiloeiro.getMenorLance(), 0.00000001);

	}

	@Test
	public void deveEncontrarOSTresMaioresLances() {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 novo");

		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avaliar(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(3, maiores.size());
		assertEquals(400.0, maiores.get(0).getValor(), 0.0000001);
		assertEquals(300.0, maiores.get(1).getValor(), 0.0000001);
		assertEquals(200.0, maiores.get(2).getValor(), 0.0000001);
	}
}
