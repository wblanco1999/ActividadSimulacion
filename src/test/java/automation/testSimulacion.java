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

    
    @After
    public void tearDown() {
        if (driver != null) {
            try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
            driver.quit();
        }
    }

}