package br.com.teste.cvc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrcamentoDTO {
	
	@JsonProperty("id _hotel")
	private int idHotel;
	
	@JsonProperty("data_inicio")
	private String dataInicio;
	
	@JsonProperty("data_fim")
	private String dataFim;
	
	@JsonProperty("qtd_adultos")
	private int qtdAdultos;
	
	@JsonProperty("qtd_criancas")
	private int qtdCriancas;
	
}
