package br.com.teste.cvc.dto;

import 	com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class HotelDTO {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("cityCode")
	private int cityCode;
	
	@JsonProperty("cityName")
	private String cityName;
	
	@JsonProperty("rooms")
	private RoomDTO[] room;
	
}
