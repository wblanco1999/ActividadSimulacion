package automation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import Pages.*;

public class testSimulacion {
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "/Users/wilsonblanco/eclipse-workspace/CalidadSoft_Simulacion/src/test/resources/Driver/chromedriver");
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
    }

    @Test
    public void CP01_registroDeTexto() {
        driver.get("https://demoqa.com/text-box");
        PaginaCajaTexto page = new PaginaCajaTexto(driver);
        page.llenarFormulario("Wilson Blanco", "wblanco@fidelitas.cr");
        assertTrue(page.getResultName().contains("Wilson Blanco"));
    }

    @Test
    public void CP02_testCheckbox() {
        driver.get("https://demoqa.com/checkbox");
        PaginaCuadro page = new PaginaCuadro(driver);
        page.clickHome();
        assertTrue(page.getResult().contains("home"));
    }
    
    @Test
    public void CP03_testRadioButton() {
        driver.get("https://demoqa.com/radio-button");
        driver.findElement(By.cssSelector("label[for='yesRadio']")).click();
        assertEquals("Yes", driver.findElement(By.className("text-success")).getText());
    }

    @Test
    public void CP04_testEsperaDinamica() {
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        assertTrue(button.isEnabled());
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
            driver.quit();
        }
    }

}