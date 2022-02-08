package junit;


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

import robobar.LandinPeich;

public class TestRobobar {

	private WebDriver driver;
	private LandinPeich landing;
	
	@BeforeEach
	public void setUp() {
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://migpalser.github.io/robobar-example/#!/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	    landing=new LandinPeich(driver);
	}
	
	@AfterEach
	public void end() {
		driver.quit();
	}
	
	@Test
	public void tituloTest() {
		String titulo="Robobar - Futuristic drinks";
		assertTrue(titulo.equals(driver.getTitle()));
	}
	
	
    @ParameterizedTest
    @CsvFileSource(resources = "/robovalorestest.csv")
	public void valoresTest(int coca, int birra, int vinata, String cuenta) {
    	for (int i = 0; i < coca; i++) {
    		landing.clickCola();			
		}
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
