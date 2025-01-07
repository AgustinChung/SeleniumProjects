package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class BasePage {
	//Protected para que las subclases puedan acceder 
    protected WebDriver driver;
	private WebDriverWait wait;

    // Constructor para inicializar el driver y esperar
    //PageFactory.initElements es responsable de analizar los campos anotados con @FindBy.
  	//Escanea tanto los elementos declarados en la clase padre como los elementos de la subclase
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    // Métodos Genéricos
    public void click(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            throw new RuntimeException("Error al hacer clic en el elemento: " + e.getMessage());
        }
    }
    
    public void writeText(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            throw new RuntimeException("Error al escribir en el elemento: " + e.getMessage());
        }
    }
    
    public String getText(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.getText();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener texto del elemento: " + e.getMessage());
        }
    }
    
    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    
    
}