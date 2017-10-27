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

public class FileManagerDeleteTest {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    Map<String, Object> jsonAsMap;

    @Given("^I have typed in 2 in the line box$")
    public void putInLine(){
        jsonAsMap = new HashMap<>();
        jsonAsMap.put("locationInFile", "2");
        request = given().contentType(ContentType.JSON).body(jsonAsMap);
    }

    @When("^I press the submit button to submit 2$")
    public void deleteLine() {

        response = request.when().delete("http://localhost:8080/content/customer");

    }

    @Then("^the line number equals to the input should be removed from to the file$")
    public void validateDeleteLine(){
        json = response.then().statusCode(200);
    }


    @Given("^I have typed in @a in the line box$")
    public void putInInvalidLine(){
        jsonAsMap = new HashMap<>();
        jsonAsMap.put("locationInFile", "@");
        request = given().contentType(ContentType.JSON).body(jsonAsMap);
    }

    @When("^I press the submit button to submit @a$")
    public void deleteInvalidLine() {
//        jsonAsMap.put("line", "@a");

        response = request.when().delete("http://localhost:8080/content/customer");


    }

    @Then("^a line equals to Aeron should not be added to the file$")
    public void validateDeleteInvalidLine(){
        json = response.then().statusCode(400);
    }

}

