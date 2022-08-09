package com.automationpractice.definitions.configuracion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.automationpractice.utils.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static com.google.common.base.StandardSystemProperty.USER_DIR;

public class WebUI {
    private String os;

    private static final String AUTOMATIONPRACTICE_URL = "http://automationpractice.com/index.php";

    protected WebDriver driver;

    protected void setUpWebDriver() {
        os = System.getProperty("os.name").toLowerCase();
        WebDriverManager.chromedriver().setup();
    }

    protected void generalSetUp() {
        driver = new ChromeDriver();
        driver.get(AUTOMATIONPRACTICE_URL);
        driver.manage().window().maximize();
    }

    protected void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    protected void quitDriver() {
        driver.quit();
    }

    protected void closeDriver() {
        driver.close();
    }
}
