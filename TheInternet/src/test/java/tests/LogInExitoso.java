package tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LogInPage;

public class LogInExitoso {
	//Definir url y driver
	String url = "https://the-internet.herokuapp.com/login";
	WebDriver driver;
	
	//Setup inicial
	@BeforeSuite
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	

	@Test(dataProvider = "Login exitoso", dataProviderClass = DataProviders.class)
	public void login(String username,String password) {
		LogInPage logInPage = new LogInPage(driver);
		logInPage.ingresarUsuario(username);
		logInPage.ingresarPassword(password);
		logInPage.clickLogIn();
	}
	
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
	
	

}
