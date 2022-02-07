package junit;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import robobar.LandinPeich;

public class TestRobobar {

	private WebDriver driver;
	private LandinPeich landing;
	
	@Before
	public void setUp() {
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://migpalser.github.io/robobar-example/#!/");
	    landing=new LandinPeich(driver);
	}
	
	@After
	public void end() {
		driver.quit();
	}
	
	@Test
	public void tituloTest() {
		String titulo="Robobar - Futuristic drinks";
		assertTrue(titulo.equals(driver.getTitle()));
	}
	
	
	@Test
	public void valoresTest() {
		landing.clickCola();
		assertTrue(landing.valorActual().equals("€3.00"));
	}
	
}
