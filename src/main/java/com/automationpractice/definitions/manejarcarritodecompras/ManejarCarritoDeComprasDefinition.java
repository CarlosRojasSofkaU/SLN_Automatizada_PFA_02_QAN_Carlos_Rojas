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
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static com.automationpractice.utils.Constantes.*;
import static com.automationpractice.utils.Utilidades.generarCliente;

public class ManejarCarritoDeComprasDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(ManejarCarritoDeComprasDefinition.class);
    private Cliente cliente;
    private RegistroPage registroPage;
    private InicioPage inicioPage;
    private ManejarCarritoDeComprasPage manejarCarritoDeComprasPage;
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    private double precioTotal = 0;

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

    @Dado("que el cliente se haya registrado o logueado en la plataforma")
    public void queElClienteSeHayaRegistradoOLogueadoEnLaPlataforma() {
        try {
            inicioPage = new InicioPage(driver, ESPERA_EXPLICITA_POR_DEFECTO, CON_ESPERA_EXPLICITA);
            inicioPage.irHaciaIniciarSesion();
            LOGGER.info("Navegando hacia registro");
            cliente = generarCliente(CODIGO_DE_LENGUAJE_ESPANOL, CODIGO_PAIS, DOMINIO_EMAIL);
            LOGGER.info("La Información del usuario fue creada con correo: " + cliente.getEmail() + " y con contraseña: " + cliente.getContrasena());
            registroPage = new RegistroPage(driver, ESPERA_EXPLICITA_POR_DEFECTO, CON_ESPERA_EXPLICITA, cliente);
            registroPage.crearUnaCuenta();
            LOGGER.info("El registro fue exitoso");
        } catch (Exception e) {
            LOGGER.info("Error en paso DADO:" + e.getMessage());
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage(), e);
        }
    }

    @Cuando("el cliente quiere comprar uno o varios productos {string} y realiza todas las funciones de verificación")
    public void elClienteQuiereComprarUnoOVariosProductosYRealizaTodasLasFuncionesDeVerificación(String productos) {
        try {
            inicioPage.irHaciaProductosDeMujer();
            manejarCarritoDeComprasPage = new ManejarCarritoDeComprasPage(driver, ESPERA_EXPLICITA_POR_DEFECTO, CON_ESPERA_EXPLICITA);
            listaProductos = manejarCarritoDeComprasPage.comprandoProductos(productos);
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

    @Entonces("el cliente observará un mensaje de solicitud de compra exitosa y un precio de orden de sus productos.")
    public void elClienteObservaráUnMensajeDeSolicitudDeCompraExitosaYUnPrecioDeOrdenDeSusProductos() {
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
}
