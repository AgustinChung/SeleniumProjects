package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.LogInPage;

public class LogInFallido {
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
		
		@Test (dataProvider = "Login fallido", dataProviderClass = DataProviders.class)
		public void loginFallido(String username, String password) {
			LogInPage logInPage = new LogInPage(driver);
			logInPage.ingresarUsuario(username);
			logInPage.ingresarPassword(password);
			logInPage.clickLogIn();
			//Si coinciden los valores todo OK, si no coinciden, se falla el test
			//Aca tienen que coincidir porque es un testcase negativo, o sea, no debe cambiar la url
			//ya que no logramos logearnos y por lo tanto nos mantenemos en la misma pagina
			AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
		}
		
		@AfterSuite
		public void tearDown() {
			driver.close();
		}
}
