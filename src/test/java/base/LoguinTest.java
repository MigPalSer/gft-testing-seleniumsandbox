package base;

import pages.LoguinPeich;
import pages.SequiurEireaPeich;

public class LoguinTest extends BaseTest2 {

	public void loguinExitoso() {
		LoguinPeich lp=jomPeich.clickFormAuthentication();
		
		lp.setUsername("tomsmith");
		lp.setPassword("SuperSecretPassword!");
		SequiurEireaPeich sap=lp.clickLoginButton();
		
	}
	
	public static void main(String[] args) {
		LoguinTest lt=new LoguinTest();
		lt.setUp();
		lt.loguinExitoso();
		
	}
	
}
