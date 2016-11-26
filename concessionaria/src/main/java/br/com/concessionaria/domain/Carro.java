package br.com.concessionaria.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
    private String modelo;
    private String motor;
	
	@OneToOne
	@JoinColumn(name = "ID_LOJA")
	private Concessionaria concessionaria;
	
	@Transient
	private List<String> concessionarias;
	
	public Carro(String modelo, List<String> concessionarias) {
		super();
		this.modelo = modelo;
		this.concessionarias = concessionarias;
	}
}
