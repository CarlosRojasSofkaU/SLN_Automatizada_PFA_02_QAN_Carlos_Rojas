package com.automationpractice.runners.manejarcarritodecompras;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/manejar_carrito_de_compras.feature"},
        glue = {"com.automationpractice.definitions.manejarcarritodecompras"},
        tags = ""
)
public class ManejarCarritoDeComprasRunner {
}
