package br.com.concessionaria.domain;

import java.util.List;
import br.com.carro.domain.Carro;

public class ConcessionariaComCarros extends Concessionaria {

	private List<Carro> carros;

	public ConcessionariaComCarros(Concessionaria concessionaria, List<Carro> carros) {
		super(concessionaria.getId(), concessionaria.getName());
		this.carros = carros;
	}

	public List<Carro> getCarro() {
		return carros;
	}

	public void setCarro(List<Carro> carros) {
		this.carros = carros;
	}
}
