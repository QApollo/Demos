package websites;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class FileManagerCreateTest {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    Map<String, Object> jsonAsMap;

    @Given("I have typed in Yung in the name box$")
    public void putInName(){
        jsonAsMap = new HashMap<>();
        jsonAsMap.put("surname", "Yung");
        request = given().contentType(ContentType.JSON).body(jsonAsMap);
    }

    @When("^I press the submit button to submit Yung$")
    public void createName() {

        response = request.when().post("http://localhost:8080/content/customer");

    }

    @Then("^a name equals to Yung should be added to the file$")
    public void validateName(){
        json = response.then().statusCode(201);
    }

    @Given("I have typed in %%% in the name box$")
    public void putInInvalidName(){
        jsonAsMap = new HashMap<>();
        jsonAsMap.put("surname", "%%%");
        request = given().contentType(ContentType.JSON).body(jsonAsMap);
    }

    @When("^I press the submit button to submit %%%$")
    public void createInvalidName() {

        response = request.when().post("http://localhost:8080/content/customer");

    }

    @Then("^%%% should not be added to the file$")
    public void validateInvalidName(){
        json = response.then().statusCode(400);
    }



}

