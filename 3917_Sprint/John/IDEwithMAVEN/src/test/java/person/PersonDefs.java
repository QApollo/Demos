package person;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import person.Person;


public class PersonDefs {

    private Person person;
    private boolean isHomeless;

    @Given("^a person without an address$")
    public void aPersonWithoutAnAddress() throws Throwable {
        person = new Person("john", null);
    }

    @When("^I ask the person if he is homeless$")
    public void iAskThePersonIfHeIsHomeless() throws Throwable {
        isHomeless = person.isHomeless();
    }

    @Then("^I expect the answer to be YES$")
    public void iExpectTheAnswerToBeYES() throws Throwable {
        Assertions.assertTrue(isHomeless);
    }

    @Given("^a person with an address$")
    public void aPersonWithAnAddress() throws Throwable {
        person = new Person("john", "Wall street");
    }

    @Then("^I expect the answer to be NO$")
    public void iExpectTheAnswerToBeNO() throws Throwable {
        Assertions.assertFalse(isHomeless);
    }
}
