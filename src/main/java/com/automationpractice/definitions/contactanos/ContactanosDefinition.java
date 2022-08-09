package com.automationpractice.definitions.contactanos;

import com.automationpractice.definitions.configuracion.WebUI;
import com.automationpractice.models.Cliente;
import com.automationpractice.pages.contactanos.ContactanosPage;
import com.automationpractice.pages.inicio.InicioPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.automationpractice.utils.Constantes.*;
import static com.automationpractice.utils.Utilidades.generarCliente;

public class ContactanosDefinition extends WebUI {

    private Cliente cliente;
    private InicioPage inicioPage;
    private ContactanosPage contactanosPage;
    private static final Logger LOGGER = Logger.getLogger(ContactanosDefinition.class);

    @Before
    public void configuracion() {
        try {
            setUpWebDriver();
            setUpLog4j2();
            generalSetUp();
            LOGGER.info("El navegador está funcionndo correctamente");
        } catch (Exception e) {
            LOGGER.info("Error en la configuración del navegador:" + e.getMessage());
        }
    }

    @Dado("que el cliente navega hasta la página de contáctanos")
    public void queElClienteNavegaHastaLaPáginaDeContáctanos() {
        try {
            inicioPage = new InicioPage(driver, ESPERA_EXPLICITA_POR_DEFECTO, CON_ESPERA_EXPLICITA);
            inicioPage.irHaciaContactanos();
            LOGGER.info("Navegando hacia contáctanos");
        } catch (Exception e) {
            LOGGER.info("Error en paso DADO:" + e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Cuando("el cliente ingresa todos los datos obligatorios para contactarse")
    public void elClienteIngresaTodosLosDatosObligatoriosParaContactarse() {
        try {
            cliente = generarCliente(CODIGO_DE_LENGUAJE_ESPANOL, CODIGO_PAIS, DOMINIO_EMAIL);
            LOGGER.info("La Información del usuario fue creada con exito");
            contactanosPage = new ContactanosPage(driver, ESPERA_EXPLICITA_POR_DEFECTO, CON_ESPERA_EXPLICITA, cliente);
            contactanosPage.mandarMensajeAServicioAlCliente();
            LOGGER.info("El mensaje a servicio al cliente fue enviado exitosamente");
        } catch (Exception e) {
            LOGGER.info("Error en paso Cuando:" + e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Entonces("el cliente observará un mensaje de contacto exitoso en la página web.")
    public void elClienteObservaráUnMensajeDeContactoExitosoEnLaPáginaWeb() {
        try {
            Assertions.assertEquals(MSJ_ENVIADO_EXITOSAMENTE_SERVICIO_AL_CLIENTE, contactanosPage.seMandoElMensajeExitosamente());
            LOGGER.info(
                    "El usuario debe observar un mensaje que dice: "+MSJ_ENVIADO_EXITOSAMENTE_SERVICIO_AL_CLIENTE+", y observa: " + contactanosPage.seMandoElMensajeExitosamente()
            );
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e);
            LOGGER.info("Error en paso ENTONCES:" + e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    @After
    public void cerrarSesion() {
        try {
            LOGGER.info("Apagando el navegador");
            closeDriver();
            quitDriver();
        } catch (Exception e) {
            quitDriver();
        }
    }

}
