package br.com.carro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.carro.domain.*;
import br.com.carro.repository.*;

@Service
@Validated
public class CarroServiveImpl implements CarroService{

	@Autowired
	private CarroRepository repository;
	
	public Carro salvar(Carro carro) {
		return repository.save(carro);
	}

	public Carro getCarroById(String id) {
		return repository.findOne(id);
	}

	public List<Carro> listAllCarros() {
		return repository.findAll();
	}

	public Carro update(Carro carro) {
		return repository.save(carro);
	}

	public void delete(String id) {
		repository.delete(id);
	}

}
