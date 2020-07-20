package br.com.teste.cvc.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.teste.cvc.commons.util.Utils;
import br.com.teste.cvc.dto.HotelDTO;
import br.com.teste.cvc.dto.OrcamentoDTO;
import br.com.teste.cvc.dto.PriceDTO;
import br.com.teste.cvc.dto.RoomDTO;

@Service
public class ApplicationService {

	@Value("${url.base}")
	private String urlBase;
	
	@Cacheable("todosHoteis")
	public List<HotelDTO> consomeTodosHoteis(int idCidade) {
		RestTemplate template = new RestTemplate();
		List<HotelDTO> dadosHoteis = Arrays.asList(template.getForObject(urlBase + "/avail/" + idCidade, HotelDTO[].class));
		return dadosHoteis;
	}

	@Cacheable("detalhesHotel")
	public List<HotelDTO> consomeDetalhesHotel(int idHotel) {
		RestTemplate template = new RestTemplate();
		List<HotelDTO> dadosHotel = Arrays.asList(template.getForObject(urlBase + "/" + idHotel, HotelDTO[].class));
		return dadosHotel;
	}
	
	public List<HotelDTO> orcamentoEstadiaHotel(OrcamentoDTO orcamento) {
		
		Utils util = new Utils();
		//Descubro qtd de dias de estadia
		int diasEstadia = util.calculaQtdDiasEntreDatas(orcamento.getDataInicio(),orcamento.getDataFim());
		
		//Recupero os dados do hotel escolhido
		List<HotelDTO> dadosHotel = consomeDetalhesHotel(orcamento.getIdHotel());
		
		for(HotelDTO hotel : dadosHotel) {
			List<RoomDTO> quartos = Arrays.asList(hotel.getRoom());
			for(RoomDTO quarto : quartos) {
				PriceDTO preco = quarto.getPrice();
				preco.setValor_adulto(util.calculaPeriodoEstadia(diasEstadia,preco.getValor_adulto()));
				preco.setValor_crianca(util.calculaPeriodoEstadia(diasEstadia, preco.getValor_crianca()));
				quarto.setPrice(preco);
			}
		}
		return dadosHotel;
	}	
	
}
