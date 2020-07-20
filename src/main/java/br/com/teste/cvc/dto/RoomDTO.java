package br.com.teste.cvc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RoomDTO {
	
	@JsonProperty("roomId")
	private int roomId;	
	
	@JsonProperty("categoryName")
	private String categoryName;
	
	@JsonProperty("price")
	private PriceDTO price;
	
}
