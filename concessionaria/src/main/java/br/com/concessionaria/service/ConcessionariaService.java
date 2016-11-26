package br.com.concessionaria.service;

import java.util.List;

import br.com.concessionaria.domain.Concessionaria;

public interface ConcessionariaService {
	Concessionaria salvar(Concessionaria concessionaria);

	Concessionaria getConcessionariaById(String id);
	
	Concessionaria update(Concessionaria concessionaria);
	
	void delete(String id);
	
	List<Concessionaria> listAllConcessionarias();
}
