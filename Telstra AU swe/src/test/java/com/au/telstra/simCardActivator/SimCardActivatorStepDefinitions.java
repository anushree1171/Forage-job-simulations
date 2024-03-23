package com.au.telstra.simCardActivator;

import com.au.telstra.simCardActivator.dto.SIMCardDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@CucumberContextConfiguration
@ContextConfiguration(classes = SimCardActivatorApplication.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {

	RestTemplate restTemplate = new RestTemplate();

	SIMCardDto simCard;

	@Given("a functional sim card")
	public void functionalSim(){
		simCard = SIMCardDto.builder().iccid("1255789453849037777").customer_email("validCustomer@email.com").build();
	}

	@Given("a broken sim card")
	public void brokenSim(){
		simCard = SIMCardDto.builder().iccid("8944500102198304826").customer_email("brokenUser@email.com").build();
	}

	@When("a request to activate sim card is submitted")
	public void requestSubmitted(){
		this.restTemplate.postForObject("http://localhost:8080/activate/", simCard, String.class);
	}

	@Then("the activation is successful and is recorded in the database")
	public void activationSuccessful(){
		ResponseEntity<SIMCardDto> response = this.restTemplate
				.getForEntity("http://localhost:8080/api/getById/{id}", SIMCardDto.class, 1);
		System.out.println(response);

		if(response.getBody().getStatus().equalsIgnoreCase("active")){
			assertTrue(true);
		}
		else{
            fail();
		}
	}

	@Then("the activation is fails and is recorded in the database")
	public void activationFailed(){
		ResponseEntity<SIMCardDto> response = this.restTemplate
				.getForEntity("http://localhost:8080/api/getById/{id}", SIMCardDto.class, 2);
		System.out.println(response);

		fail();
	}

}
