package com.automationpractice.pages.manejarcarritodecompras;

import com.automationpractice.models.Producto;
import com.automationpractice.pages.common.AccionesComunesEnPaginas;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class ManejarCarritoDeComprasPage extends AccionesComunesEnPaginas {

    public static final Logger LOGGER = Logger.getLogger(ManejarCarritoDeComprasPage.class);

    private String[] arrayDeProductos;
    private String[] productoSingular = {""};
    private Producto producto;
    private ArrayList<Producto> listaDeProductos = new ArrayList<Producto>();

    @CacheLookup
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    WebElement linkCarritoDeCompras;

    @CacheLookup
    @FindBy(id = "layer_cart_product_price")
    WebElement textoPrecioProducto;

    @CacheLookup
    @FindBy(id = "layer_cart_product_quantity")
    WebElement textoCantidadProducto;

    @CacheLookup
    @FindBy(xpath = "//span[@title='Continue shopping']")
    WebElement botonContinuarComprando;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement botonIrAlCheckout;

    public ManejarCarritoDeComprasPage(WebDriver driver) {
        super(driver);
        pageFactoryInitElement(driver, this);
    }

    public ManejarCarritoDeComprasPage(WebDriver driver, int seconds, boolean explicitTime) {
        super(driver, seconds, explicitTime);
        pageFactoryInitElement(driver, this);
    }

    public ArrayList<Producto> comprandoProductos(String productos) {
        if (productos.contains(",")) {
            arrayDeProductos = productos.split(",");
        } else {
            productoSingular[0] = productos;
            arrayDeProductos = productoSingular;
        }
        for (int i = 0; i < arrayDeProductos.length; i++) {
            producto = new Producto();
            producto.setNombreProducto(arrayDeProductos[i]);
            moveMouseOver(driver.findElement(By.xpath("//a[@title='"+arrayDeProductos[i]+"']")));
            clickOn(driver.findElement(By.xpath("//a[contains(text(), '"+arrayDeProductos[i]+"')]//parent::h5//following-sibling::div[@class='button-container']/a[@title='Add to cart']")));
            scrollOn(textoPrecioProducto);
            //producto.setCostoProducto(Double.parseDouble(textoPrecioProducto.getText().replace("$","").trim()));
            //producto.setCantidadProducto((producto.getCantidadProducto()+Integer.parseInt(textoCantidadProducto.getText().trim())));
            listaDeProductos.add(i, producto);
            if(i < (arrayDeProductos.length-1)){
                withExplicitWaitClickOn(botonContinuarComprando);
            } else {
                withExplicitWaitClickOn(botonIrAlCheckout);
            }
        }
        withExplicitWaitClickOn(linkCarritoDeCompras);
        return listaDeProductos;
    }
}
