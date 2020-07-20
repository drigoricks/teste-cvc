package br.com.teste.cvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.teste.cvc.dto.HotelDTO;
import junit.framework.Assert;


@SpringBootTest
class ApplicationControllerTests {

	@TestConfiguration
    static class TestRestTemplateAuthenticationConfiguration {
		
		@Value("${url.base}")
		private String urlBase;

    }

	@Test
	public void testGetAllHoteis() {

		int idCidade = 7110;

		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<?> response = testRestTemplate
				.getForEntity("http://localhost:8080/cvc/consulta/hoteis/" + idCidade, HotelDTO[].class);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);

	}

	@Test
	public void testGetHotel() {

		int idHotel = 46;

		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<?> response = testRestTemplate
				.getForEntity("http://localhost:8080/cvc/consulta/hoteis/descricao/"+ idHotel, HotelDTO[].class);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);

	}

}
