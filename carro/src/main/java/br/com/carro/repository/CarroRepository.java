package br.com.carro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carro.domain.Carro;

public interface CarroRepository extends JpaRepository<Carro, String> {
	
}
