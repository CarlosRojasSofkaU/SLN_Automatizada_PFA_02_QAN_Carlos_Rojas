package com.automationpractice.runners.contactanos;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/contactanos.feature"},
        glue = {"com.automationpractice.definitions.contactanos"},
        tags = ""
)
public class ContactanosRunner {
}
