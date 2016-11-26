package br.com.concessionaria.hystrix;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.carro.domain.Carro;
import br.com.concessionaria.feign.CarrosClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class CarrosBean {
	
	@Autowired
	private CarrosClient carrosClient;

	@HystrixCommand(fallbackMethod = "cacheCarros")
	public List<Carro> getCarros(Integer id) {
		return carrosClient.getCarros(id);
	}

	public List<Carro> cacheCarros(Integer id) {
		return Arrays.asList(new Carro(1, "Carro cache", ""));
	}
}
