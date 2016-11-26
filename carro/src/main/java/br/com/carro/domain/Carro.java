package br.com.carro.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {
	
	private static final long serialVersionUID = 1L;

	@Id
    private Integer id;
    private String modelo;
    private String motor;

    public Carro() {
    }

    public Carro(Integer id, String modelo, String motor ) {
    	super();
        this.id = id;
        this.modelo = modelo;
        this.motor = motor;
    }

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

}
