package com.automationpractice.pages.registro;

import com.automationpractice.models.Cliente;
import com.automationpractice.pages.comun.AccionesComunesEnPaginas;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegistroPage extends AccionesComunesEnPaginas {

    public static final Logger LOGGER = Logger.getLogger(RegistroPage.class);
    private Cliente cliente;

    @CacheLookup
    @FindBy(id = "email_create")
    WebElement ingresoCorreo;

    @CacheLookup
    @FindBy(id = "SubmitCreate")
    WebElement botonCrearCuenta;

    @CacheLookup
    @FindBy(id = "uniform-id_gender1")
    WebElement botonRedondoMr;

    @CacheLookup
    @FindBy(id = "uniform-id_gender2")
    WebElement botonRedondoMrs;

    @CacheLookup
    @FindBy(id = "customer_firstname")
    WebElement ingresoNombre;

    @CacheLookup
    @FindBy(id = "customer_lastname")
    WebElement ingresoApellido;

    @CacheLookup
    @FindBy(id = "passwd")
    WebElement ingresoContrasena;

    @CacheLookup
    @FindBy(id = "days")
    WebElement opcionDia;

    @CacheLookup
    @FindBy(id = "months")
    WebElement opcionMes;

    @CacheLookup
    @FindBy(id = "years")
    WebElement opcionAnos;

    @CacheLookup
    @FindBy(id = "newsletter")
    WebElement checkNoticias;

    @CacheLookup
    @FindBy(id = "optin")
    WebElement checkOfertas;

    @CacheLookup
    @FindBy(id = "firstname")
    WebElement firstNameAddress;

    @CacheLookup
    @FindBy(id = "lastname")
    WebElement lastNameAddress;

    @CacheLookup
    @FindBy(id = "company")
    WebElement ingresoCompania;

    @CacheLookup
    @FindBy(id = "address1")
    WebElement ingresoDireccion;

    @CacheLookup
    @FindBy(id = "city")
    WebElement ingresoCiudad;

    @CacheLookup
    @FindBy(id = "id_state")
    WebElement opcionEstado;

    @CacheLookup
    @FindBy(id = "postcode")
    WebElement ingresoCodigoPostal;

    @CacheLookup
    @FindBy(id = "id_country")
    WebElement opcionPais;

    @CacheLookup
    @FindBy(id = "other")
    WebElement ingresoOtraInformacion;

    @CacheLookup
    @FindBy(id = "phone")
    WebElement ingresoTelefono;

    @CacheLookup
    @FindBy(id = "phone_mobile")
    WebElement ingresoCelular;

    @CacheLookup
    @FindBy(id = "alias")
    WebElement ingresoAlias;

    @CacheLookup
    @FindBy(id = "submitAccount")
    WebElement botonRegistro;

    @CacheLookup
    @FindBy(className = "account")
    WebElement textoNombreCliente;

    public RegistroPage(WebDriver driver, Cliente cliente) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.cliente = cliente;
    }

    public RegistroPage(WebDriver driver, int seconds, boolean explicitTime, Cliente cliente) {
        super(driver, seconds, explicitTime);
        pageFactoryInitElement(driver, this);
        this.cliente = cliente;
    }

    public void crearUnaCuenta() {
        withExplicitWaitTypeOn(ingresoCorreo, cliente.getEmail());
        withExplicitWaitClickOn(botonCrearCuenta);
        withExplicitWaitClickOn(botonRedondoMr);
        scrollOn(ingresoNombre);
        withExplicitWaitTypeOn(ingresoNombre, cliente.getNombre());
        scrollOn(ingresoApellido);
        withExplicitWaitTypeOn(ingresoApellido, cliente.getApellido());
        scrollOn(ingresoContrasena);
        withExplicitWaitTypeOn(ingresoContrasena, cliente.getContrasena());
        scrollOn(opcionDia);
        selectFromOptionsByValue(opcionDia, cliente.getDiaNacimiento());
        scrollOn(opcionMes);
        selectFromOptionsByValue(opcionMes, cliente.getMesNacimiento());
        scrollOn(opcionAnos);
        selectFromOptionsByValue(opcionAnos, cliente.getAnoNacimiento());
        scrollOn(ingresoDireccion);
        withExplicitWaitTypeOn(ingresoDireccion, cliente.getDireccion());
        scrollOn(ingresoCiudad);
        withExplicitWaitTypeOn(ingresoCiudad, cliente.getCiudad());
        scrollOn(opcionEstado);
        selectFromOptionsByText(opcionEstado, cliente.getEstado());
        scrollOn(ingresoCodigoPostal);
        withExplicitWaitTypeOn(ingresoCodigoPostal, cliente.getCodigoPostal());
        scrollOn(ingresoCelular);
        withExplicitWaitTypeOn(ingresoCelular, cliente.getCelular());
        scrollOn(botonRegistro);
        withExplicitWaitClickOn(botonRegistro);
    }

    public String seRegistroLaCuentaConExito() {
        return textoNombreCliente.getText().trim();
    }
}
