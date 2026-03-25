package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaginaDinamica {
	
	private WebDriver driver;
    public PaginaDinamica(WebDriver controlador) { this.driver = controlador; }

    public void esperarAlBoton() {
        WebDriverWait esperar = new WebDriverWait(driver, Duration.ofSeconds(6));
        esperar.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
    }

}
