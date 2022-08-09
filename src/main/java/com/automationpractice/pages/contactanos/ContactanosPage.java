package com.automationpractice.pages.contactanos;

import com.automationpractice.models.Cliente;
import com.automationpractice.pages.common.AccionesComunesEnPaginas;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactanosPage extends AccionesComunesEnPaginas {

    private Cliente cliente;

    @CacheLookup
    @FindBy(id = "id_contact")
    WebElement opcionTemaContacto;

    @CacheLookup
    @FindBy(id = "email")
    WebElement ingresoCorreo;

    @CacheLookup
    @FindBy(id = "id_order")
    WebElement ingresoOrdenReferencia;

    @CacheLookup
    @FindBy(id = "fileUpload")
    WebElement ingresoSubirArchivo;

    @CacheLookup
    @FindBy(id = "message")
    WebElement ingresoMensaje;

    @CacheLookup
    @FindBy(id = "submitMessage")
    WebElement botonMandarMensaje;

    @CacheLookup
    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement textoMensajeEnviadoExitosamente;

    public ContactanosPage(WebDriver driver, Cliente cliente) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.cliente = cliente;
    }

    public ContactanosPage(WebDriver driver, int seconds, boolean explicitTime, Cliente cliente) {
        super(driver, seconds, explicitTime);
        pageFactoryInitElement(driver, this);
        this.cliente = cliente;
    }

    public void mandarMensajeAServicioAlCliente() {
        selectFromOptionsByText(opcionTemaContacto, cliente.getTemaContactanos());
        withExplicitWaitTypeOn(ingresoCorreo, cliente.getEmail());
        withExplicitWaitTypeOn(ingresoOrdenReferencia, cliente.getPedidoReferenciaContactanos());
        withExplicitWaitTypeOn(ingresoMensaje, cliente.getMensajeContactanos());
        withExplicitWaitClickOn(botonMandarMensaje);
    }

    public String seMandoElMensajeExitosamente() {
        scrollOn(textoMensajeEnviadoExitosamente);
        return textoMensajeEnviadoExitosamente.getText().trim();
    }
}
