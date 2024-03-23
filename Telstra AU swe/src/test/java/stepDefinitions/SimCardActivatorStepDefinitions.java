package stepDefinitions;

import au.com.telstra.simcardactivator.SimCardActivator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.assertEquals;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    String iccid;
    String customer_email;
    ResponseEntity<String> response;

    @Autowired
    private TestRestTemplate restTemplate;

    @Given("^the ICCID \"([^\"]*)\" and customer email \"([^\"]*)\"$")
    public void setCredentials(String iccid, String customer_email){
        this.iccid = iccid;
        this.customer_email = customer_email;
    }

    @When("^the sim card is activated$")
    public void activateSIM(){
        String requestBody = "{\"iccid\": \"" + iccid + "\", \"customerEmail\": \"" + customer_email + "\"}";
        try{
            response = restTemplate.postForEntity("/activate", requestBody, String.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Then("^the activation should be successful$")
    public void activationSuccessful(){
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("true", response.getBody());
    }

    @Then("^the activation should fail$")
    public void activationFailed(){
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("false", response.getBody());
    }

    @Given("^no ICCID provided$")
    public void noIccid(){
        this.iccid = null;
    }

    @When("^the sim card activation request is sent$")
    public void sendSimCardActivationRequest(){
        String requestBody = "{\"iccid\": \"" + iccid + "\", \"customerEmail\": \"" + customer_email + "\"}";
        try{
            response = restTemplate.postForEntity("/activate", requestBody, String.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
