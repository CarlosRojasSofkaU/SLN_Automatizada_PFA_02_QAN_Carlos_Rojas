package com.automationpractice.pages.inicio;

import com.automationpractice.models.Cliente;
import com.automationpractice.models.Producto;
import com.automationpractice.pages.common.AccionesComunesEnPaginas;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class InicioPage extends AccionesComunesEnPaginas {

    public static final Logger LOGGER = Logger.getLogger(InicioPage.class);

    @CacheLookup
    @FindBy(css = ".login")
    WebElement linkIniciarSesion;

    @CacheLookup
    @FindBy(id = "contact-link")
    WebElement linkContactanos;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Women']")
    WebElement linkProductosMujer;

    public InicioPage(WebDriver driver) {
        super(driver);
        pageFactoryInitElement(driver, this);
    }

    public InicioPage(WebDriver driver, int seconds, boolean explicitTime) {
        super(driver, seconds, explicitTime);
        pageFactoryInitElement(driver, this);
    }

    public void irHaciaIniciarSesion() {
        withExplicitWaitClickOn(linkIniciarSesion);
    }

    public void irHaciaContactanos() {
        withExplicitWaitClickOn(linkContactanos);
    }

    public void irHaciaProductosDeMujer() {
        withExplicitWaitClickOn(linkProductosMujer);
    }
}
