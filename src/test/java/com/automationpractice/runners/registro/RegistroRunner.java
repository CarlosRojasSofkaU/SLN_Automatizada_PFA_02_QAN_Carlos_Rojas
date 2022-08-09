package com.automationpractice.runners.registro;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/registro.feature"},
        glue = {"com.automationpractice.definitions.registro"},
        tags = ""
)
public class RegistroRunner {
}
