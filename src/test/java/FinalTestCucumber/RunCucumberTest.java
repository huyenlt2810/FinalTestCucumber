package FinalTestCucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/report.html", "json:target/report.json"}, glue = "stepDefinition")
public class RunCucumberTest {

}
