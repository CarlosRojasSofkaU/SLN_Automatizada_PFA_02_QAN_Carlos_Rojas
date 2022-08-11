package com.automationpractice.runners.manejarcarritodecompras;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/manejar_carrito_de_compras.feature"},
        glue = {"com.automationpractice.definitions.manejarcarritodecompras"},
        tags = "@RutaCritica"
)
public class ManejarCarritoDeComprasRunner {
}
