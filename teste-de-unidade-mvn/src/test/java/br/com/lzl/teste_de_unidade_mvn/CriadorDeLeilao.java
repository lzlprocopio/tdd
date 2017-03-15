package br.com.lzl.teste_de_unidade_mvn;

import br.com.lzl.leilao.dominio.Lance;
import br.com.lzl.leilao.dominio.Leilao;
import br.com.lzl.leilao.dominio.Usuario;

public class CriadorDeLeilao {

	private Leilao leilao;

	public CriadorDeLeilao() {
	}

	public CriadorDeLeilao para(String descricao) {
		this.leilao = new Leilao(descricao);
		return this;
	}

	public CriadorDeLeilao lance(Usuario usuario, double valor) {
		leilao.propoe(new Lance(usuario, valor));
		return this;
	}

	public Leilao constroi() {
		return leilao;
	}

}
