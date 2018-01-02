import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class EatStepsDef {

    private Chicken chicken;
    private Corn corn;

    @Given("^the Chicken and the Corn$")
    public void the_Chicken_and_the_Corn() throws Throwable {
        chicken = new Chicken();
        corn = new Corn();
    }

    @When("^they are left alone$")
    public void they_are_left_alone() throws Throwable {
        chicken.checkEatNeighbour(corn);
    }

    @Then("^the Chicken should eat the Corn$")
    public void the_Chicken_should_eat_the_Corn() throws Throwable {
        Assert.assertEquals("Corn has been eaten", true, chicken.eatNeighbour);
    }

}
