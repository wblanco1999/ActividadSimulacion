package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaginaBotones {
    
    private WebDriver controlador;
    private By btnDobleClic = By.id("doubleClickBtn");
    private By mensajeDobleClic = By.id("doubleClickMessage");

    public PaginaBotones(WebDriver driver) { this.controlador = driver; }

    public void doubleClick() {
        WebElement boton = controlador.findElement(btnDobleClic);
        
        ((JavascriptExecutor) controlador).executeScript("arguments[0].scrollIntoView(true);", boton);
        
        Actions actions = new Actions(controlador);
        actions.doubleClick(boton).perform();
    }

    public String getDoubleClickMessage() { 
        WebDriverWait wait = new WebDriverWait(controlador, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeDobleClic)).getText(); 
    }
}