package com.automationpractice.definitions.registro;

import com.automationpractice.definitions.configuracion.WebUI;
import com.automationpractice.models.Cliente;
import com.automationpractice.pages.inicio.InicioPage;
import com.automationpractice.pages.registro.RegistroPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Managed;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.automationpractice.utils.Constantes.*;
import static com.automationpractice.utils.Utilidades.generarCliente;

public class RegistroDefinition extends WebUI {

    private Cliente cliente;
    private RegistroPage registroPage;
    private InicioPage inicioPage;
    private static final Logger LOGGER = Logger.getLogger(RegistroDefinition.class);
    @Managed
    private WebDriver dr;

    @Before
    public void configuracion() {
        try {
            setUpWebDriver(dr);
            setUpLog4j2();
            generalSetUp();
            LOGGER.info("El navegador está funcionando correctamente");
        } catch (Exception e) {
            LOGGER.info("Error en la configuración del navegador:" + e.getMessage());
        }
    }

    @Dado("que el cliente navega hasta la pagina de registro")
    public void queElClienteNavegaHastaLaPaginaDeRegistro() {
        try {
            inicioPage = new InicioPage(driver, ESPERA_EXPLICITA_POR_DEFECTO, CON_ESPERA_EXPLICITA);
            inicioPage.irHaciaIniciarSesion();
            LOGGER.info("Navegando hacia registro");
        } catch (Exception e) {
            LOGGER.info("Error en paso DADO:" + e.getMessage());
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage(), e);
        }
    }

    @Cuando("el cliente registra sus datos para una cuenta en linea de forma exitosa")
    public void elClienteRegistraSusDatosParaUnaCuentaEnLineaDeFormaExitosa() {
        try {
            cliente = generarCliente(CODIGO_DE_LENGUAJE_ESPANOL, CODIGO_PAIS, DOMINIO_EMAIL);
            LOGGER.info("La Información del usuario fue creada con correo: " + cliente.getEmail() + " y con contraseña: " + cliente.getContrasena());
            registroPage = new RegistroPage(driver, ESPERA_EXPLICITA_POR_DEFECTO, CON_ESPERA_EXPLICITA, cliente);
            registroPage.crearUnaCuenta();
            LOGGER.info("El registro fue exitoso");
        } catch (Exception e) {
            LOGGER.info("Error en paso Cuando:" + e.getMessage());
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage(), e);
        }
    }

    @Entonces("el cliente quedara logueado dentro de su respectiva sesion per se.")
    public void elClienteQuedaraLogueadoDentroDeSuRespectivaSesionPerSe() {
        try {
            Assertions.assertEquals(cliente.getNombre() + " " + cliente.getApellido(), registroPage.seRegistroLaCuentaConExito());
            LOGGER.info(
                    "El usuario debe observar que el nombre de la cuenta es: " + cliente.getNombre() + " " + cliente.getApellido() + ", y observa: " + registroPage.seRegistroLaCuentaConExito()
            );
        } catch (Exception e) {
            LOGGER.info("Error en paso ENTONCES:" + e.getMessage());
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage(), e);
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
