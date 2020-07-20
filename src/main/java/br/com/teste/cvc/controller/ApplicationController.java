package br.com.teste.cvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.cvc.dto.HotelDTO;
import br.com.teste.cvc.dto.OrcamentoDTO;
import br.com.teste.cvc.service.ApplicationService;

@Controller
@RestController
@RequestMapping({ "/cvc" })
public class ApplicationController {

	@Autowired
	ApplicationService appService;

	@GetMapping(value = "/consulta/hoteis/{id_cidade}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultaHoteis(@PathVariable("id_cidade") int idCidade) { 
		return new ResponseEntity<List<HotelDTO>>(appService.consomeTodosHoteis(idCidade), HttpStatus.OK);
	}

	@GetMapping(value = "/consulta/hoteis/descricao/{id_hotel}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultaDadosHotel(@PathVariable("id_hotel") int idHotel) {
		return new ResponseEntity<List<HotelDTO>>(appService.consomeDetalhesHotel(idHotel), HttpStatus.OK);
	}
	
	@PostMapping(value = "/orcamento/hotel", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> orcamentoEstadiaHotel(@RequestBody OrcamentoDTO orcamento) {
		return new ResponseEntity<List<HotelDTO>>(appService.orcamentoEstadiaHotel(orcamento), HttpStatus.OK);
	}

}
