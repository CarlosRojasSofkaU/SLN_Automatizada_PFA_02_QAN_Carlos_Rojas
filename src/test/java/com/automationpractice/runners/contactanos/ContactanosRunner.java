package com.automationpractice.runners.contactanos;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/contactanos.feature"},
        glue = {"com.automationpractice.definitions.contactanos"},
        tags = ""
)
public class ContactanosRunner {
}
