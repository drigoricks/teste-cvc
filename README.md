# Projeto CVC - TESTE	
 
 Esse projeto visa mostrar o consumo de serviço REST de forma simples, com o framework spring boot.
 
 O que esta sendo utilizado:
 
 * Spring Boot
 * JUnit
 * Guava Cache
 * Jackson 
 * Lombok
 
 Endpoints:
 
 * GET
 
 
 http://localhost:8080/cvc/consulta/hoteis/{id_cidade}
 
 http://localhost:8080/cvc/consulta/hoteis/descricao/{id_hotel}
 	 
 	 
 	
 * POST 
 
 	 
 	  http://localhost:8080/cvc/orcamento/hotel
 		Body example -> 
 		
 		```json {
				 "id _hotel": 46,
				 "data_inicio": "16/07/2020",
				 "data_fim": "30/07/2020",
				 "qtd_adultos":2,
				 "qtd_criancas":2
				}
		```		
						
						