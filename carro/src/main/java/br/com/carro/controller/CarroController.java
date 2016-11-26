package br.com.carro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.carro.domain.Carro;
import br.com.carro.service.*;

@RestController
public class CarroController {

	@Autowired
	private CarroService carroService;
	
	@RequestMapping(value = "/carros", method = RequestMethod.GET)
	public ResponseEntity<List<Carro>> listAllCarros() {
		return new ResponseEntity< List<Carro> >(carroService.listAllCarros(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/carros/{codigoCarro}", method = RequestMethod.GET)
	public ResponseEntity<Carro> getCarro(@PathVariable String codigoCarro) {
		
		Carro carro =  carroService.getCarroById(codigoCarro);
		
		return carro == null ? 
				new ResponseEntity<Carro>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Carro>(carro, HttpStatus.OK);
	}

	
	@RequestMapping(value="/carro", method = RequestMethod.POST)
	public ResponseEntity<String> criarCarro(@RequestBody Carro carro) {

		try {
			
			carroService.salvar(carro);
			
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/carro/{codigoCarro}", method = RequestMethod.PUT)
	public ResponseEntity<String> alterarCarro(@RequestBody Carro carro) {
		
		try {
			
			carroService.update(carro);
			
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/carro/{codigoCarro}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletarCarro(@PathVariable String codigoCarro) {
		
		try {
			
			carroService.delete(codigoCarro);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
