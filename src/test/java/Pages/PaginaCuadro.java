package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaginaCuadro {
    private WebDriver controlador;

    private By homeCheckbox = By.cssSelector("span.rc-tree-checkbox"); 
    private By resultado = By.id("result");

    public PaginaCuadro(WebDriver driver) { this.controlador = driver; }
    
    public void clickHome() { 
        WebDriverWait wait = new WebDriverWait(controlador, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homeCheckbox)).click(); 
    }
    
    public String getResult() { 
        WebDriverWait wait = new WebDriverWait(controlador, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultado)).getText(); 
    }
}