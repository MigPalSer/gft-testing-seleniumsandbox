package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.JomPeich;

public class BaseTest2 {

	protected WebDriver driver;
	protected JomPeich jomPeich;
	
	public void setUp(){
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://the-internet.herokuapp.com/");

	    jomPeich=new JomPeich(driver);
	    	}


	
	public static void main(String[] args) {
		BaseTest2 b= new BaseTest2();
		b.setUp();
		
	}
	
}
