package com.qualogy.cucumberDemo;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.runner.RunWith;


public class UserSteps {
    private User user = new User();

   @Given("^that the user (.*) is given a task to clear (.*) certification exam$")
    public void certificationName(String name, String certification) throws Throwable {
        user.setName(name);
        user.setCertification(certification);
    }

    @When("^(.*) got (\\d+) marks in exam$")
    public void gotMarks(String name, int marks) throws Throwable {
        user.setName(name);
        user.setMarks(marks);
    }

    @Then("^(.*) is known as (.*) certified$")
    public void certifiedYes(String name, String certification) throws Throwable {
            Assert.assertThat(name, Is.is(user.getName()));
            Assert.assertThat(user.getCertification(), IsEqual.equalTo("Java"));
            Assert.assertThat(user.getResult(), Is.is(true));
    }

    @Given("^that the user (.*) is going to attend (.*) certification exam$")
    public void that_the_user_Shadab_is_going_to_attend_DB_certification_exam(String name, String certification) throws Throwable {
        user.setName(name);
        user.setCertification(certification);
    }
}
