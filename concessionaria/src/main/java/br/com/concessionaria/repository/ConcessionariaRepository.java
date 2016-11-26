package br.com.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.concessionaria.domain.Concessionaria;

public interface ConcessionariaRepository extends JpaRepository<Concessionaria, String> {
	
}