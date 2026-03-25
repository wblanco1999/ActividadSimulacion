package Pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaCajaTexto {
    private WebDriver controlador;
    private By fullName = By.id("userName");
    private By emailField = By.id("userEmail");
    private By submitBtn = By.id("submit");
    private By outputName = By.id("name");

    public PaginaCajaTexto(WebDriver controlador) { this.controlador = controlador; }
    
    public void llenarFormulario(String name, String email) {
        WebDriverWait wait = new WebDriverWait(controlador, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullName)).sendKeys(name);
        controlador.findElement(emailField).sendKeys(email);
        controlador.findElement(submitBtn).click();
    }
    
    public String getResultName() { return controlador.findElement(outputName).getText(); }
}