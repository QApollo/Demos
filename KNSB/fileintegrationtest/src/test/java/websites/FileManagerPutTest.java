package websites;

import cucumber.api.java.en.And;
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


public class FileManagerPutTest {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    Map<String, Object> jsonAsMap;

    @Given("^I have typed in 3 in the line box$")
    public void putLineNumber() {
        jsonAsMap = new HashMap<>();
        jsonAsMap.put("locationInFile", "3");
    }

    @And("^I have typed in Aeron in the name box$")
    public void putName() {

        jsonAsMap.put("surname", "aeron");
        request = given().contentType(ContentType.JSON).body(jsonAsMap);

    }


    @When("^I press the submit button to submit Aeron in line 3$")
    public void submitNameInLine() {
        response = request.when().put("http://localhost:8080/content/customer");


    }

    @Then("^a line equals to Aeron should be added to the file in the according line$")
    public void validateDeleteInvalidLine(){
        json = response.then().statusCode(200);
    }

    @Given("^I have typed in a in the line box$")
    public void putIncorrectLineNumber() {
        jsonAsMap = new HashMap<>();
        jsonAsMap.put("locationInFile", "a");
    }

    @And("^I have typed in Alfonso in the name box$")
    public void putCorrectName() {

        jsonAsMap.put("surname", "Alfonso");
        request = given().contentType(ContentType.JSON).body(jsonAsMap);

    }


    @When("^I press the submit button to submit Alfonso in an incorrect line$")
    public void submitIncorrectLine() {
        response = request.when().put("http://localhost:8080/content/customer");


    }

    @Then("^Alfonso should not be added in the file$")
    public void validatePuttingInvalidLine(){
        json = response.then().statusCode(400);
    }

    @Given("^I have typed in 4 in the line box$")
    public void putCorrectLineNumber() {
        jsonAsMap = new HashMap<>();
        jsonAsMap.put("line", "a");
    }

    @And("^I have typed in @!! in the name box$")
    public void putIncorrectName() {

        jsonAsMap.put("surname", "Alfonso");
        request = given().contentType(ContentType.JSON).body(jsonAsMap);

    }


    @When("^I press the submit button to submit an incorrect name$")
    public void submitIncorrectName() {
        response = request.when().put("http://localhost:8080/content/customer");


    }

    @Then("^@!! should be added in the file$")
    public void validatePuttingInvalidName(){
        json = response.then().statusCode(400);
    }


}
