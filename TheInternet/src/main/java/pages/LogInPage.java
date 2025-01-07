package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
	//ELEMENTOS WEB
	@FindBy (id = "username")
	WebElement inputUsername;
	
	@FindBy (id = "password")
	WebElement inputPassword;

	@FindBy (css = "div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example form:nth-child(3) > button.radius:nth-child(3)")
	WebElement btnLogIn;
	
	@FindBy(id = "flash-messages")
    WebElement errorMessage;
	
	//CONSTRUCTOR (hereda de BasePage)
	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	//METODOS
	public void ingresarUsuario(String username) {
        writeText(inputUsername, username);
    }
	
	public void ingresarPassword(String password) {
        writeText(inputPassword, password);
    }
	
	public void clickLogIn() {
        click(btnLogIn);
    }
	
	public boolean isErrorDisplayed() {
        return isDisplayed(errorMessage);
    }

}
