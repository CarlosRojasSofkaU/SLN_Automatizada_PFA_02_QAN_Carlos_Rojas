package com.automationpractice.runners.mirarproductos;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/mirar_productos.feature"},
        glue = {"com.automationpractice.definitions.mirarproductos"},
        tags = ""
)
public class MirarProductosRunner {
}
