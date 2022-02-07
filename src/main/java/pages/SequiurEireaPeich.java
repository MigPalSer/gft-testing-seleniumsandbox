package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SequiurEireaPeich {
	private WebDriver driver;

	public SequiurEireaPeich(WebDriver driver) {
		super();
		this.driver = driver;
	}

	private By statusAlert = By.id("flash");
	
	public String getAlertText(){
	     return driver.findElement(statusAlert).getText();
	}

	
}
