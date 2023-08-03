package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = {"stepDefinition"},
        plugin = {})

public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
