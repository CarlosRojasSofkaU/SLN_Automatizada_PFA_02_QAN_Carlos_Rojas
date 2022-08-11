package com.automationpractice.runners.mirarproductos;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/mirar_productos.feature"},
        glue = {"com.automationpractice.definitions.mirarproductos"},
        tags = ""
)
public class MirarProductosRunner {
}
