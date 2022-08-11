package com.automationpractice.pages.manejarcarritodecompras;

import com.automationpractice.models.Producto;
import com.automationpractice.pages.comun.AccionesComunesEnPaginas;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class ManejarCarritoDeComprasPage extends AccionesComunesEnPaginas {

    public static final Logger LOGGER = Logger.getLogger(ManejarCarritoDeComprasPage.class);
    private String[] productoSingular = {""};
    private ArrayList<Producto> listaDeProductos = new ArrayList<>();
    private String localizadorPrecio = "//parent::p//parent::td//following-sibling::td[@class='cart_unit']/span/span";
    private String localizadorCantidad = "//parent::p//parent::td//following-sibling::td[@class='cart_quantity text-center']/input";
    private String localizadorBtnAlCarrito = "//parent::h5//following-sibling::div[@class='button-container']/a[@title='Add to cart']";
    private double precioTotalProductos = 0;
    private double precioTotalCompra = 0;

    @CacheLookup
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    WebElement linkCarritoDeCompras;

    @CacheLookup
    @FindBy(xpath = "//span[@title='Continue shopping']")
    WebElement botonContinuarComprando;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement botonIrAlCheckout;

    @CacheLookup
    @FindBy(id = "total_shipping")
    WebElement textoPrecioEnvio;

    @CacheLookup
    @FindBy(id = "total_product")
    WebElement textoPrecioProductos;

    @CacheLookup
    @FindBy(id = "total_tax")
    WebElement textoPrecioImpuestos;

    @CacheLookup
    @FindBy(id = "total_price")
    WebElement textoPrecioAbsoluto;

    @CacheLookup
    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    WebElement botonHaciaCheckoutEntrega;

    @CacheLookup
    @FindBy(name = "processAddress")
    WebElement botonContinuarConElCheckout;

    @CacheLookup
    @FindBy(xpath = "//label[@for='cgv']")
    WebElement botonCheckAceptarTerminosDeServicio;

    @CacheLookup
    @FindBy(xpath = "//button[@name='processCarrier']")
    WebElement botonFinalizarCheckout;

    @CacheLookup
    @FindBy(className = "bankwire")
    WebElement botonPagarConTarjeta;

    @CacheLookup
    @FindBy(id = "amount")
    WebElement textoPrecioAPagar;

    @CacheLookup
    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    WebElement botonConfirmarPedido;

    @CacheLookup
    @FindBy(xpath = "//span[@class='price']/strong")
    WebElement textoPrecioPagado;

    public ManejarCarritoDeComprasPage(WebDriver driver) {
        super(driver);
        pageFactoryInitElement(driver, this);
    }

    public ManejarCarritoDeComprasPage(WebDriver driver, int seconds, boolean explicitTime) {
        super(driver, seconds, explicitTime);
        pageFactoryInitElement(driver, this);
    }

    public ArrayList<Producto> seleccionandoProductos(String productos) {
        String[] arrayDeProductos;
        if (productos.contains(",")) {
            arrayDeProductos = productos.split(",");
        } else {
            productoSingular[0] = productos;
            arrayDeProductos = productoSingular;
        }
        for (int i = 0; i < arrayDeProductos.length; i++) {
            withExplicitWaitUntilIsNotVisible(By.xpath("//span[@title='Continue shopping']"));
            arrayDeProductos[i] = arrayDeProductos[i].trim();
            Producto producto = new Producto();
            producto.setNombreProducto(arrayDeProductos[i]);
            moveMouseOver(driver.findElement(By.xpath("//a[@title='" + arrayDeProductos[i] + "']")));
            clickOn(driver.findElement(By.xpath("//a[contains(text(), '" + arrayDeProductos[i] + "')]" + localizadorBtnAlCarrito)));
            listaDeProductos.add(i, producto);
            if (i < (arrayDeProductos.length - 1)) {
                withExplicitWaitClickOn(botonContinuarComprando);
            } else {
                withExplicitWaitClickOn(botonIrAlCheckout);
            }
        }
        withExplicitWaitClickOn(linkCarritoDeCompras);
        return listaDeProductos;
    }

    public double verificandoProductos(ArrayList<Producto> listaProductos) {
        for (int i = 0; i < listaDeProductos.size(); i++) {
            String localizadorProducto = "//p[@class='product-name']/a[contains(text(), '" + listaProductos.get(i).getNombreProducto() + "')]";
            WebElement elementoPrecio = driver.findElement(By.xpath(localizadorProducto + localizadorPrecio));
            WebElement elementoCantidad = driver.findElement(By.xpath(localizadorProducto + localizadorCantidad));
            scrollOn(elementoPrecio);
            listaProductos.get(i).setCostoProducto(Double.parseDouble(elementoPrecio.getText().replace("$", "")));
            listaProductos.get(i).setCantidadProducto(Integer.parseInt(elementoCantidad.getAttribute("value")));
            precioTotalProductos += listaProductos.get(i).getCostoProducto() * listaProductos.get(i).getCantidadProducto();
            precioTotalProductos = Math.round(precioTotalProductos * 100.0) / 100.0;
        }
        if (precioTotalProductos == Double.parseDouble(textoPrecioProductos.getText().replace("$", ""))) {
            precioTotalCompra = (
                    precioTotalProductos
                            + Double.parseDouble(textoPrecioImpuestos.getText().replace("$", ""))
                            + Double.parseDouble(textoPrecioEnvio.getText().replace("$", ""))
            );
        }
        if (precioTotalCompra == Double.parseDouble(textoPrecioAbsoluto.getText().replace("$", ""))) {
            return precioTotalCompra;
        } else {
            return 0;
        }
    }

    public void realizandoCheckoutYComprandoProductos(double precioFinalCompra) {
        scrollOn(botonHaciaCheckoutEntrega);
        withExplicitWaitClickOn(botonHaciaCheckoutEntrega);
        scrollOn(botonContinuarConElCheckout);
        withExplicitWaitClickOn(botonContinuarConElCheckout);
        scrollOn(botonCheckAceptarTerminosDeServicio);
        withExplicitWaitClickOn(botonCheckAceptarTerminosDeServicio);
        scrollOn(botonFinalizarCheckout);
        withExplicitWaitClickOn(botonFinalizarCheckout);
        scrollOn(botonPagarConTarjeta);
        withExplicitWaitClickOn(botonPagarConTarjeta);
        if (precioFinalCompra == Double.parseDouble(textoPrecioAPagar.getText().replace("$", ""))) {
            scrollOn(botonConfirmarPedido);
            withExplicitWaitClickOn(botonConfirmarPedido);
        } else {
            LOGGER.info("El precio total: $" + precioFinalCompra + " no corresponde con el que se muestra en pantalla: " + textoPrecioAPagar.getText());
            Assertions.fail();
        }
    }

    public double fuePagadoElPrecioCorrecto() {
        return Double.parseDouble(textoPrecioPagado.getText().replace("$", "").trim());
    }
}
