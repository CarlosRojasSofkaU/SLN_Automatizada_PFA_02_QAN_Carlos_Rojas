package com.automationpractice.definitions.manejarcarritodecompras;

import com.automationpractice.definitions.configuracion.WebUI;
import com.automationpractice.models.Cliente;
import com.automationpractice.models.Producto;
import com.automationpractice.pages.inicio.InicioPage;
import com.automationpractice.pages.manejarcarritodecompras.ManejarCarritoDeComprasPage;
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

import java.util.ArrayList;

import static com.automationpractice.utils.Constantes.*;
import static com.automationpractice.utils.Utilidades.generarCliente;

public class ManejarCarritoDeComprasDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(ManejarCarritoDeComprasDefinition.class);
    private InicioPage inicioPage;
    private ManejarCarritoDeComprasPage manejarCarritoDeComprasPage;
    private double precioTotal = 0;
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

    @Dado("que el cliente se haya registrado o logueado en la plataforma")
    public void queElClienteSeHayaRegistradoOLogueadoEnLaPlataforma() {
        try {
            inicioPage = new InicioPage(driver, ESPERA_EXPLICITA_POR_DEFECTO, CON_ESPERA_EXPLICITA);
            inicioPage.irHaciaIniciarSesion();
            LOGGER.info("Navegando hacia registro");
            Cliente cliente = generarCliente(CODIGO_DE_LENGUAJE_ESPANOL, CODIGO_PAIS, DOMINIO_EMAIL);
            LOGGER.info("La Información del usuario fue creada con correo: " + cliente.getEmail() + " y con contraseña: " + cliente.getContrasena());
            RegistroPage registroPage = new RegistroPage(driver, ESPERA_EXPLICITA_POR_DEFECTO, CON_ESPERA_EXPLICITA, cliente);
            registroPage.crearUnaCuenta();
            LOGGER.info("El registro fue exitoso");
        } catch (Exception e) {
            LOGGER.info("Error en paso DADO:" + e.getMessage());
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage(), e);
        }
    }

    @Cuando("el cliente quiere comprar uno o varios productos {string} y realiza todas las funciones de verificacion")
    public void elClienteQuiereComprarUnoOVariosProductosYRealizaTodasLasFuncionesDeVerificacion(String productos) {
        try {
            inicioPage.irHaciaProductosDeMujer();
            manejarCarritoDeComprasPage = new ManejarCarritoDeComprasPage(driver, ESPERA_EXPLICITA_POR_DEFECTO, CON_ESPERA_EXPLICITA);
            ArrayList<Producto> listaProductos = manejarCarritoDeComprasPage.seleccionandoProductos(productos);
            LOGGER.info("Se seleccionaron los productos a comprar exitosamente");
            precioTotal = manejarCarritoDeComprasPage.verificandoProductos(listaProductos);
            LOGGER.info("Se verificó el precio y los productos comprados exitosamente");
            manejarCarritoDeComprasPage.realizandoCheckoutYComprandoProductos(precioTotal);
            LOGGER.info("Se realizó el checkout y el método de pago de los productos");
        } catch (Exception e) {
            LOGGER.info("Error en paso Cuando:" + e.getMessage());
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage(), e);
        }
    }

    @Entonces("el cliente observara el precio de la orden de sus productos.")
    public void elClienteObservaraElPrecioDeLaOrdenDeSusProductos() {
        try {
            Assertions.assertEquals(precioTotal, manejarCarritoDeComprasPage.fuePagadoElPrecioCorrecto());
            LOGGER.info(
                    "El usuario debe observar que su compra tiene un precio de: " + precioTotal + ", y observa: " + manejarCarritoDeComprasPage.fuePagadoElPrecioCorrecto()
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

    @Dado("el cliente selecciono uno o varios productos {string} de la pagina")
    public void elClienteSeleccionoUnoOVariosProductosDeLaPagina(String productos) {
        throw new io.cucumber.java.PendingException();
    }

    @Cuando("el cliente quiere eliminar sus productos {string} del carrito de compras")
    public void elClienteQuiereEliminarSusProductosDelCarritoDeCompras(String productos) {
        throw new io.cucumber.java.PendingException();
    }

    @Entonces("el cliente observara que el carrito de compras esta vacio.")
    public void elClienteObservaraQueElCarritoDeComprasEstaVacio() {
        throw new io.cucumber.java.PendingException();
    }
}
