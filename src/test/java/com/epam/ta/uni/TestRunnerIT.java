package com.epam.ta.uni;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.epam.ta.uni",
        stepNotifications = true,
        plugin = {"pretty", "html:target/test-report.html"}
)
public class TestRunnerIT {

}
