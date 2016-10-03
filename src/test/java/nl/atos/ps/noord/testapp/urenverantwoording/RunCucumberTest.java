package nl.atos.ps.noord.testapp.urenverantwoording;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Vincent Free on 23-3-2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/",
        plugin = {"html:target/cukes", "json:target/cucumber/tests.cucumber","json:target/cucumber.json"})
public class RunCucumberTest {
}
