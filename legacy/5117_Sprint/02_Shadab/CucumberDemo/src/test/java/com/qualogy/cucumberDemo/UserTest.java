package com.qualogy.cucumberDemo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = "pretty",
        tags = {"~@Ignore"},
        features = "src/main/resources/")   // explicitly provide feature file location
public class UserTest {

}

