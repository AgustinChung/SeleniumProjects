package tests;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider (name = "Login exitoso")
	public Object[][] datosExitosos(){
		
		Object[][] datos = new Object[1][2];
		
		//Login exitoso
		datos[0][0] = "tomsmith";
		datos[0][1] = "SuperSecretPassword!";
		
		
		return datos;
	}
	
	@DataProvider (name = "Login fallido")
	public Object[][] datosFallido(){
		
		Object[][] datos = new Object[3][2];
		
		//Ambas campos incorrectos
		datos[0][0] = "smith";
		datos[0][1] = "password";

		//Ambos campos vacios
		datos[1][0] = " ";
		datos[1][1] = " ";
		
		//Password vacia
		datos[2][0] = "tomsmith";
		datos[2][1] = " ";
		
		return datos;
	}
	

}
