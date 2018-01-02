package xmlparser;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/res/features/merger"},
        glue = "xmlparser")

public class MergerCucumberTest {
}
