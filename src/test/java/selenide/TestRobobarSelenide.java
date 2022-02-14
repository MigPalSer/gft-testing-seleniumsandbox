package selenide;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.codeborne.selenide.WebDriverRunner;

import robobar_selenide.LandinPeichSelenide;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TestRobobarSelenide {

	private LandinPeichSelenide landing;
	
	@BeforeEach
	public void setUp() {
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	    open("https://migpalser.github.io/robobar-example/#!/");
	    landing=new LandinPeichSelenide();
	}
	
	@Test
	public void tituloTest() {
		String titulo="Robobar - Futuristic drinks";
		assertTrue(titulo.equals(WebDriverRunner.getWebDriver().getTitle()));
	}
	
	
    @ParameterizedTest
    @CsvFileSource(resources = "/robovalorestest.csv")
	public void valoresTest(int coca, int birra, int vinata, String cuenta) {
    	 landing.clickCola(coca);
    	 
    	for (int i = 0; i < birra; i++) {
    		landing.clickBeer();			
		}
    	for (int i = 0; i < vinata; i++) {
    		landing.clickWine();			
		}
    	
		assertTrue(landing.valorActual().equals("€"+cuenta));
	}
	
	@Test
	public void habilitacionOrderTest() {
		assertTrue(landing.orderIsDisabled());
		landing.clickCola();
		assertTrue(!landing.orderIsDisabled());
	}
	
    @ParameterizedTest
    @CsvFileSource(resources = "/edadtest.csv")
	public void edadTest(int coca, int birra, int vinata, int edad, boolean exito) {
    	for (int i = 0; i < coca; i++) {
    		landing.clickCola();			
		}
    	for (int i = 0; i < birra; i++) {
    		landing.clickBeer();			
		}
    	for (int i = 0; i < vinata; i++) {
    		landing.clickWine();			
		}
    	landing.clickOrder();
    	
    	if(birra>0||vinata>0) {
    	landing.introducirEdad(edad);
    	}
    	
    	landing.clickOrder();
    	
    	if(exito) {
    		assertTrue(landing.orderSuccess());
    	}else {
    		assertFalse(landing.orderSuccess());
    	}
		
	}
}
