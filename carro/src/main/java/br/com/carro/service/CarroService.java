package br.com.carro.service;

import java.util.List;

import br.com.carro.domain.*;

public interface CarroService {
	Carro salvar(Carro carro);

	Carro getCarroById(String id);
	
	Carro update(Carro carro);
	
	void delete(String id);
	
	List<Carro> listAllCarros();
}
