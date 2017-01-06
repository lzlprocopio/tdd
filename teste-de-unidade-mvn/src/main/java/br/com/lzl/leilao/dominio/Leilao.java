package br.com.lzl.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	public void propoe(Lance lance) {
		if (lances.isEmpty() || podeDarLance(lance.getUsuario()))
			lances.add(lance);
	}

	private boolean podeDarLance(Usuario usuario) {
		return (!ultimoUsuarioADarLance().equals(usuario)) && quantidadeLancesDo(usuario) < 5;
	}

	private long quantidadeLancesDo(Usuario usuario) {
		return lances.stream().filter(l -> l.propostoPor(usuario)).count();
	}

	private Usuario ultimoUsuarioADarLance() {
		return ultimoLanceDado().getUsuario();
	}

	private Lance ultimoLanceDado() {
		return lances.get(lances.size() - 1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

}
