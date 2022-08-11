package com.automationpractice.runners.registro;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/registro.feature"},
        glue = {"com.automationpractice.definitions.registro"},
        tags = ""
)
public class RegistroRunner {
}
