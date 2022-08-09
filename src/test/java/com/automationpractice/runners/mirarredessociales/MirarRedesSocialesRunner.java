package com.automationpractice.runners.mirarredessociales;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/mirar_redes_sociales.feature"},
        glue = {"com.automationpractice.definitions.mirarredessociales"},
        tags = ""
)
public class MirarRedesSocialesRunner {
}
