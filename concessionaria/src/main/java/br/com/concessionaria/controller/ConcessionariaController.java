package br.com.concessionaria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.concessionaria.domain.Concessionaria;
import br.com.concessionaria.service.ConcessionariaService;
import br.com.concessionaria.hystrix.CarrosBean;

@RestController
public class ConcessionariaController {

	@Autowired
	private CarrosBean carrosBean;
	
	@Autowired
	private ConcessionariaService concessionariaService;

	
	@RequestMapping(value = "/concessionarias", method = RequestMethod.GET)
	public ResponseEntity<List<Concessionaria>> listAllProdutos() {
		return new ResponseEntity< List<Concessionaria> >(concessionariaService.listAllConcessionarias(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/concessionarias/{codigoConcessionaria}", method = RequestMethod.GET)
	public ResponseEntity<Concessionaria> getConcessionaria(@PathVariable String codigoConcessionaria) {
		
		Concessionaria concessionaria =  concessionariaService.getConcessionariaById(codigoConcessionaria);
		
		return concessionaria == null ? 
				new ResponseEntity<Concessionaria>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Concessionaria>(concessionaria, HttpStatus.OK);
	}
	
	@RequestMapping(value="/concessionaria", method = RequestMethod.POST)
	public ResponseEntity<String> criarConcessionaria(@RequestBody Concessionaria produto) {

		try {
			
			concessionariaService.salvar(produto);
			
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/concessionaria/{codigoConcessionaria}", method = RequestMethod.PUT)
	public ResponseEntity<String> alterarConcessionaria(@RequestBody Concessionaria concessionaria) {
		
		try {
			
			concessionariaService.update(concessionaria);
			
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/concessionaria/{codigoConcessionaria}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletarProduto(@PathVariable String codigoConcessionaria) {
		
		try {
			
			concessionariaService.delete(codigoConcessionaria);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public ConcessionariaController() {
	}

	@RequestMapping("/")
	public List<Concessionaria> getConcessionarias() {
		return concessionariaService.listAllConcessionarias();
	}

}
