package br.com.teste.cvc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PriceDTO {
	
	@JsonProperty("adult")
	private Double valor_adulto;
	
	@JsonProperty("child")
	private Double valor_crianca;
	
}
